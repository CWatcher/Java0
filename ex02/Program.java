package ex02;

import java.util.Scanner;

public class Program {
	static final int LAST = 42;

	static int sumDigits(int number) {
		if (number < 0)
			number = -number;
		int divisor = 1000000000;
		int result = 0;
		while (number > 0) {
			result += number / divisor;
			number %= divisor;
			divisor /= 10;
		}
		return result;
	}

	static boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}
		int i;
		for (i = 2 ; number % i != 0 && i * i <= number; i++) {};
		return i * i > number;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number;
		int result = 0;
		while (scanner.hasNextInt() && (number = scanner.nextInt())!= LAST) {
			if (isPrime(sumDigits(number))) {
				result++;
			};
		}
		System.out.println("Count of coffee-request - " + result);
	}
}
