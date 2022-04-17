package ex01;

import java.util.Scanner;

class Program {

	public static void main( String[] args ) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		if ( !sc.hasNextInt() || ( n = sc.nextInt() ) < 2 ) {
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
