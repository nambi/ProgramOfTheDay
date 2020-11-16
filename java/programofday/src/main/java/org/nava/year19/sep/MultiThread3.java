package org.nava.year19.sep;

import java.util.Calendar;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThread3 {

	public static void main(String[] args) {

		singleThreadPool();

		fixedThreadPool();

		futureCall();
	}

	static void futureCall() {
		ExecutorService es = Executors.newFixedThreadPool(2);

		Callable<String> task = new Callable<String>() {

			public String call() {

				System.out.println("Callable Task is executed by " + Thread.currentThread().getName());
				String result = Thread.currentThread().getName() + "-" + Calendar.getInstance().getTime();
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return result;

			}
		};

		Future<String> result = es.submit(task);
		try {
			while (!result.isDone()) {
				System.out.println("waiting for future result");
			}
			String output = result.get();
			System.out.println(Calendar.getInstance().getTime() + " The future result " + output);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		es.shutdown();
	}

	static void fixedThreadPool() {
		ExecutorService es = Executors.newFixedThreadPool(2);

		Runnable task = new Runnable() {

			public void run() {

				System.out.println("Fixed Threadpool Task is executed by " + Thread.currentThread().getName());
			}
		};

		es.submit(task);
		es.submit(task);
		es.submit(task);

		es.shutdown();

	}

	static void singleThreadPool() {

		ExecutorService es = null;
		es = Executors.newSingleThreadExecutor();

		Runnable task = new Runnable() {

			public void run() {
				System.out.println("Task is executed by " + Thread.currentThread().getName());
			}
		};

		es.submit(task);
		es.submit(task);
		es.submit(task);

		es.shutdown();
	}

}
