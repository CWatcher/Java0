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
			System.err.println( "IllegalArgument" );
			System.exit( -1 );
		}
		int i = 2;
		for ( ; n % i != 0 && i * i <= n; i++ ) {};
		System.out.println( (i * i > n) + " " + (i - 1) );
	}
}
