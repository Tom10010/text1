package fibonacci;

public class Fibonacci {	
	public static void main(String[] args) {
		int Fin[] = new int[40];
		Fin[0] = 1;
		Fin[1] = 1;
		System.out.println(Fin[0]);
		System.out.println(Fin[1]);
		for(int i = 2; i < 40; i++)
		{
			Fin[i] = Fin[i-1] + Fin[i-2];
			System.out.println(Fin[i]);
		}

	}

}
