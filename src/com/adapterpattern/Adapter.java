package com.adapterpattern;

public class Adapter implements ITouchInterface{
	private OldCoffeeMachine oldCoffeeMachine;
	

	public Adapter(OldCoffeeMachine oldCoffeeMachine) {
		this.oldCoffeeMachine = oldCoffeeMachine;
	}

	public void dispenseOldCoffee(SoftButton softButton) {
		HardButton button = convertSoftToHard(softButton);
		this.oldCoffeeMachine.dispenseCapuccino(button);
	}

	private HardButton convertSoftToHard(SoftButton softButton) {
		return new HardButton(new ReleaseState());
	}

	public void dispenseOldCoffe2(SoftButton softButton) {
		HardButton button = convertSoftToHard(softButton);
		this.oldCoffeeMachine.dispenseEspresso(button);
	}

	public void dispenseFromNew(SoftButton softButton) {
		
	}

}
