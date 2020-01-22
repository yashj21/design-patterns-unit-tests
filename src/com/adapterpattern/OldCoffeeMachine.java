package com.adapterpattern;

public class OldCoffeeMachine implements IOldCoffeeMachine {

	public void dispenseEspresso(HardButton pressButton) {
		System.out.println("Your choice is Espresso");
		pressButton.onClick();
		pressButton.onRelease();
	}

	public void dispenseCapuccino(HardButton pressButton) {
		System.out.println("Your choice is Cappucino");
		pressButton.onClick();
		pressButton.onRelease();
	}

}
