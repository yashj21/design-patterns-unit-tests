package com.adapterpattern;

public class HardButton {
	public ButtonStates buttonStates;
	
	public HardButton(ButtonStates buttonStates) {
		this.buttonStates = buttonStates;
	}
	public void onClick() {
	buttonStates.onClick(buttonStates);
	}
	public void onRelease() {
	buttonStates.onRelease(buttonStates);
	}
}
