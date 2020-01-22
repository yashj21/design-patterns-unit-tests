package visitor;

public class CarLoan extends BankLoan {

    private String registrationNumber;
    private String runsOn;
    
    public CarLoan(int id, String name, int loanAmount, int months, float interestRate,
                String registrationNumber, String runsOn)
    {
        super(id, name, loanAmount, months, interestRate);
        this.registrationNumber = registrationNumber;
        this.runsOn = runsOn;
    }
    public void accept(Visitor v) {
		v.visitCarLoan(this);
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getRunsOn() {
		return runsOn;
	}

	public void setRunsOn(String runsOn) {
		this.runsOn = runsOn;
	}

	@Override
	public String toString() {
		return "CarLoan [id=" + id + ", name=" + name + ", loanAmount=" + loanAmount + ", months=" + months
				+ ", interestRate=" + interestRate + ", registrationNumber=" + registrationNumber + ", runsOn=" + runsOn
				+ "]";
	}

}
