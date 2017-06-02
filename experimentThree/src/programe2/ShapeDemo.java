package programe2;

public class ShapeDemo {

	public static void main(String[] args) {
		Shape shape1 = new Circle(5);
		Shape shape2 = new Rectangle(4, 5);
		Shape shape3 = new Triangle(3, 4, 5);
		System.out.println(shape1.area());
		System.out.println(shape1.perimeter());
		
		System.out.println(shape2.area());
		System.out.println(shape2.perimeter());
		
		System.out.println(shape3.area());
		System.out.println(shape3.perimeter());
	}  
}

interface Shape {
	double area();
	double perimeter();
}

class Circle implements Shape{
	private double r;
	public Circle(double r){
		this.r = r;
	}
	@Override
	public double area() {
		return Math.PI * r * r;
	}
	@Override
	public double perimeter() {
		return Math.PI * 2 * r;
	}
}

class Rectangle implements Shape{
	private double a;
	private double b;
	public Rectangle(double a, double b){
		this.a = a;
		this.b = b;
	}
	@Override
	public double area() {
		return a * b;
	}
	@Override
	public double perimeter() {
		return 2 * (a+b);
	}
}

class Triangle implements Shape{
	private double a;
	private double b;
	private double c;
	public Triangle(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public double area() {
		double s = (a+b+c)/2; 
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	@Override
	public double perimeter() {
		return a + b + c;
	}
}