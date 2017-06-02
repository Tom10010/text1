package popyphoto;

import java.io.*;

public class CopyPhoto {

	@SuppressWarnings("resource")
	public static void read_and_write() throws IOException{
		InputStream in = null;
		OutputStream out = null;
		try{
			out = new FileOutputStream("E:/java/sourse/photo1.jpg");
			in = new FileInputStream("e:/java/sourse/photo.jpg");
			byte[] bytes = new byte[1024];    
            int len = -1;    
            while((len=in.read(bytes))!=-1)  
            {    
                out.write(bytes, 0, len);    
            }   
		}finally {
			if(in != null)
				in.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		read_and_write();
	}

}
