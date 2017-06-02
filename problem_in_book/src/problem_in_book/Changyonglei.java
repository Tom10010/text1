package problem_in_book;

class Common{
	int i = 0;
	Common(int i){
		this.i = i;
	}
}

public class Changyonglei {

	public static void main(String[] args) {
		// 4.7.1---------Object¿‡
		/*Common c1 = new Common(23);
		Common c2 = new Common(23);
		c1.i = c2.i = 10;
		System.out.println(c1==c2);
		System.out.println(c1.equals(c2) + "\n");
		Integer n1 = new Integer(23);
		Integer n2 = new Integer(23);
		System.out.println(n1 == n2);
		System.out.println(n1.equals(n2));
		*/
		//4.7.2---------String ∫Õ StringBuffer
		String s1 = new String("good");
		System.out.println(s1);
		String s2 = "good morning";
		System.out.println(s1.length());
		System.out.println(s2.length());
		System.out.println(s2.compareTo(s1));
		System.out.println(s2.endsWith("ing"));
		System.out.println(s2.startsWith("good"));
		System.out.println(s2.replace('g','G'));
		System.out.println(s2.substring(2,6));
		s2 = s2.replace('g', 'G');
		System.out.println(s2);
		String s3 = " aaaaaa ";
		System.out.println(s3);
		System.out.println(s3.trim());
		
	}

}
