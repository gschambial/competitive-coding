package com.catchexceptions.fibonacci;

import java.util.Scanner;

public class FibonacciRecursion {

	public static void main (String[] args) {
	    Scanner readerObj = new Scanner(System.in);
	    int testCases = readerObj.nextInt();
	    for(int i = 0; i < testCases; i++){
	        int number = readerObj.nextInt();
		    long fibonacciNumber = getFib(number);
		    //Doing Modulus here as fibonacci number can grow
		    //very large
		    System.out.println(fibonacciNumber % 1000000007);    
	    }
	    readerObj.close();
	}
	
	private static long getFib(int number){
	    if(number <= 1){
	        return number;
	    }
	    return getFib(number - 1) + getFib(number - 2);
	}

}
