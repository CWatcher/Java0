package ex01;

import java.util.Scanner;

class Program {

	public static void main( String[] args ) {
		Scanner sc = new Scanner(System.in);
		int n = -1;
		if ( sc.hasNextInt() ) {
			n = sc.nextInt();
		}
		if ( n < 2 ) {
			System.out.println( "IllegalArgument" );
			System.exit( -1 );
		}

		boolean prime = true;
		int i;
		for ( i = 2; prime && i * i <= n; i++ ) {
			if ( n % i == 0 ) {
				prime = false;
			}
		};
		System.out.println( prime + " " + (i - 1) );
	}
}
