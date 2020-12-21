package terminal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import translator.*;

public class Tester {

	private static Scanner choice;
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
			new FileInput(inFile, outFile, bool);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void userInput()
	{
		System.out.println("Welcome to my Morse Code Translator!"
				+ "\nThe directory & options are listed below.\n");
		System.out.println("Directory:");
		FileInput input = new FileInput();
		choice = new Scanner(System.in);
		user = new Scanner(System.in);
		while(true)
		{
			System.out.println("\nOptions:\nWhich would you like to translate from: (m)orse or (e)nglish?");
			char type = choice.next().charAt(0);
			if(type == 'm')
			{
				boolean bool = true;
				System.out.println("Enter Morse code:\n"
						+ "(Seperate letters with spaces & use / to separate words)");
				String morse = user.nextLine();
				// System.out.println(input.manualInput(morse, bool));
				System.out.println("Translation of \"" + morse + "\":");
				for(String t : input.manualInput(morse, bool))
				{
					System.out.print(t + " ");
				}
			}
			else if(type == 'e')
			{
				boolean bool = false;
				System.out.println("Enter English:");
				String english = user.nextLine().toUpperCase();
				
				// System.out.println(input.manualInput(english, bool));
				System.out.println("Translation of \"" + english + "\":\n");
				for(String t : input.manualInput(english, bool))
				{
					System.out.print(t + " ");
				}
			}
			else
			{
				System.out.println("Wrong input");
			}
			
			System.out.println("\n\nWould you like to translate something else? (y/n)");
			if(choice.next().charAt(0) == 'n')
			{
				System.out.println("Closing program");
				break;
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		//Tester();
		try { loadFiles(args[0], args[1], args[2]); }
		catch(IOException io) { io.printStackTrace(); }
//		
//		userInput();
		
		// SUGGESTION:
		// Run the individual classes and create test cases for them to
		// to test for any errors in code or output
	}
	
}
