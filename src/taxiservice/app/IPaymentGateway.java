package taxiservice.app;


public interface IPaymentGateway {

	static final int SUCCESS = 0;
	static final int INVALID_CARD_DETAILS = 1;
	static final int INSUFFICIENT_BALANCE = 2;
	
	void connect();

	int charge(CreditCard creditCard, int amount);

}
