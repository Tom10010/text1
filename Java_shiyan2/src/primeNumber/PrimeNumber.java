package primeNumber;

public class PrimeNumber {

	private static int prime(int k) {
		int temp = 0;
		for(int i = 2; i < k; i++)
		{
			if((k*1.0) % i == 0)
			{
				temp = 1;
				break;
			}
		}
		return temp;
	}
	public static void main(String[] args) {
		for(int i = 100; i <= 200; i++)
		{
			if(prime(i) == 0)
				System.out.println(i);
		}

	}

}
