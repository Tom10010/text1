package ͼ�ν���;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Text extends JFrame{
	private JPanel jp;
	private JLabel jl;
	private JButton jb;
	public Text(){
		jp = new JPanel();
		jl = new JLabel("�ź����Ǻ��ˡ�     ");
		jb = new JButton("����");
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
		setTitle("����");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public class lis implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source == jb){
				jl.setText("�ԶԶԣ�����    ");
			}
		}
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Text t = new Text();
		t.run();
	}

}
