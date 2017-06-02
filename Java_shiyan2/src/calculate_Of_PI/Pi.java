/**
 * @author уе╨Илн
 * 
 */
package calculate_Of_PI;

public class Pi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double PI = 0.0;
		int i = 1;
		while (true){
			PI += (1.0/(2*i-1))*Math.pow(-1, i);
			if((1.0/(2*i-1)) < 0.000001)
			{
				break;
			}
			i++;
		}
		System.out.print("PI Roughly equal: ");
		System.out.println(Math.abs(PI) * 4);
	}

}
