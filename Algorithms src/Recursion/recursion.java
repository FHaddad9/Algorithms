package Practical3;

import java.util.Scanner;
import java.lang.System;

public class recursion { 
	public static int fibonacciRecursion(int n) {
		// base case
		if(n <= 1) {
			return n;
		} else {
			// recursive case
			return fibonacciRecursion(n-1) + fibonacciRecursion(n-2);
		}
	}
	 
	public static int fibonacciIterative(int n){
		 if (n<=1) {
			 return 1;
		 }
		 
		 int fib = 1;
		 int prevFib = 1;
		 
		 for (int i = 2; i < n; i++) {
			 int temp = fib;
			 fib = fib + prevFib;
			 prevFib = temp;
		 }
		 return fib;
	}
	
	public static void main (String args[]){
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter number: ");
		 int n = scanner.nextInt();
		 
		 long startIter = System.nanoTime();
		 int iterative = fibonacciIterative(n);
		 long endIter = System.nanoTime();
		 long resultIter = endIter - startIter;
		 
		 long startRecu = System.nanoTime();
		 int recursive = fibonacciIterative(n);
		 long endRecu = System.nanoTime();
		 long resultRecu = endRecu - startRecu;

		 System.out.println("Iterative result: " + iterative +
				  " Time taken in nanoseconds: " + resultIter);
		 
		 System.out.println("Recursion result: " + recursive +
				  " Time taken in nanoseconds: " + resultRecu);
	}
}
