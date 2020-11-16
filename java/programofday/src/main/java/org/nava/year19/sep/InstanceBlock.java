package org.nava.year19.sep;

public class InstanceBlock {

	public static void main(String[] args) {
		new MangoTree();

	}

}

class Plant {

	static {
		System.out.println("Plant Static block is executed");

	}
	{
		System.out.println("Plant Instance block is executed");

	}

	public Plant() {
		System.out.println("This is plant");
	}
}

class Tree extends Plant {

	static {
		System.out.println("Tree Static block is executed");

	}
	{
		System.out.println("Tree Instance block is executed");

	}

	public Tree() {
		super();
		System.out.println("This is tree");
	}

}

class MangoTree extends Tree {

	static {
		System.out.println("MangoTree Static block is executed");

	}
	{
		System.out.println("MangoTree Instance block is executed");

	}

	public MangoTree() {
		super();
		System.out.println("This is mango Tree");
	}
}
