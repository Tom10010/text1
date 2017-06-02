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
			System.out.println("学号输入有误，请重新输入。");
			text();
		}
		try{
			name = in.next();
		}catch (Exception e) {
			System.out.println("姓名输入有误，请重新输入。");
			text();
		}
		
		try{
			age = in.nextInt();
			}catch (Exception e) {
				System.out.println("学号输入有误，请重新输入。");
				text();
			}
		in.close();
	}

	public void tostring(){
		System.out.println("学号：" + ID);
		System.out.println("姓名：" + name);
		System.out.println("年龄：" + age);
	}

	public static void main(String[] args) {
		InputDemo in = new InputDemo();
		in.text();
		in.tostring();
	}
}
