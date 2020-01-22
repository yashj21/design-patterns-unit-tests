package taxiservice.app;

public class Customer {
	private String cellNumber;
	private int balance;
	
	public Customer(String cellNumber, int balance) {
		this.cellNumber = cellNumber;
		this.balance = balance;
	}

	public void deposit (int amount) {
		balance += amount;
	}
	
	public void spend (int amount) {
		balance -= amount;
	}
	
	public int getBalance () {
		return balance;
	}
}
