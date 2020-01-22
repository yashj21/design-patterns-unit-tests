package visitor;

public class HomeLoan extends BankLoan {

    public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public int getPropertyValue() {
		return propertyValue;
	}
	
	public void accept(Visitor v) {
		v.visitHomeLoan(this);
	}

	public void setPropertyValue(int propertyValue) {
		this.propertyValue = propertyValue;
	}

	private String propertyAddress;
    private int propertyValue;

    public HomeLoan(int id, String name, int loanAmount, int months, float interestRate,
                String propertyAddress, int propertyValue)
    {
        super (id, name, loanAmount, months, interestRate);
        this.propertyAddress = propertyAddress;
        this.propertyValue = propertyValue;
    }

	@Override
	public String toString() {
		return "HomeLoan [id=" + id + ", name=" + name + ", loanAmount=" + loanAmount + ", months=" + months
				+ ", interestRate=" + interestRate + ", propertyAddress=" + propertyAddress + ", propertyValue="
				+ propertyValue + "]";
	}

}
