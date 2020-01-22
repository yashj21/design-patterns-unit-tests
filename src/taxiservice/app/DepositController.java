package taxiservice.app;


public class DepositController {
	private IPaymentGateway paymentGateway;
	private ICouponValidator couponValidator;
	
	public DepositController(IPaymentGateway paymentGateway, ICouponValidator couponValidator) {
		super();
		this.paymentGateway = paymentGateway;
		this.couponValidator = couponValidator;
	}
	
	public void deposit(Customer customer, CreditCard creditCard,int amount, 
			String coupon)throws PaymentgatewayNotSetException, CouponNotValidException, InvalidCouponException, InvalidCardDetailsException, InsufficientBalanceException, InvalidAmountException
	{
		
		if(paymentGateway==null)
		{
			throw new PaymentgatewayNotSetException();
		}
		
		if(couponValidator==null)
		{
			throw new CouponNotValidException();
		}
		int payback=0;
		if(coupon!=null)
		{
			payback=couponValidator.getPaybackAmount(coupon);
			if(payback==0)
			throw new InvalidCouponException();
		}
		
		paymentGateway.connect();
		int status = paymentGateway.charge(creditCard, amount);
		if(status==paymentGateway.INVALID_CARD_DETAILS){
			throw new InvalidCardDetailsException();
		}
		
		if(status==paymentGateway.INSUFFICIENT_BALANCE){
			throw new InsufficientBalanceException();
		}
		
		if(status == paymentGateway.SUCCESS){
			if(amount<=0){
				throw new InvalidAmountException();
			}
		}
		
		customer.deposit(amount+payback);
	}
	
	public void deposit(Customer customer, CreditCard creditCard,int amount)
	{
		
	}

}
