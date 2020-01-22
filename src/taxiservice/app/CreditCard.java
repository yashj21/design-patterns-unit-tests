package taxiservice.app;

public class CreditCard {
	private String cardNumber;
	private int validUptoMonth;
	private int validUptoYear;
	private int cvvNumber;
	
	public CreditCard(String cardNumber, int validUptoMonth, int validUptoYear, int cvvNumber) {
		super();
		this.cardNumber = cardNumber;
		this.validUptoMonth = validUptoMonth;
		this.validUptoYear = validUptoYear;
		this.cvvNumber = cvvNumber;
	}
}
