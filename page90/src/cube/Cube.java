package cube;

public class Cube {
	private double l;
	private double w;
	private double h;
	public Cube(double l, double w, double h)
	{
		this.l = l;
		this.w = w;
		this.h = h;
	}
	
	public double fuction()
	{
		return l*w*h;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cube c = new Cube(2,3,5);
		System.out.println(c.fuction());
	}

}
