package print;
import java.io.*;
public class Print {

	public static void main(String[] args) throws IOException {
		String file = "E:/aaa.c";
		Print print = new Print();
		print.readfile(file);
	}
	
	public void readfile(String filename) throws IOException{
		InputStream in = null;
		try{
			in = new FileInputStream(filename);
			int  b = 0;
			while(true){
				b = in.read();
				if(b == -1)
					break;
				System.out.print((char)b);
			}
		}
		finally {
			if(in != null){
				in.close();
			}
		}
	}
}
