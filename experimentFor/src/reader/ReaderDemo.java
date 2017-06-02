package reader;
import java.io.*;
public class ReaderDemo {

	public static void main(String[] args) throws IOException {
		ReaderDemo reader = new ReaderDemo();
		reader.readerfile("e:/aaa.c");
	}

	private void readerfile(String fileName ) throws IOException {
		Reader reader = null;
		try{
			reader = new FileReader(fileName);
			char[] c = new char[8 * 24];
			int len = 0;
			while((len  = reader.read(c)) != -1){
				System.out.println(new String(c, 0, len));
			}
		}
		finally{
			if(reader != null)
				reader.close();
		}

	}
}
