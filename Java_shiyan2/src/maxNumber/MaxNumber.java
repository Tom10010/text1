package maxNumber;
import java.util.Scanner;

public class MaxNumber {
	static double Max = 0;
	static double[] numbers;
	public MaxNumber(double[] number) {
		MaxNumber.numbers = number;
	}
	public static double max_number()
	{
		for(int i = 0; i < numbers.length; i++)
		{
			if (numbers[i] > Max)
			Max = numbers[i];
		}
		return Max;
	}		
	
	public static void main(String[] args) {
		int lenth1 = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("please input a number:");
		lenth1 = in.nextInt();
		double number[] = new double[lenth1];
		
		for(int i = 0; i < lenth1; i++ )
		{
			number[i] = in.nextDouble();
		}
		
		MaxNumber MAX = new MaxNumber(number);
		double max = MAX.max_number();
		System.out.println(max);
		in.close();
	}
}

