package ex03;

import java.util.Scanner;

public class Program {

	private static final String END = "42";
	private static final int TESTS_IN_A_WEEK = 5;

	private static int getMinimalGrade(Scanner scanner) {
		int minimalGrade = 9;
		int grade;
		for (int i = 0; i < TESTS_IN_A_WEEK; i++) {
			if (!scanner.hasNextInt()) {
				System.err.println("IllegalArgument");
				System.exit(-1);
			}
			grade = scanner.nextInt();
			if (grade < 1 || grade > 9) {
				System.err.println("IllegalArgument");
				System.exit(-1);
			}
			if (minimalGrade > grade)
				minimalGrade = grade;
		}
		return minimalGrade;
	}

	private static long getWeeklyGrades() {
		Scanner scanner = new Scanner(System.in);
		long grades = 0;
		long position = 1;
		for (int i = 1; i <= 18 ; i++) {
			String string = scanner.next();
			if (string.equals(END)) {
				break;
			}
			if (!string.equals("Week") || !scanner.hasNextInt()
				|| scanner.nextInt() != i) {
				System.err.println("IllegalArgument");
				System.exit(-1);
			}
			grades += position * getMinimalGrade(scanner);
			position *= 10;
		}
		return grades;
	}

	public static void main(String[] args) {
		long grades = getWeeklyGrades();
		for (int week = 1; grades > 0; week++) {
			System.out.print("Week " + week + " ");
			for (int i = 0; i < grades % 10; i++)
				System.out.print("=");
			System.out.println(">");
			grades /= 10;
		}
	}
}
