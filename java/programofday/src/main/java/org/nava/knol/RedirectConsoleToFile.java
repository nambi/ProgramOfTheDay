package org.nava.knol;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.*;
/**
 * 
 * @author nambi
 *
 */
public class RedirectConsoleToFile
{

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		PrintStream st = new PrintStream(new FileOutputStream("output.txt"));
		System.setOut(st);
		System.setErr(st);
		System.out.println("This is a test message");
		System.err.println("Error message");
	}

}
