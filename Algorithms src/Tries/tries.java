package Practical8;

import java.util.Scanner;

public class tries {
	// Alphabet size (# of symbols) we pick 26 for English alphabet
	private static final int ALPHABET_SIZE = 26;
	
	// class for Trie node
	public static class TrieNode {
			
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		
		// isEndOfWord is true if the node represents end of a word i.e. leaf node
		boolean isEndOfWord;
		TrieNode(){
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
			}
		
		TrieNode getChildren(char letter) {
            return children[letter - 'a'];
		}
		
		void setEndOfWord(boolean isEndOfWord) {
            this.isEndOfWord = isEndOfWord;
        }
		
		boolean getEndOfWord() {
            return isEndOfWord;
        }

		void createChild(char letter) {
			children[letter - 'a'] = new TrieNode();
		}
	}
	
	public static TrieNode root;
	// If not key present, inserts into trie
	// If the key is prefix of Trie node,
	// marks leaf node
	public static void insert(String key){
        TrieNode current = root;
        
        for (char letter: key.toCharArray()) {
        	if (current.getChildren(letter) == null) {
        		current.createChild(letter);
        }
        current = current.getChildren(letter);
        }
        current.setEndOfWord(true);
		
	}
	
	// Returns true if key presents in trie, else false
	public static boolean search(String key) { 
        TrieNode current = root;
        
        for(int i = 0; i < key.length(); i++) {
        	char letter = key.charAt(i);
        	if (current.getChildren(letter) == null) {
                return false;
            }
            current = current.getChildren(letter);
        }
        
        return current.getEndOfWord();
	}
	//Driver
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt",
		"silver"};
				
		root = new TrieNode();
		
		// Construct trie
		for (String key : keys) {
            insert(key.toLowerCase());
        }
		
		// Search for different keys
		String key = "";
		while(!key.equals("stop")) {
			System.out.println("Enter key to search, or enter 'stop' to terminate");
			key = scanner.nextLine();
			if(key.equals("stop")) {
				break;
			} else {
				if(search(key) == true) {
					System.out.println(key+" IS present in trie");
				} else {
					System.out.println(key+" is NOT present in trie");
				}
			}
		}
	}
}