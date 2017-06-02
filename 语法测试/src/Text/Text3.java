package Text;
import string.StringText;
class com{
	com(int I){
		i = I;
	}
	int i;
}
public class Text3 {
	public static void main(String[] args){
		com c1 = new com(23);
		com c2 = new com(23);
		c1.i = c2.i = 23;
		System.out.println(c1 == c2);
		System.out.println(c1.equals(c2));
	}

}
