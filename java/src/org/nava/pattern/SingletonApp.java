package org.nava.pattern;

public class SingletonApp {

	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			MySingleton mySingleton = MySingleton.getInstance();
			System.out.println(mySingleton);
		}
	}

}

class MySingleton {

	private MySingleton() {
	}

	private static MySingleton instance = null;

	public static MySingleton getInstance() {
		if (instance == null) {
			synchronized (MySingleton.class) {
				if (instance == null) {
					instance = new MySingleton();
				}
			}
		}
		return instance;
	}

	public String toString() {
		return "MySingleton["+this.hashCode()+"]";
	}
}
