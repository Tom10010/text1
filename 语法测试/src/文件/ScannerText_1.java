package нд╪Ч;
import java.io.*;
import java.util.*;
public class ScannerText_1 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("E:/aaa.c"));
		while(scan.hasNextLine()){
			System.out.println(scan.nextLine());
		}
		if(scan.hasNextBoolean())
			System.out.println(scan.nextBoolean());
		scan.close();
	}

}
