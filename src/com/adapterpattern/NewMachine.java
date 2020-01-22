package com.adapterpattern;

public class NewMachine {
	private Adapter convToOldAdap;
	public NewMachine(Adapter convToOldAdap) {
		this.convToOldAdap = convToOldAdap;
	}
	public void onClickFirst() {
		SoftButton softButton = new SoftButton();
		convToOldAdap.dispenseOldCoffee(softButton);
	}
	public void onClickSecond() {
		SoftButton softButton = new SoftButton();
		convToOldAdap.dispenseOldCoffe2(softButton);
	}
}
