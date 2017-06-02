package Õº–ŒΩÁ√Ê;
import javax.swing.*;
import java.awt.*;
public class MyFrame {
	private JFrame f;
	private JButton jb;
	
	public MyFrame(){
		f = new JFrame("Hello GUI");
		jb = new JButton("aaa");
	}
	
	public void run(){
		f.setSize(500, 500);
		f.setLocation(50, 50);
		Container c = f.getContentPane();
		c.setLayout(new FlowLayout());
		c.setBackground(Color.black);
		c.add(jb);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
		mf.run();
		
	}

}
