package org.howard.edu.lsp.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;



public class WordCounterDriver {

	public static void main(String[] args) {
		/**
		 * Myles Block
		 */
		File file = new File("main.java.resource/words.txt");
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		
		try {
			Scanner scan = new Scanner(file);
			
			while (scan.hasNextLine()) {
				String line = scan.next().toLowerCase();
				
				String acceptedWord = line.replaceAll("[^a-zA-Z']", ""); //Removes anything that's not in the alphabet
				
				if (acceptedWord.length() > 3) {//Adds acceptedWord into map or +1 on its existence
					if (hashmap.get(acceptedWord) == null) {
						hashmap.put(acceptedWord, 1);
					}
					else {
						hashmap.put(acceptedWord, hashmap.get(acceptedWord) + 1);
					}
				}
			}
//			for (String name: hashmap.keySet()) {//this prints out the output of the file to the console
//				System.out.println(name + " " + hashmap.get(name).toString());
//			}
			scan.close();
			
			writeMapCountToFile(hashmap, "src/org/howard/edu/lsp/assignment2/final_word_count.txt");
			System.out.println("done");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeMapCountToFile(HashMap<String, Integer> hashmap, String filepath) {
		try {
            FileWriter writer = new FileWriter(filepath);
            
            for (HashMap.Entry<String, Integer> entry : hashmap.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
