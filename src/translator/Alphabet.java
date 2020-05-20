package translator;

import java.util.HashMap;

public class Alphabet {

	private static final char[] ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final String[] MORSE = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",

			".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",

			"...-", ".--", "-..-", "-.--", "--.." };
	private static final HashMap<Character, String> CODE = new HashMap<>();
	
	public Alphabet() 
	{
		CodeInstantiate();
	}
	
	private void CodeInstantiate()
	{
		for(int i = 0; i < MORSE.length && i < ALPHA.length; ++i)
		{
			CODE.put(ALPHA[i], MORSE[i]);
		}
	}
	
	public char[] getAlpha() { return ALPHA; }
	
	public String[] getMorse() { return MORSE; }

}
