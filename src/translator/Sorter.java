package translator;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Sorter {

	public Alphabet alpha = new Alphabet();
	private String translation;
	
	public Sorter() {}
	
	// sorts and concatenates morse letters into words to
	// be written on output file in FileInput class
	public String toLetters(ArrayList<String> morse)
	// public String toLetters(String morse)
	{
		StringBuilder word = new StringBuilder("");
		// searches through ArrayLists
		for(String m : morse)
		{
			// adds a space between words
			if(m.equals("/")) { word.append(" "); }
			// adds the character to the string
			for(Character a : alpha.getCode().keySet())
			{
				// comparison
				if(m.contentEquals(alpha.getCode().get(a)))
				{
					word.append(a);
				}
			}
			translation = word.toString();
		}
		System.out.println(toString());
		return translation;
	}
	
	// sorts and concatenates words into morse code to
	// be written on output file in FileInput class
	// public String toMorse(ArrayList<String> words)
	public String toMorse(String words)
	{
		StringBuilder word = new StringBuilder("");
		// searches through ArrayLists
		// for(String t : words)
		// {
			// t.toUpperCase();
		char[] letter = words.toCharArray();
		for(char l : letter)
		{
			for(Character m : alpha.getCode().keySet())
			{
				// comparison
				if((Character) l == m)
				{
					// word += alpha.getCode().get(m);
					// translation = alpha.getCode().get(m);
					word.append(alpha.getCode().get((Character)l) + " ");
				}
			}
			translation = word.toString();
		}
		System.out.println(toString());
		return translation;
	}
	
	public String toString()
	{
		return "Running Sorter";
	}
}
