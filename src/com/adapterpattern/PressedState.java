package com.adapterpattern;

public class PressedState implements ButtonStates {

	public void onClick(ButtonStates buttonState) {
		System.out.println("Release for to start dispensing");
	}

	public void onRelease(ButtonStates buttonStates) {
		buttonStates = new ReleaseState();
		System.out.println("Dispensing coffee");
	}

}
