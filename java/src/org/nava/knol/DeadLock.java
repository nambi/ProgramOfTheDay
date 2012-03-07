package org.nava.knol;

public class DeadLock {
	String s;
	 public static void main(String args[]) 
	    { 
		 String s ="1";
		 String s1 ="1";
		  System.out.println(312 >> 4);
		  
		  
	        s run = new s(); 
	        Thread t1 = new Thread(run); 
	        Thread t2 = new Thread(run); 
	        t1.start(); 
	        t2.start(); 
	        
	        
	        Thread g = new Thread() 
	        {
	            public void run() 
	            {
	            	String a ="a";
	            	a.length();
	               System.out.println();
	            }
	        };
	    } 
	 
	 static int calculate(int n){
		 if(n <= 1){return 1;} else {return calculate(n-1)+n;}
	 }
}

 class  s implements Runnable 
{ 
    int x1, y1; 
    int w = (int)888.8;
    byte x = (byte)1000L;
    long y = (byte)100;
    byte z = (byte)100L;
    public void run() 
    { 
        for(int i = 0; i < 1000; i++) 
            synchronized(this) 
            { 
                x = 12; 
                y = 12; 
            } 
        System.out.print(x + " " + y + " "); 
    } 
   
}
