package com.state;

public class TurnstileUnlocked implements TurnstileState {

	@Override
	public void coinInserted(Turnstile t) {
		System.out.println("Thank you");
	}

	@Override
	public void passThrough(Turnstile t) {
		t.lock();
		t.setState(t.locked);
	}

}
