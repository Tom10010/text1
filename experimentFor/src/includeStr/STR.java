package includeStr;
import java.io.*;

public class STR {

	public static void main(String[] args) {
		list(new File("E:/html"), "html");
	}
	public static void list( File aFile, String ext){
		if(!aFile.isDirectory())
			return ;
		String [] files = aFile.list(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name){
				if(new File(dir, name).isDirectory())
					return false;
				return name.endsWith(ext);
			}
		});
		if(files == null) 
			return;
		for(String name : files)
		{
			System.out.println(name);
		}
	}

}
