package нд╪Ч;
import java.io.*;
public class FileText {

	public static void main(String[] args) throws IOException {
		File file1 = new File("E:/aaa.c");
		File file2 = new File("E:/java");
		System.out.println(file1.canRead());
		System.out.println(file2.canRead());
		System.out.println(file1.canExecute());
		System.out.println(file2.canExecute());
		System.out.println(file1.canWrite());
		System.out.println(file2.canWrite());
		System.out.println(file1.length());
		System.out.println(file2.length());
		System.out.println(file1.getAbsolutePath());
		System.out.println(file2.createNewFile());
		System.out.println(file1.createNewFile());
		//new File("e:/zhang/hong/tao/shi.txt").createNewFile();
		for(String name:file2.list()){
			System.out.println(name);
		}
		File file3 = new File("E:/debug");
		for(String name : file3.list()){
			if(name.endsWith("pdb")){
				System.out.println(name);
			}
			
		}
	}

}
