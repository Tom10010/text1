/**
 * 实验一
 * @Author：张洪涛
 * @Date：2017 2 27
 *    
 */

package sum;
import java.util.Scanner;

public class Sum {

	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please input the lenth of the array:");
		int num = sc.nextInt();
		int[] b = new int[num];
		System.out.println("Please input the elements of the array:");
		
		//input the elements of the array
		for(int i = 0; i < num; i++)
		{
			b[i] = sc.nextInt();		
		}
		 
		int sum = 0;
		//calculate
		for(int i = 0; i < num; i ++)
		{
			sum += b[i];
		}
		 
		System.out.println("Array sum=" + sum);
		System.out.println("Average value of the array is: " + sum / num);
		sc.close();
	}
		
}

