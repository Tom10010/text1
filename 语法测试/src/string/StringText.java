package string;

public class StringText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aaa = "zhanghongtao";
		StringBuffer bbb = new StringBuffer("zhanghongtao");
		StringBuffer ccc = new StringBuffer("ruanjian");
		StringBuffer ddd = new StringBuffer("");
		System.out.println(aaa.indexOf('o'));
		System.out.println(aaa.substring(0, 5));
		System.out.println(aaa.substring(9));
		System.out.println(bbb.append(aaa));
		System.out.println(bbb.delete(12,24));
		System.out.println(bbb);
		System.out.println(bbb.capacity());
		System.out.println(bbb.append("shihaoren").capacity());
		System.out.println(ccc.capacity());
		System.out.println(ddd.capacity());
		System.out.println(bbb.length());

	}

}
