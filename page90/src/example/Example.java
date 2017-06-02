package example;

public class Example {
	int shili;
	static int jingtai;

	public Example(int shili)
	{
		this.shili = shili;
	}
	public void shilifangfa()
	{
		System.out.println("这是实例方法");
		System.out.println("这是实例变量：" + shili);
		System.out.println("这是静态变量：" + jingtai + "\n");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jingtai = 32;
		Example e1 = new Example(23);
		Example e2 = new Example(12);
		e1.shilifangfa();
		e2.shilifangfa();
		
	}

}
