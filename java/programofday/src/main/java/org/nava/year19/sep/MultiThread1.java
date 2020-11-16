package org.nava.year19.sep;

public class MultiThread1 {

	public static void main(String[] args) {

		Task1 taskInstance = new Task1(new LockObject());
		Thread t1 = new Thread(taskInstance);
		Thread t2 = new Thread(taskInstance);
		Thread t3 = new Thread(taskInstance);
		Thread t4 = new Thread(taskInstance);

		t2.start();
		t3.start();
		t4.start();
		t1.start();

	}

	static class Task1 implements Runnable {
		private LockObject lock;

		Task1(LockObject lo) {
			this.lock = lo;
		}

		public void run() {
			System.out.println("Task running with " + Thread.currentThread().getName());
			this.lock.compute();

		}
	}

	static class LockObject {

		int a;

		synchronized void compute() {
			int b = 0;
			while (a < 100) {
				System.out.println(b+Thread.currentThread().getName() + "-" + a);
				try {
					this.wait(100);
					this.notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				a++;
			}
		}
	}

}
