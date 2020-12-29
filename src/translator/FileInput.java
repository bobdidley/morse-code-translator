package translator;

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileInput {

	private Sorter sort = new Sorter();
	private Scanner read;
	private FileWriter write;
//	private File in;
//	private File out;
	private ArrayList<String> words = new ArrayList<>();
	private ArrayList<String> morse = new ArrayList<>();
	
	public FileInput() {}
	
	public FileInput(String input, String output, boolean type) throws IOException
	{
		try {
			// debug
			System.out.println(toString());
			File in = new File(input);
			readFile(in, type);
			File out = new File(output);
			writeFile(out, type);
		} catch(IOException io) { System.out.println(io.getMessage()); io.printStackTrace(); }
		read.close();
		write.close();
	}
	
	private void readFile(File input, boolean type) throws IOException
	{
		read = new Scanner(input);
		
		// if true read Morse Code and store elements
		if(type)
		{
			while(read.hasNext())
			{
				morse.add(read.next());
			}
		}
		
		// else read letters and store as char variables
		else
		{
			read.useDelimiter("[!,'@?/s:;]");
			while(read.hasNext())
			{
				words.add(read.next());
			}
		}
		// debug
		System.out.println(toString());
	}
	
	private void writeFile(File output, boolean type) throws IOException
	{
		write = new FileWriter(output);
		
		// if true write Morse Code elements as letters in output file
		if(type)
		{
//			for(String s : morse)
//			{
				write.write(sort.toLetters(morse));
//			}
		}
		
		// else write letters as Morse Code in output file
		else
		{
			// FIX:
			// toMorse returns a string, figure how to maneuver around this
			for(String s : words)
			{
				write.write(sort.toMorse(s));
			}
		}
		// debug
		System.out.println(toString());
	}
	
	// in the case command line is not used then this method is used
	// returns the translation in an ArrayList to terminal to print output
	public ArrayList<String> manualInput(String manual, boolean bool)
	{
		ArrayList<String> translation = new ArrayList<>();
		manual = manual.toUpperCase();
		read = new Scanner(manual); 
		// translates morse to english
		if(bool)
		{
			while(read.hasNext())
			{
				// read.useDelimiter("[a-zA-Z]");
				words.add(read.next());
				// translation.add(sort.toLetters(read.next()));
			}
			translation.add(sort.toLetters(words));
		}
		// translates english to morse
		else
		{
			while(read.hasNext())
			{
				// read.useDelimiter("[^a-zA-Z]");
				// words.add(read.next());
				translation.add(sort.toMorse(read.next()));
			}
		}
		
//		for(String t : translation)
//		{
//			System.out.println(t + " ");
//		}
		// debug
//		System.out.println(toString());
		return translation;
	}

	public String toString()
	{
		return "Running FileInput";
	}
}
