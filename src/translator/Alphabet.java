package translator;

import java.util.HashMap;

public class Alphabet {

	protected static final char[] ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	protected static final String[] MORSE = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",

			".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",

			"...-", ".--", "-..-", "-.--", "--.." };
	private static final HashMap<Character, String> CODE = new HashMap<>();
	
	public Alphabet() 
	{
		setCode();
//		System.out.println(CODE);
	}
	
	private void setCode()
	{
		for(int i = 0; i < MORSE.length && i < ALPHA.length; ++i)
		{
			CODE.put(ALPHA[i], MORSE[i]);
		} 
	}
	
	public char[] getAlpha() { return ALPHA; }
	
	public String[] getMorse() { return MORSE; }
	
	public HashMap<Character, String> getCode() { return CODE; }

	public String toString() { return "Running Alphabet"; }

}
