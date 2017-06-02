import javax.swing.*;
import java.awt.*; 
public class ShowBorderLayout extends JFrame {
	private JButton jb1, jb2, jb3, jb4, jb5;
	private JLabel jl;
	private JPanel jp;
	public ShowBorderLayout(){
		jb1 = new JButton("右");
		jb2 = new JButton("左");
		jb3 = new JButton("下");
		jb4 = new JButton("上");
		jb5 = new JButton("中");
		jl = new JLabel("欢迎来到：");
		jp = new JPanel();
	}
	public void launchFrame(){
		Container c = getContentPane();
		c.add(jb1, BorderLayout.WEST);
		c.add(jb2, BorderLayout.EAST);
		c.add(jb3, BorderLayout.NORTH);
		c.add(jb4, BorderLayout.SOUTH);
		jp.add(jl);
		jp.add(jb5);
		c.add(jp, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		ShowBorderLayout n = new ShowBorderLayout();
		n.launchFrame();
	}
}
