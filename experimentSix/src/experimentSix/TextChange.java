package experimentSix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextChange extends JFrame{

	private  JPanel jp;
	private JTextField jt1, jt2;   //定义两个文本编辑框
	private JButton jb;   //定义按钮//change
	String str1, str2;
	
	
	public TextChange() {
		jp = new JPanel();
		jt1 = new JTextField(15);
		jt2 = new JTextField(15);
		jb = new JButton("change");
		jb.addActionListener(new lis());

	}

	public void LaunchFrame(){
		Container c = getContentPane();
		FlowLayout fl = new FlowLayout();
		jp.add(jt1);
		jp.add(jt2);
		jp.add(jb);
		jp.setLayout(fl);
		c.add(jp);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500, 500);
		setSize(500, 90);
		setVisible(true);
		
	}
	
	class lis implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source == jb){
				str1 = jt1.getText();
				str2 = jt2.getText();
				jt1.setText(str2);
				jt2.setText(str1);
				
			}
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextChange t = new TextChange();
		t.LaunchFrame();
	}

}

