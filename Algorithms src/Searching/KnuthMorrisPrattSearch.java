package Practical7;

import java.util.Scanner;

public class KnuthMorrisPrattSearch {
	public static int kmpSearch(String txt, String pat) {
		int textLength = txt.length();
		int patLength = pat.length();
		
		// Holds the longest prefix suffix values for pattern 
		int[] lps =  new int[patLength];
		int j = 0;
		
		computeLPSArray(pat, patLength, lps);
		
		for(int i = 0; i < textLength; i++) {
			// Matches, returns index
			if(txt.charAt(i) == pat.charAt(j)) {
				if(j == patLength-1) {
					return i - j;
				} 
				j++;
			}
			
			// Mismatch after j matches
			else if(j != 0) {
				j = lps[j - 1];
				i--;
			} 
		}
		return -1;
	}
	
	// Preprocess the pattern
	private static void computeLPSArray(String pat, int patLength, int[] lps) {
		int len = 0;
		for(int i = 0; i < patLength; i++) {
			if(pat.charAt(i) == pat.charAt(len)) {
				lps[i] = len;
				len++;
			} else if(len != 0){
				len = lps[len - 1];
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter text: ");
		String txt = scanner.nextLine();
		System.out.println("Enter Pattern: ");
		String pat = scanner.nextLine();
		int index = kmpSearch(txt, pat);
		
		if(index == -1) {
			System.out.println(txt+" does not contain "+pat);
		} else {
			System.out.println(txt+" contains "+pat+" at index: "+index);
		}
		
	}
}
