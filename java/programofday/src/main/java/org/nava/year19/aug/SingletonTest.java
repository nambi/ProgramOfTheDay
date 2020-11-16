package org.nava.year19.aug;

public class SingletonTest {

	public static void main(String[] args) {

		Singleton test1 = Singleton.getInstance();

		Singleton test2 = Singleton.getInstance();

		if (test1 == test2) {
			System.out.println("Both are equal");
		}

	}

}

class Singleton {

	private static Singleton _instance = null;

	private Singleton() {
		System.out.println("when is this created? ");
	}

	public static Singleton getInstance() {

		if (_instance == null) {
			synchronized (Singleton.class) {
				if (_instance == null) {
					_instance = new Singleton();
					System.out.println("created instance");
				}
			}

		}
		return _instance;
	}

}