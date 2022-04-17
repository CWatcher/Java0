package ex01;

import java.util.Scanner;

class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = -1;
		if (scanner.hasNextInt()) {
			number = scanner.nextInt();
		}
		if (number < 2) {
			System.err.println("IllegalArgument");
			System.exit(-1);
		}
		int i = 2;
		for (; number % i != 0 && i * i <= number; i++) {};
		System.out.println((i * i > number) + " " + (i - 1));
	}
}
