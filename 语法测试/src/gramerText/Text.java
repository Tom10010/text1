package gramerText;

public class Text {
	static int a = 0;
	public static char[] num;
	public int mun = 0;
	void aaa(){
		System.out.println("assssssssssssssssssssssssss");
	}
	static{
		a++;
		System.out.println("1    " + a);
	}
	static{
		a++;
		System.out.println("2    " + a);
	}
	public Text(){
		a++;
		System.out.println("gouzao    "+a);
	}
	static{
		a++;
		System.out.println("3    " + a);
	}
	public static void main(String[] args){
		Text t = new Text();
		System.out.println("main    " + a);
	}

}
