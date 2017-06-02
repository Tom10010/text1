package нд╪Ч;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputText_1 {

	public static void main(String[] args) throws IOException {
		FileOutputStream out = null;
		try{
		out = new FileOutputStream("E:/html/aaa.txt", true);
		String string = "zhanghongtao\n";
		out.write(string.getBytes());
		string = "\nshihaoren";
		out.write(string.getBytes());
		out.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}finally{
			if(out != null){
				try{
				out.close();
				}catch(IOException ex){
					ex.printStackTrace();
				}
			}
		}
	}

}
