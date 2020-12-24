package terminal;

import translator.*;

public class Tester {
	/**
	 * Tests all the classes inherited
	 * 		Alphabet
	 * 		Sorter
	 * 		FileInput
	 * @param args - any files that can be translated
	 */
	public static void main(String[] args) {
		// TEST: Alphabet
		Alphabet aTest = new Alphabet();
		System.out.println(aTest.toString());
		System.out.println(aTest.getCode());
		System.out.println(String.join(" ", aTest.getMorse()));
		System.out.println(aTest.getAlpha());

		// TEST: Sorter
		Sorter sTest = new Sorter();
		System.out.println(sTest.toString());
		String demo = new String(aTest.getAlpha());
		String tran = sTest.toMorse(demo);
		System.out.println(tran);

		// TEST: FileInput
		FileInput fiTest = new FileInput();
		System.out.println(fiTest.toString());
		for(String d : fiTest.manualInput(demo, false)) {
			System.out.print(d);
		}
		System.out.println();
		for(String t : fiTest.manualInput(tran, true)) {
			System.out.print(t);
		}
	}
}