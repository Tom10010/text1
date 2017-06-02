/**
 * 实验一
 * @Author：张洪涛
 * @Date：2017 2 27
 *    
 */

package narcissistic_number;

public class Narcissistic_number {

	public static void main(String[] args) {
		int num = 234;
		int a = num / 100;
		int b = (num-100*a)/10;
		int c = num % 10;
		if(Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3)  == num)
			System.out.println("The number '234' is a narcissistic number.");
		System.out.println("The number '234' isn't a narcissistic number.");

	}

}
