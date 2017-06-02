package ³õÊ¼»¯Ë³Ðò;
class star{
	star(int m){
		System.out.println("star  " + m);
	}
	void fi(int m){
		System.out.println("star fi  " + m);
	}
}
class Flag{
	star s1 = new star(11);
	Flag(){
		System.out.println("Flag  ");
		s3 = new star(555);
		s3.fi(66);
	}
	static star s2 = new star(22);
	void f (){
		System.out.println("f()");
	}
	star s3 = new star(33);
}
public class InitOrder {
	star s1 = new star(1);
	public static void main(String[] args) {
		System.out.println(";reating new Flag()"); 
		Flag flag2 = new Flag();
		flag2.f();
		s2.fi(22);
		flag2.f();
		new InitOrder();
	}
	static star s2 = new star(2);
	static Flag flag1 = new Flag();

}
