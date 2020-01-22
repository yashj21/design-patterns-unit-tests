package taxiservice.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.inOrder;
import org.mockito.InOrder;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;
import taxiservice.app.CouponNotValidException;
import taxiservice.app.CreditCard;
import taxiservice.app.Customer;
import taxiservice.app.DepositController;
import taxiservice.app.ICouponValidator;
import taxiservice.app.IPaymentGateway;
import taxiservice.app.InsufficientBalanceException;
import taxiservice.app.InvalidAmountException;
import taxiservice.app.InvalidCardDetailsException;
import taxiservice.app.InvalidCouponException;
import taxiservice.app.PaymentgatewayNotSetException;


@RunWith(MockitoJUnitRunner.class)
public class DepositControllerTest {

	@Mock
	ICouponValidator couponValidator;
	
	@Mock
	Customer customer;
	
	@Mock
	CreditCard creditCard;
	
	@Mock
	IPaymentGateway paymentGateway;
	
	//if IPaymentGateway is null
	@Test (expected=PaymentgatewayNotSetException.class)	
	public void misconfiguredControllerWithoutPaymentGateway() throws Exception{
		DepositController controller=new DepositController (null,couponValidator);
		try
		{
			controller.deposit(customer,creditCard,1000,"ADD100");
		}
		finally
		{
			verify(customer, never()).deposit(anyInt());
		}
		
	}
	
	//If ICouponValidator is null
	@Test (expected=CouponNotValidException.class)	
	public void misconfiguredControllerWithoutCouponValidator() throws  Exception{
		DepositController controller=new DepositController (paymentGateway,null);
		try
		{
			controller.deposit(customer,creditCard,1000,"ADD100");
		}
		finally
		{
			verify(customer, never()).deposit(anyInt());
		}
		
	}
	
	
	@Test(expected=InvalidCouponException.class)
	public void couponSaysZeroPaybackAmount()throws Exception
	{
		when(couponValidator.getPaybackAmount("ADD100")).thenReturn(0);
		DepositController controller=new DepositController(paymentGateway, couponValidator);
		{
			try{
				controller.deposit(customer, creditCard, 1000,"ADD100");				
			}
			finally
			{
				verify(customer,never()).deposit(anyInt());
			}
			
		}
	}
		
	@Test(expected=InvalidCardDetailsException.class)
	public void CardDetailsNotCorrect()throws Exception
	{
		when(couponValidator.getPaybackAmount(anyString())).thenReturn(100);
		when(paymentGateway.charge(any(CreditCard.class),anyInt())).thenReturn(IPaymentGateway.INVALID_CARD_DETAILS);
		DepositController controller=new DepositController(paymentGateway, couponValidator);
		try{
			
			controller.deposit(customer, creditCard, 1000,"ADD100");				
		}
		finally
		{
			verify(customer,never()).deposit(anyInt());
		}
	}
	
	@Test(expected=InsufficientBalanceException.class)
	public void InsufficientBalance()throws Exception
	{
		when(couponValidator.getPaybackAmount(anyString())).thenReturn(100);
		when(paymentGateway.charge(any(CreditCard.class),anyInt())).thenReturn(IPaymentGateway.INSUFFICIENT_BALANCE);
		DepositController controller=new DepositController(paymentGateway, couponValidator);
		try{
			
			controller.deposit(customer, creditCard, 1000,"ADD100");				
		}
		finally
		{
			verify(customer,never()).deposit(anyInt());
		}
	}
	
	@Test(expected=InvalidAmountException.class)
	public void ZeroAmount()throws Exception
	{
		when(couponValidator.getPaybackAmount(anyString())).thenReturn(100);
		when(paymentGateway.charge(any(CreditCard.class),anyInt())).thenReturn(IPaymentGateway.SUCCESS);
		DepositController controller=new DepositController(paymentGateway, couponValidator);
		try{
			
			controller.deposit(customer, creditCard, 0,"ADD100");				
		}
		finally
		{
			verify(customer,never()).deposit(anyInt());
		}
	}
	
	@Test(expected=InvalidAmountException.class)
	public void NegativeAmount()throws Exception
	{
		when(couponValidator.getPaybackAmount(anyString())).thenReturn(100);
		when(paymentGateway.charge(any(CreditCard.class),anyInt())).thenReturn(IPaymentGateway.SUCCESS);
		DepositController controller=new DepositController(paymentGateway, couponValidator);
		try{
			
			controller.deposit(customer, creditCard, -1000,"ADD100");				
		}
		finally
		{
			verify(customer,never()).deposit(anyInt());
		}
	}
	
	@Test
	public void OrderCallTest()throws Exception
	{
		when(couponValidator.getPaybackAmount(anyString())).thenReturn(100);
		when(paymentGateway.charge(any(CreditCard.class),anyInt())).thenReturn(IPaymentGateway.SUCCESS);
		DepositController controller=new DepositController(paymentGateway, couponValidator);
			
			controller.deposit(customer, creditCard, 20,"ADD100");	
			InOrder inOrder = inOrder(couponValidator,paymentGateway,customer);
			inOrder.verify(couponValidator).getPaybackAmount("ADD100");
			inOrder.verify(paymentGateway).connect();
			inOrder.verify(paymentGateway).charge(creditCard,20);
			inOrder.verify(customer).deposit(120);
		
	}
		
	

	
	
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
