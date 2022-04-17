package ex02;

import java.util.Scanner;

public class Program {

	static int sumDigits( int n ) {
		if ( n < 0 )
			n = -n;
		int divisor = 1000000000;
		int r = 0;
		while ( n > 0 ) {
			r += n / divisor;
			n %= divisor;
			divisor /= 10;
		}
		return r;
	}

	static boolean isPrime( int n ) {
		if ( n < 2 ) {
			return false;
		}
		int i;
		for (i = 2 ; n % i != 0 && i * i <= n; i++ ) {};
		return i * i > n;
	}

	public static void main( String[] args ) {
		Scanner sc = new Scanner( System.in );
		int n;
		int r = 0;
		while ( sc.hasNextInt() && ( n = sc.nextInt() ) != 42 ) {
			if ( isPrime( sumDigits( n ) ) ) {
				r++;
			};
		}
		System.out.println( "Count of coffee-request - " + r );
	}
}
