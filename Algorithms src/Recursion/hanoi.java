package Practical3;

import java.util.Scanner;

public class hanoi {
	public static void towersOfHanoi(int disk, String source, String dest, String auxiliary) {
        if (disk == 0) {
            System.out.println("move disk from " + source + " to " + dest);
        } else {
            towersOfHanoi(disk - 1, source, auxiliary, dest);
            towersOfHanoi(disk - 1, auxiliary, dest, source);
        }
    }
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of disks");
	    int disk = scanner.nextInt();
	    
        towersOfHanoi(disk, "source", "destination", "auxiliary");
        
        System.out.println("Number of moves: " + (int) (Math.pow(2, disk) - 1));
	}
}
