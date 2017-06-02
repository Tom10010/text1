package file;

import java.io.*;

public class FileExtFilter implements FilenameFilter{
	private String ext;
	public FileExtFilter(String ext){
		this.ext = ext;
	}

	@Override
	public boolean accept(File dir, String name) {
		if(new File(dir,name).isDirectory())
			return false;
		if(name.endsWith(ext))
			return true;
		return false;
	}

}

