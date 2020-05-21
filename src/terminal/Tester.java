package terminal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

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
			FileInput load = new FileInput(inFile, outFile, bool);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void userInput()
	{
		Sorter sort = new Sorter();
		FileInput input = new FileInput();
		choice = new Scanner(System.in);
		user = new Scanner(System.in);
		System.out.println("(m)orse or (e)nglish?");
		char type = choice.next().charAt(0);
		if(type == 'm')
		{
			boolean bool = true;
			System.out.println("Enter Morse code:");
			String morse = user.nextLine();
			for(String t : input.manualInput(morse, bool))
			{
				System.out.print(t + " ");
			}
		}
		else if(type == 'e')
		{
			boolean bool = false;
			System.out.println("Enter English:");
			String english = user.nextLine();
			ArrayList<String> translation = new ArrayList<>();
			
			System.out.println(input.manualInput(english, bool));
//			for(String t : input.manualInput(english, bool))
//			{
//				System.out.print(t + " ");
//			}
		}
		else
		{
			System.out.println("Wrong input");
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		// Tester();
		// try { loadFiles(args[0], args[1], args[2]); }
		// catch(IOException io) { io.printStackTrace(); }
		
		userInput();
	}

	
}
