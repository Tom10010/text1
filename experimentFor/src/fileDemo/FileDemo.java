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
                System.out.println( "�ļ�������" + f.getName());  
                test(f.getAbsolutePath());  
            }  
        }  
        for (File f1 : fileList) {  
            System.out.println("�ļ��� : " + f1.getName() + "�ļ���С��" + f1.length()/1024.0 + "KB");  
        }  
    }  
  
    public static void main(String[] args) {  
        test("E:/python");  
    }  
}  
