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
	private File in;
	private File out;
	private ArrayList<String> words;
	private ArrayList<String> morse;
	
	public FileInput() {}
	
	public FileInput(String input, String output, boolean type) throws IOException
	{
		in = new File(input);
		readFile(in, type);
		out = new File(output);
		writeFile(type);
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
			read.useDelimiter("[^a-zA-Z]");
			while(read.hasNext())
			{
				words.add(read.next());
			}
		}
	}
	
	private void writeFile(boolean type) throws IOException
	{
		write = new FileWriter(out);
		
		// if true write Morse Code elements as letters in output file
		if(type)
		{
			for(String s : sort.toLetters(morse))
			{
				write.write(s);
			}
		}
		
		// else write letters as Morse Code in output file
		else
		{
			for(String s : sort.toMorse(words))
			{
				write.write(s);
			}
		}
	}

}
