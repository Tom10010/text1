package writetofile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class WriteToFile {

	@SuppressWarnings("null")
	public static void write(String string){
		//创建输出流的引用
		OutputStream afileoutput = null;
		try{
			//讲输出流的引用指向文件输出流的对象
			afileoutput = new FileOutputStream("e:/OutputDemo.txt");
			//写进文件
			afileoutput.write(string.getBytes());
		}catch(IOException ex){
			ex.printStackTrace();
		}finally{
			if(afileoutput == null){
				try{
					//关闭文件
					afileoutput.close();
				}catch(IOException ex){
					ex.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		//定义string变量用来存放从控制台输入的内容
		String string = new String();
		//输入
		Scanner in = new Scanner(System.in);
		string = in.nextLine();
		//输入测试
		System.out.println(string);
		in.close();
		//写进文件
		write(string);

	}

}
