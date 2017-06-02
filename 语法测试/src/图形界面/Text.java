package 图形界面;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Text extends JFrame{
	private JPanel jp;
	private JLabel jl;
	private JButton jb;
	public Text(){
		jp = new JPanel();
		jl = new JLabel("张洪涛是好人。     ");
		jb = new JButton("就是");
	}
	public void run(){
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		jp.add(jl);
		jp.add(jb);
		jb.addActionListener(new lis());
		c.add(jp); 
		setLocation(200, 200);
		setSize(300, 100);
		setTitle("好人");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public class lis implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source == jb){
				jl.setText("对对对！！！    ");
			}
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Text t = new Text();
		t.run();
	}

}
