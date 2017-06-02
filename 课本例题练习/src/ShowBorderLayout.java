import javax.swing.*;
import java.awt.*; 
public class ShowBorderLayout extends JFrame {
	private JButton jb1, jb2, jb3, jb4, jb5;
	private JLabel jl;
	private JPanel jp;
	public ShowBorderLayout(){
		jb1 = new JButton("��");
		jb2 = new JButton("��");
		jb3 = new JButton("��");
		jb4 = new JButton("��");
		jb5 = new JButton("��");
		jl = new JLabel("��ӭ������");
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
