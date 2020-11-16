package org.nava.year19.sep;

import java.util.Calendar;

public class MultiThread2 {

	public static synchronized void main(String[] args) throws InterruptedException {

		Thread t = new Thread();
		t.start();
		System.out.println(Calendar.getInstance().getTime()+":X");
		synchronized(t) {
			t.wait(10000);
		}
		System.out.println(Calendar.getInstance().getTime()+":Y");
	}

}
