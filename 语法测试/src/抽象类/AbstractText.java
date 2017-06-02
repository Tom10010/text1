package ≥ÈœÛ¿‡;

abstract class father{
	void sleep(){
		System.out.println("normal sleep");
	}
	abstract void run();
}

class child1 extends father{
	void run(){
		System.out.println("my run 1");
	}
}

class child2 extends father{
	void run(){
		System.out.println("my run 2");
	}
}
class child3 extends father{
	void run(){
		System.out.println("my run 3");
	}
}
class AbstractText {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractText a = new AbstractText();
		father[] f = new father[3];
		f[0] = new child1();
		f[1] = new child2();
		f[2] = new child3();
		for(int i = 0; i < 3; i++){
			f[i].sleep();
			f[i].run();
		}
	}

}
