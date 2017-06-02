package extendText;
abstract class father{
	int aaa;
	String name;
	public father(int aaa, String name){
		this.aaa = aaa;
	}
	public father(){
		
	}
	
	
}
public class ExtendText extends father{
	int id;
	ExtendText(int AAA, int id, String name) {
		
		this.id = id;
		this.aaa = AAA;
		this.name = name;
	}
	
	public void bbb(){
			System.out.println(aaa);
	}
	public static void main(String[] args) {

		ExtendText e = new ExtendText(123,999, "zhang");
		e.bbb();
	}

}
