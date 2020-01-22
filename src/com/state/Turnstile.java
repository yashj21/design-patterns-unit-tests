package com.state;

public class Turnstile {

	private String name;
	//private int state;
	///private final int LOCKED = 1;
	//private final int UNLOCKED = 2;
	private TurnstileState state ;
	public TurnstileState locked = new TurnstileLocked();
	public TurnstileState unlocked = new TurnstileUnlocked();
	public Turnstile(String name) {
		//this.name = name;		
		//state = LOCKED;
		state = locked;
		
//		System.out.println("Turnstile " + name + " created, in locked state initially");
	}
	public void setState(TurnstileState ts) {
				state = ts;
	}
	
	public void coinInserted() {
		System.out.println("Turnstile " + name + " : coin inserted\n");
//		if (state == LOCKED) {
//			output += unlock ();
//		} else {
//			output += "\tThank you for your generosity\n";
//		}
		
		state.coinInserted(this);

	}
	public void unlock() {
		System.out.println("\tUnlocking the turnstile " + name + "\n");
//		state = UNLOCKED;
//		return output;
	}

	public void passThrough() {
		System.out.println("Turnstile " + name + " : pass through\n");
		state.passThrough(this);
	}
//		String output = "Turnstile " + name + " : pass through\n";
//		if (state == UNLOCKED) {
//			output += lock ();
//		} else {
//			output += "\tRaising an alarm\n";
//		}
//		return output;	
//	}

	public void lock() {
		state = locked;
		System.out.println("\tLocking the turnstile " + name + "\n");
//		state = LOCKED;
//		return output;
	}

	public String getName() {
		return name;
	}

}
