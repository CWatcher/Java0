package ex04;

import java.util.Scanner;

public class Program {
	public static final short ChartSize = 10;
	static class CharFrequency {
		public char ch;
		public short fr;
	}
	public static void main(String[] args) {
		String s = new String(new Scanner(System.in).next());
		short[] frequencies = new short[(int)Character.MAX_VALUE];

		for (char ch: s.toCharArray())
			frequencies[(int)ch]++;

		CharFrequency[] charFrequencies = new CharFrequency[ChartSize];
		for (int i = 0; i < charFrequencies.length; i++)
			charFrequencies[i] = popMaxFrequency(frequencies);
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
