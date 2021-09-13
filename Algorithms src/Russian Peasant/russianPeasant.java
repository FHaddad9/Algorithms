package Practical2;

import java.util.Scanner;
import java.lang.System;

public class russianPeasant {
		
	public static long multiplyNumbers(long a, long b) {
		// Initialise result as 0
		long res = 0;
		
		while(b > 0) {
			if (b % 2 == 1) {
                res += a;
            }			
			a *= 2;
			b /= 2;	
		}
		
		return res;
	}
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		
	    System.out.println("Enter first number to multiply: ");
	    long a = scanner.nextLong();
	    System.out.println("Enter second number to multiply: ");
	    long b = scanner.nextLong();

	    long startTime = System.nanoTime();
	    
	    long result = multiplyNumbers(a, b);
	    
	    long endTime = System.nanoTime();
	    long resultTime = endTime - startTime;
	    
	    System.out.println("Result is: " + result);
	    System.out.println("Time taken in nanoseconds: "+resultTime);
	}
}
