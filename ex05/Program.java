package ex05;

import java.util.Scanner;

public class Program {

final static int STUDENTS_N_MAX = 10;
final static int HOURS_MAX = 6;
final static int DAYS_PER_WEEK = 7;
final static String[] weekDays = new String[]{"MO", "TU", "WE", "TH", "FR", "SA", "SU"};
final static int DAYS_IN_SEPTEMBER = 30;
final static int WEEK_OUTRUN = 1;

static String[] students = new String[STUDENTS_N_MAX];
static boolean[][] timetable = new boolean[DAYS_PER_WEEK][HOURS_MAX + 1];
static int[][][] attendances = new int[STUDENTS_N_MAX][DAYS_IN_SEPTEMBER + 1][HOURS_MAX + 1];

public static void main(String[] args) {
	init();
	printTimetable();
}

static void init() {
	Scanner sc = new Scanner(System.in);

	for (int i = 0; !sc.hasNext("\\."); i++)
		students[i] = sc.next();
	sc.next();

	while (!sc.hasNext("\\.")) {
		int hour = sc.nextInt();
		int weekDay = indexOf(weekDays, sc.next());
		timetable[weekDay][hour] = true;
	}
	sc.next();

	while (!sc.hasNext("\\.")) {
		int student = indexOf(students, sc.next());
		int hour = sc.nextInt();
		int dayOfMonth = sc.nextInt();
		attendances[student][dayOfMonth][hour] = sc.next().equals("HERE") ? 1 : -1;
	}
}

static int indexOf(String[] ss, String s) {
	for (int i = 0; i < ss.length; i++)
		if (s.equals(ss[i]))
			return i;
	return -1;
}

static void printTimetable() {
	for (int d = 1; d <= DAYS_IN_SEPTEMBER ; d++) {
		int weekDay = (d + WEEK_OUTRUN - 1) % DAYS_PER_WEEK;
		for (int h = 1; h <= HOURS_MAX; h++)
			if (timetable[weekDay][h])
				System.out.printf("%d:00 %s %2d|", h, weekDays[weekDay], d);
	}
	System.out.println();
}

}
