package com.adapterpattern;

public class StartMain {
	public static void main(String[] args) {
		OldCoffeeMachine oldCoffeeMachine = new OldCoffeeMachine();
		Adapter adapter = new Adapter(oldCoffeeMachine);
		NewMachine newCoffeMachine = new NewMachine(adapter);
		newCoffeMachine.onClickFirst();
		newCoffeMachine.onClickSecond();
	}
}
