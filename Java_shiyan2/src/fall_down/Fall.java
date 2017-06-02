package fall_down;

public class Fall {

	public static void main(String[] args) {
		double high = 100;
		double length = 100.0;
		for(int i = 0; i < 10; i++)
		{
			high = high/2.0;
			length += 2*high; 
		}
		System.out.println(length);

	}

}
