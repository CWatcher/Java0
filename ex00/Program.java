package ex00;
class Program {

	public static void main(String[] args) {
		int number = -123456;
		number = (number + (number >> 31)) ^ (number >> 31);

		int	result = number % 10;
		result += (number /= 10) % 10;
		result += (number /= 10) % 10;
		result += (number /= 10) % 10;
		result += (number /= 10) % 10;
		result += (number / 10) % 10;

		System.out.println(result);
	}
}
