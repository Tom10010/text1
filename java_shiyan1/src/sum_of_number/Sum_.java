/**
 * 实验一
 * @Author：张洪涛
 * @Date：2017 2 27
 *    
 */

package sum_of_number;
import java.util.Scanner;
public class Sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("please input a number:");
		int number = sc.nextInt();
		int num = 0;
		number = Math.abs(number);
		while(number > 0)
		{
			num += number%10;
			number = number/10;
		}
		
		sc.close();
		System.out.println("The sum is:" + num);

	}

}
