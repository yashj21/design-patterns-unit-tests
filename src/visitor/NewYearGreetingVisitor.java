package visitor;

public class NewYearGreetingVisitor implements Visitor {


public void visitCarLoan(CarLoan carLoan){
String message = "Hello " + carLoan.getName() + ",\n"
+ "Happy new year. Hope you are enjoying your new car with the following details: \n"
+ carLoan.getRegistrationNumber()  + " and runs on "  + carLoan.getRunsOn() +"\nRegards\n"
+ "++++++++++++++++++ ";
System.out.println(message);
}

public void visitHomeLoan(HomeLoan homeLoan){
String message = "Hello " + homeLoan.getName() + ",\n"
+ "Happy new year. Hope you are enjoying your new home with the following details: \n"
+ homeLoan.getPropertyAddress() + "\nRegards\n"
+ "++++++++++++++++++ ";
System.out.println(message);
}
}
