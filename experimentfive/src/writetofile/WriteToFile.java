package writetofile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class WriteToFile {

	@SuppressWarnings("null")
	public static void write(String string){
		//���������������
		OutputStream afileoutput = null;
		try{
			//�������������ָ���ļ�������Ķ���
			afileoutput = new FileOutputStream("e:/OutputDemo.txt");
			//д���ļ�
			afileoutput.write(string.getBytes());
		}catch(IOException ex){
			ex.printStackTrace();
		}finally{
			if(afileoutput == null){
				try{
					//�ر��ļ�
					afileoutput.close();
				}catch(IOException ex){
					ex.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		//����string����������Ŵӿ���̨���������
		String string = new String();
		//����
		Scanner in = new Scanner(System.in);
		string = in.nextLine();
		//�������
		System.out.println(string);
		in.close();
		//д���ļ�
		write(string);

	}

}
