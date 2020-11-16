package org.nava.year19.sep;

public class TestInheritance extends Parent{

	public TestInheritance(String a) {
		super(a); //commenting out will not compile 
		System.out.println("Appa");
	}
	
	public static void main(String[] args) {
		
		new TestInheritance("Child");
	}

}

class Parent{
	public Parent(String a) {
		System.out.println("Amma");
	}
}
