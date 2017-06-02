package valueOf_Parse;

import java.util.Random;
import java.lang.Math;

public class ValueOF_Parse {

	public static void main(String[] args) {
		/*Integer aaa = new Integer(1232);
		Integer bbb = new Integer("125");
		int a = Integer.parseInt("12345");
		System.out.println(a);
		System.out.println(aaa);
		System.out.println(bbb);
		*/
		int[] aaa = new int[10];
		for(int i = 0; i < 10; i++)
		{
			aaa[i] = (int) Math.round(Math.random()*100);
			//System.out.println(aaa[i]);
		}
		Random r = new Random();
		for(int i = 0; i < 3; i++){
			System.out.print(r.nextInt() + "   ");
			System.out.print(r.nextBoolean() + "   ");
			System.out.println(r.nextInt(50) + "   ");	
		}

	}

}
