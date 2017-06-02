package fileDemo;
import java.io.File;  
import java.util.ArrayList;  
import java.util.List;  
  
public class FileDemo {  
    private static void test(String fileDir) {  
        List<File> fileList = new ArrayList<File>();  
        File file = new File(fileDir);  
        File[] files = file.listFiles();
        if (files == null) {
            return;  
        }  
        for (File f : files) {  
            if (f.isFile()) {  
                fileList.add(f);  
            } 
            else if (f.isDirectory())
            {  
                System.out.println( "文件夹名：" + f.getName());  
                test(f.getAbsolutePath());  
            }  
        }  
        for (File f1 : fileList) {  
            System.out.println("文件名 : " + f1.getName() + "文件大小：" + f1.length()/1024.0 + "KB");  
        }  
    }  
  
    public static void main(String[] args) {  
        test("E:/python");  
    }  
}  
