package terminal;

import java.io.FileNotFoundException;

import translator.*;

public class Main {

	public Main() 
	{
		
	}
	
	public static void loadFiles(String args) throws FileNotFoundException
	{
		FileInput load = new FileInput(args, true);
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		try { loadFiles(args[0]); }
		catch(Exception io) { io.getMessage(); io.printStackTrace(); }
		
		
	}

}
