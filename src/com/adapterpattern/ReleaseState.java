package com.adapterpattern;

public class ReleaseState implements ButtonStates {

	public void onClick(ButtonStates buttonStates) {
		System.out.println("Starting dispensing coffee");
		buttonStates = new PressedState();
	}

	public void onRelease(ButtonStates buttonStates) {
		System.out.println("In the Same state");
	}

}
