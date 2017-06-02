import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Notepad extends JFrame{

	JFileChooser jfc;    //JFileChooser provides a simple mechanism for the user to choose a file. 
	JTextArea textArea;  //编辑区
	static String content;
	File file;
	
	public Notepad() {
		content = new String();
		jfc = new JFileChooser(".");
		//创建文件过滤器
		FileNameExtensionFilter filter = new FileNameExtensionFilter("text file", "txt");
		/*An implementation of FileFilter that filters using a 
		 * specified set of extensions. The extension for a file is 
		 * the portion of the file name after the last ".".  Files 
		 * whose name does not contain a "." have no file name extension. 
		 * File name extension comparisons are case insensitive. */
		//在文件选择器中加入过滤器
		jfc.addChoosableFileFilter(filter);
		textArea = new JTextArea(10, 20);
		JScrollPane scrollpane = new JScrollPane(textArea);
		add(scrollpane);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
