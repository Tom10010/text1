package page172_10_1;
import java.awt.*;
import javax.swing.*;
public class MyFrame {
	JButton jb = new JButton("ok");
	private JFrame f;
	public MyFrame(){
		f = new JFrame("Hello");
	}
	public void run(){
		f.setSize(600, 600);
		f.setLocation(300, 300);
		Container c = f.getContentPane();
		c.setBackground(Color.BLACK);
		c.add(jb);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame M = new MyFrame();
		M.run();
	}

}
