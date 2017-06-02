package Max_and_second;

import java.util.Scanner;

public class Max {
	static double max = 0, second = 0;
	public static void compare(double[] numbers)
	{
		max = numbers[0];
		for(int i = 0; i < numbers.length; i++)
		{
			if(max < numbers[i]){
				max = numbers[i];
			}
		}
		
		second = numbers[0];
		for(int i = 0; i < numbers.length; i++)
		{
			if(second < numbers[i] && numbers[i] < max){
				second = numbers[i];
			}
		}
	}
	public static void main(String[] args)
	{
		int lenth1 = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("please input a number of the lenth:");
		lenth1 = in.nextInt();
		double number[] = new double[lenth1];
		
		for(int i = 0; i < lenth1; i++ )
		{
			number[i] = in.nextDouble();
		}
		
		compare(number);
		
		System.out.println("The maxnum is " + max);
		System.out.println("the second number is: " + second);
		in.close();
	}

}
