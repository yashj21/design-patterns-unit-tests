package visitor;

public abstract class BankLoan {

    protected int id;
    protected String name;
    protected int loanAmount;
    protected int months;
    protected float interestRate;
    public abstract void accept(Visitor v);
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public BankLoan(int id, String name, int loanAmount, int months, float interestRate)
    {
        this.id = id;
        this.name = name;
        this.loanAmount = loanAmount;
        this.months = months;
        this.interestRate = interestRate;
    }

}
