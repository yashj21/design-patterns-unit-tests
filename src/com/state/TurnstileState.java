package com.state;

public interface TurnstileState {
	void coinInserted(Turnstile t);
	void passThrough(Turnstile t);
}
