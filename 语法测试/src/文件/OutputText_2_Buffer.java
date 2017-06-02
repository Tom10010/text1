package нд╪Ч;

import java.io.*;

public class OutputText_2_Buffer {

	public static void main(String[] args) throws IOException {
//		FileInputStream in = new FileInputStream("E:/aaa.c");
//		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("E:/html/aaa.txt"));
		
		
		BufferedReader in = new BufferedReader(new FileReader("E:/aaa.c"));
		PrintStream out = new PrintStream("E:/html/aaa.txt");
		String line = null;
		byte[] b = new byte[8*1024];
		while((line = in.readLine()) != null){
			out.println(line);
		}
		

	}

}
