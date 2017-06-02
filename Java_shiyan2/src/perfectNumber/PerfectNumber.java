package perfectNumber;

public class PerfectNumber {

	public static int perfect(int num)
	{
		int NUM = 0;
		for(int i = 1; i <= num/2.0; i++)
		{
			if(num % i ==0)
			{
				NUM += i;
			}
		}
		if(NUM == num)
		return 0;
		return 1;
	}
	public static void main(String[] args) {
		for(int i = 1; i < 1000; i++)
		{
			if(perfect(i) == 0)
			{
				System.out.println(i);
			}
		}

	}

}
