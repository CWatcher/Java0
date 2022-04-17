package ex01;

import java.util.Scanner;

class Program {

	public static void main( String[] args ) {
		int n = new Scanner(System.in).nextInt();

		if ( n < 2 ) {
			System.out.println( "IllegalArgument" );
			System.exit( -1 );
		}
		int i = 2;
		for ( ; n % i != 0 && i * i <= n; i++ ) {};
		if ( i * i > n )
			System.out.println( true + " " + (i - 1) );
		else
			System.out.println( false + " " + (i - 1) );
	}
}
