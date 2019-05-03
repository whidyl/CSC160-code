/* (Count characters, words, and lines in a file) Write a program that will count the number of characters, 
 * words, and lines in a file. Words are separated by whitespace characters. The file name should be passed 
 *         as a command-line argument
 */
import java.io.*;
import java.util.*;

public class FileCounter {
	
	public static void main(String args[]) {
		File file = new File(args[0]);
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		int numLines = 0;
		String[] lines = fileScanner.toString().split("\n");
		for (String line : lines) {
			System.out.println(lines[numLines]);
			numLines += 1;
		}
		System.out.println(numLines);
	}

}
