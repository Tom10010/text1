package inputDemo;
import java.util.*;
public class InputDemo {
	private int ID;
	private String name;
	private int age;
	
	public void text(){
		Scanner in = new Scanner(System.in);
		try{
		ID = in.nextInt();
		}catch (Exception e) {
			System.out.println("ѧ�������������������롣");
			text();
		}
		try{
			name = in.next();
		}catch (Exception e) {
			System.out.println("���������������������롣");
			text();
		}
		
		try{
			age = in.nextInt();
			}catch (Exception e) {
				System.out.println("ѧ�������������������롣");
				text();
			}
		in.close();
	}

	public void tostring(){
		System.out.println("ѧ�ţ�" + ID);
		System.out.println("������" + name);
		System.out.println("���䣺" + age);
	}

	public static void main(String[] args) {
		InputDemo in = new InputDemo();
		in.text();
		in.tostring();
	}
}
