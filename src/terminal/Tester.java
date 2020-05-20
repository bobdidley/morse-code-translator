package terminal;

import java.io.FileNotFoundException;
import java.io.IOException;

import translator.*;

public class Tester {

	
	public Tester() {}
//	{
//		System.out.println("Morse Code Translator\n\nValues to enter:\nInput file\nOutput file"
//				+ "\n\"true\" for Morse to English or \"false\" for English to Morse");
//	}
	
	public static void loadFiles(String inFile, String outFile, String bool) throws FileNotFoundException
	{
		boolean type = false;
		if(bool.equals("true")) { type = true; }
		else if(bool.equals("false")) { type = false; }
		
		// catch error
		else { System.out.println("Incorrect boolean input"); }
		try {
			FileInput load = new FileInput(inFile, outFile, type);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		// Tester();
		try { loadFiles(args[0], args[1], args[2]); }
		catch(IOException io) { io.printStackTrace(); }
		
		
	}

}
