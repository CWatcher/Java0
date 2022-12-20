package ex04;

import java.util.Scanner;

public class Program {
	static final short	WIDTH = 10;
	static final short	HEIGHT = 10;
	static final char	SYMBOL = '#';

	static int[] charFrequencies = new int[Character.MAX_VALUE];
	public static void main(String[] args) {
		String s = new Scanner(System.in).next();
		char[] mostFrequentChars = getMostFrequentChars(s, WIDTH);
		char mostFrequentChar = mostFrequentChars[0];

		String WidthFormat = "%4";
		if (charFrequencies[mostFrequentChar] < 10)
			WidthFormat = "%2";
		else if (charFrequencies[mostFrequentChar] < 100)
			WidthFormat = "%3";

		System.out.println();
		for (int j = 0; j < HEIGHT + 2; j++) {
			for (int i = 0; i < mostFrequentChars.length; i++) {
				int height = charFrequencies[mostFrequentChars[i]] * HEIGHT / charFrequencies[mostFrequentChar];
				if (j == HEIGHT - height)
					System.out.printf(WidthFormat + 'd', charFrequencies[mostFrequentChars[i]]);
				else if (j == HEIGHT + 1)
					System.out.printf(WidthFormat + 'c', mostFrequentChars[i]);
				else if (j > HEIGHT - height)
					System.out.printf(WidthFormat + 'c', SYMBOL);
			}
			System.out.println();
		}
	}
	static char[] getMostFrequentChars(String s, short n) {
		short	nChars = 0;

		// Push character frequencies of the string to frequencies[]
		for (char ch: s.toCharArray())
			if (charFrequencies[ch]++ == 0)
				nChars++;
		// Pop most frequent character frequencies from frequencies[] to mostFrequentChars[]
		char[] mostFrequentChars = new char[n < nChars ? n : nChars];
		for (int i = 0; i < mostFrequentChars.length; i++)
			mostFrequentChars[i] = popMostFrequentChar(charFrequencies);
		// Unhide the most frequent chars
		for (char ch = 0; ch < charFrequencies.length; ch++)
			if (charFrequencies[ch] < 0)
				charFrequencies[ch] = -charFrequencies[ch];
		return mostFrequentChars;
	}
	static char popMostFrequentChar(int[] frequencies) {
		char mostFrequentChar = 0;
		for (char ch = 0; ch < frequencies.length; ch++)
			if (frequencies[ch] > frequencies[mostFrequentChar])
				mostFrequentChar = ch;
		// Hide the most frequent char
		frequencies[mostFrequentChar] = -frequencies[mostFrequentChar];
		return mostFrequentChar;
	}
}
