package com.state;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Turnstile;

public class TurnstileTest {

	@Test
	public void testTurnstile() {
		Turnstile t1 = new Turnstile("t1");
		
//		String output = t1.coinInserted();
//		output += t1.passThrough();
//		output += t1.coinInserted();
//		output += t1.coinInserted();
//		output += t1.passThrough();
//		output += t1.passThrough();
//
		// System.out.println(output);
		
		String expected = "Turnstile t1 : coin inserted\n" +
				"	Unlocking the turnstile t1\n" +
				"Turnstile t1 : pass through\n" +
				"	Locking the turnstile t1\n" +
				"Turnstile t1 : coin inserted\n" +
				"	Unlocking the turnstile t1\n" +
				"Turnstile t1 : coin inserted\n" +
				"	Thank you for your generosity\n" +
				"Turnstile t1 : pass through\n" +
				"	Locking the turnstile t1\n" +
				"Turnstile t1 : pass through\n" +
				"	Raising an alarm\n";
		
		//assertTrue (expected.equals(output));
		
	}

}
