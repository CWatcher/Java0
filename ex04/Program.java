package ex04;

import java.util.Scanner;

public class Program {
	static final short	WIDTH = 10;
	static final short	HEIGHT = 10;
	static final char	SYMBOL = '#';
	static final String	NUM_FORMAT = "%3d";
	static final String	SPACER = "  ";
	static class CharFrequency {
		public char ch;
		public short fr;
	}
	public static void main(String[] args) {
		String s = new String(new Scanner(System.in).next());
		CharFrequency[] charFrequencies = getMostFrequentChars(s, WIDTH);

		System.out.println();
		for (int j = 0; j < HEIGHT + 2; j++) {
			for (int i = 0; i < WIDTH; i++) {
				int height = charFrequencies[i].fr * HEIGHT / charFrequencies[0].fr;
				if (j == HEIGHT - height)
					System.out.printf(NUM_FORMAT, charFrequencies[i].fr);
				else if (j == HEIGHT + 1)
					System.out.print(SPACER + charFrequencies[i].ch);
				else if (j > HEIGHT - height)
					System.out.print(SPACER + SYMBOL);
			}
			System.out.println();
		}
	}
	static CharFrequency[] getMostFrequentChars(String s, short n) {
		short[] frequencies = new short[(int)Character.MAX_VALUE];

		// Push character frequencies of the string to frequencies[]
		for (char ch: s.toCharArray())
			frequencies[(int)ch]++;

		// Pop most frequent character frequencies from frequencies[] to charFrequencies[]
		CharFrequency[] charFrequencies = new CharFrequency[n];
		for (int i = 0; i < charFrequencies.length; i++)
			charFrequencies[i] = popMaxFrequency(frequencies);
		return charFrequencies;
	}
	static CharFrequency popMaxFrequency(short[] frequencies) {
		CharFrequency charFrequency = new CharFrequency();
		for (int i = 0; i < frequencies.length; i++)
			if (frequencies[i] > charFrequency.fr) {
				charFrequency.ch = (char)i;
				charFrequency.fr = frequencies[i];
			}
		frequencies[(int)charFrequency.ch] = 0;
		return charFrequency;
	}
}
