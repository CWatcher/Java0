package ex04;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		String s = new String(new Scanner(System.in).next());
		short[] frequencies = new short[(int)Character.MAX_VALUE];

		for (char ch: s.toCharArray())
			frequencies[(int)ch]++;
	}
}
