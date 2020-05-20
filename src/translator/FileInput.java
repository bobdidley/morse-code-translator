package translator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class FileInput {

	private FileReader read;
	private FileWriter write;
	private File in;
	private File out;
	
	public FileInput() {}
	
	public FileInput(String input, boolean type) throws FileNotFoundException
	{
		in = new File(input);
		readFile(in, type);
		writeFile(type);
	}
	
	private void readFile(File input, boolean type) throws FileNotFoundException
	{
		// if true read Morse Code and store elements
		// else read letters and store as char variables
	}
	
	private void writeFile(boolean type) throws FileNotFoundException
	{
		// if true write Morse Code elements as letters in output file
		// else write letters as Morse Code in output file
	}

}
