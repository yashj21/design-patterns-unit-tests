package com.state;

public class TurnstileLocked implements TurnstileState {

	public void coinInserted(Turnstile t) {
		t.unlock();
		t.setState(t.unlocked);
	}
	public void passThrough(Turnstile t) {
		System.out.println("Raise Alarm");
	}
}
