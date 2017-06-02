package file;
import java.io.*;

public class FileListExtFiles{

	public static void main(String[] args){
		LList(new File("E:/debug"),"pdb");
	}
	public static void LList(File aFile,String ext){
		if(!aFile.isDirectory())
			return ;
		String[] files = aFile.list(new FileExtFilter(ext));
		if(files == null)
			return;
		for(String name:files){
			System.out.println(name);
		}
	}
}