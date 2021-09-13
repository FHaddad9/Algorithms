package Practical7;

import java.util.Scanner;

public class BruteForce {
	public static int bfSearch(String txt, String pat) {
		int textLength = txt.length();
		int patternLength = pat.length();
		int j = 0;
		
		for(int i = 0; i < textLength-patternLength; i++) {
			
			while(j < patternLength) {
				if(txt.charAt(i + j) != pat.charAt(j)) {
					break;
				}
				j++;
			}
			
			if(j == patternLength) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter text: ");
		String txt = scanner.nextLine();
		System.out.println("Enter pattern: ");
		String pat = scanner.nextLine();
		
		int index = bfSearch(txt, pat);
		
		if(index == -1) {
			System.out.println(txt+" does not contain "+pat);
		} else {
			System.out.println(txt+" contains "+pat+" at index: "+index);
		}
	}
}
