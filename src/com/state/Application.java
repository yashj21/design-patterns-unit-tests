package com.state;

public class Application {

	public static void main(String[] args) {
		
		Turnstile t1 = new Turnstile("t1");
		Turnstile t2 = new Turnstile("t2");
		Turnstile t3 = new Turnstile("t3");
		
		/*System.out.println(*/t1.coinInserted();
		t1.passThrough();
		t1.coinInserted();
		t1.coinInserted();
		t1.passThrough();
		t1.passThrough();
//		System.out.println(t1.passThrough());
//		System.out.println(t1.coinInserted());
//		System.out.println(t1.coinInserted());
//		System.out.println(t1.passThrough());
//		System.out.println(t1.passThrough());
	}

}
