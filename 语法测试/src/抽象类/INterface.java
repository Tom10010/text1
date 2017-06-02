package 抽象类;

interface aaa{
	public void mina();
}

public class INterface implements aaa{

	public void mina(){
		System.out.println("aaaaa");
	}
	public INterface() {
		// TODO 自动生成的构造函数存根
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		aaa a;
		float f = 8/3;
		double d  = 2.0;
		long a1 = 321321321321L;
		float aaa = 8/3;
		float bbb = 8/3f;
		float ccc = 3.1F;
		System.out.println(aaa);
		System.out.println(bbb);
		System.out.println(ccc);
	}

}
