class Program {
	public static void main(String[] args) {
		int n = -123456;
		if (n < 0)
			n = - n;
		int divisor = 100000;
		int	sum = 0;
		while (n > 0) {
			int digit = n / divisor;
			sum += digit;
			n -= divisor * digit;
			divisor /= 10;
		}
		System.out.println( sum );
	}
}
