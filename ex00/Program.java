class Program {

	public static void main(String[] args) {
		int n = -123456;
		n = (n + (n >> 31)) ^ (n >> 31);

		int	r = n % 10;
		r += (n /= 10 ) % 10;
		r += (n /= 10 ) % 10;
		r += (n /= 10 ) % 10;
		r += (n /= 10 ) % 10;
		r += (n / 10 ) % 10;

		System.out.println( r );
	}
}
