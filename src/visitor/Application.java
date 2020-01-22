package visitor;

import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		ArrayList <BankLoan> accounts = new ArrayList <BankLoan> ();
		
        HomeLoan homeLoan1 = new HomeLoan(1, "abhay", 500000, 12, 6.5f, "baner road", 800000);
        accounts.add(homeLoan1);

        HomeLoan homeLoan2 = new HomeLoan(2, "bharat", 1000000, 24, 6.5f, "aundh", 1200000);
        accounts.add(homeLoan2);

        CarLoan carLoan1 = new CarLoan(11, "chandra", 400000, 18, 7.25f, "MH-02-BR-4027", "petrol");
        accounts.add(carLoan1);

        CarLoan carLoan2 = new CarLoan(12, "durga", 600000, 18, 7.250f, "MH-12-AB-1234", "diesel");
        accounts.add(carLoan2);

        for (BankLoan loan: accounts) {
        	System.out.println(loan);
        }
        Visitor visitor = new NewYearGreetingVisitor();
        for (BankLoan loan : accounts) {
        	loan.accept(visitor);
        }
	}

}
