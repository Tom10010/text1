package 文件;
import java.io.*;
public class FileInput {

	//字节流
	public void readfile() throws IOException{
		//FileInputStream in = new FileInputStream("E:/aaa.c");
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("E:/aaa.c"));
		int len = 0;
		byte[] b = new byte[1024];
		while((len = in.read(b)) != -1){
			System.out.print(new String(b, 0, len));
			}
		in.close();
	}
	
	//字符流
	public void ReadFile() throws IOException{
		FileReader reader = new FileReader("E:/aaa.c");
		int len = 0;
		char[] c = new char[8*1024];
		while((len = reader.read(c)) != -1){
			System.out.println(new String(c, 0, len));
		}
		reader.close();
	}
	
	//字符缓冲流
		public void BufferFile() throws IOException{
			BufferedReader reader = new BufferedReader(new FileReader("E:/aaa.c"));
			String line = null;
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
			reader.close();
		}
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInput F = new FileInput();
//		F.readfile();
//		F.ReadFile();;
		F.BufferFile();
	}

}
