package translator;

import java.util.ArrayList;

public class Sorter {

	private Alphabet alpha = new Alphabet();
	private ArrayList<String> translation;
	
	public Sorter() {}
	
	// sorts and concatenates morse letters into words to
	// be written on output file in FileInput class
	public ArrayList<String> toLetters(ArrayList<String> morse)
	{
		// SUGGESTION:
		// add single characters to String then add the word to ArrayList
		String word = "";
		// searches through ArrayLists
		for(String m : morse)
		{
			for(String a : alpha.getCode().values())
			{
				// comparison
				if(m.contentEquals(a))
				{
					translation.add(alpha.getCode().get(a));
				}
			}
		}
		return translation;
	}
	
	// sorts and concatenates words into morse code to
	// be written on output file in FileInput class
	public ArrayList<String> toMorse(ArrayList<String> words)
	{
		// SUGGESTION:
		// add single characters to String then add the word to ArrayList
		String word = "";
		// searches through ArrayLists
		for(String t : words)
		{
			char[] letter = t.toCharArray();
			for(char l : letter)
			{
				for(char m : alpha.getCode().keySet())
				{
					// comparison
					if(l == m)
					{
						word += alpha.getCode().get(m);
					}
				}
			}
		}
		return translation;
	}
	
}
