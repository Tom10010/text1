package narcissisicNumber;
public class NarcissisticNumber {
	public static int Narcissistic(int number) {
		//Digit separation
		int a = number/100;
		int b = (number - 100*a)/10;
		int c = number%10;
		if((Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3)) == number)
			return 0;
		else
			return 1;
	}

	public static void main(String[] args) 
	{
		for(int i = 100; i < 999; i++)
		{
			if(Narcissistic(i) == 0)
			{
				//output the result
				System.out.println(i);
			}
		}
	}

}
