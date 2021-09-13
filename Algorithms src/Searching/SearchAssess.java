package Practical7;

import java.lang.System;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchAssess {
	public static void main(String[] args) throws FileNotFoundException{
		File file = new File("src/Practical7/inputs.txt");
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()) {
			String pat = "algorithms";
            String text = scanner.nextLine();
            
			long startBF = System.nanoTime();
			int indexBF = BruteForce.bfSearch(text, pat);
			long endBF = System.nanoTime();
			long resultBF = endBF - startBF;
			
			long startKMP = System.nanoTime();
			int indexKMP = KnuthMorrisPrattSearch.kmpSearch(text, pat);
			long endKMP = System.nanoTime();
			long resultKMP = endKMP - startKMP;
			
			System.out.println("\nBrute Force: ");
			if(indexBF == -1) {
				System.out.println("\""+text+"\""+" does not contain "+"\""+pat+"\"");
			} else {
				System.out.println("\""+text+"\""+" contains "+"\""+pat+"\""+" at index: "+indexBF);
			}
			System.out.println("Time taken nanoseconds: "+resultBF);
			
			
			System.out.println("Knuth Morris Pratt Search: ");
			if(indexKMP == -1) {
				System.out.println("\""+text+"\""+" does not contain "+"\""+pat+"\"");
			} else {
				System.out.println("\""+text+"\""+" contains "+"\""+pat+"\""+" at index: "+indexKMP);
			}
			System.out.println("Time taken nanoseconds: "+resultKMP);
		}
	}
}
