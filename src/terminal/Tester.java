package terminal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import translator.*;

public class Tester {

	private static Scanner user;
	
	public Tester() {}
//	{
//		System.out.println("Morse Code Translator\n\nValues to enter:\nInput file\nOutput file"
//				+ "\n\"true\" for Morse to English or \"false\" for English to Morse");
//	}
	
	public static void loadFiles(String inFile, String outFile, String type) throws FileNotFoundException
	{
		boolean bool = false;
		if(type.equals("mor")) { bool = true; }
		else if(type.equals("eng")) { bool = false; }
		
		// catch error
		else { System.out.println("Incorrect boolean input"); }
		
		try {
			FileInput load = new FileInput(inFile, outFile, bool);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void userInput()
	{
		Sorter sort = new Sorter();
		FileInput input = new FileInput();
		user = new Scanner(System.in);
		char type = user.next().charAt(0);
		if(type == 'm')
		{
			boolean bool = true;
			String morse = user.nextLine();
			input.manualInput(morse, bool);
		}
		else if(type == 'e')
		{
			boolean bool = false;
			String english = user.nextLine();
			input.manualInput(english, bool);
		}
		else
		{
			
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		// Tester();
		try { loadFiles(args[0], args[1], args[2]); }
		catch(IOException io) { io.printStackTrace(); }
		
		
	}

	
}
