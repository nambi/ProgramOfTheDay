package org.nava.knol;

public class CodeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  class H1{
			  String name = null;
		 }
		  H1 h1 = new H1();
		  System.out.println(h1.name);
		// TODO Auto-generated method stub
		int x =0;
		for(x =0;x<5;x++){
			if(x==5){
				System.out.println("This is a test");
			}
		}
		System.out.println(x);
		
		String[] st = {"one","two","three"};
		for(int i=0;i<st.length;i++){
			System.out.println("st["+i+"] :"+st[i]);
		}
		
		int num = 0xFFFFFFE;
		for(int i=0;i<4;i++){
			num = num <<1;
			System.out.println(num);
		}
		
		System.out.println(true|false);
		
		System.out.println(true&false);
		
		
		System.out.println(true^false);
		
		System.out.println(true&false|true&!false);
		
		System.out.println("//looks like");
	}

}

