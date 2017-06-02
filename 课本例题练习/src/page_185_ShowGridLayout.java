import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class page_185_ShowGridLayout extends JFrame {
	private JLabel jl;
	private JButton ok, cancel;
	private JTextField jt;
	private JPanel jp1, jp2;
	private JButton[] jb;
	private static String str = "";
	//构造函数  初始化组件，添加监听器
	public page_185_ShowGridLayout(){
		jl = new JLabel("请输入手机号码：");
		ok = new JButton("确定");
		cancel = new JButton("取消");
		jt = new JTextField(15);
		jp1 = new JPanel();
		jp2 = new JPanel();
		jb = new JButton[10];
		for(int i = 0; i < 10; i++)
		{
			jb[i] = new JButton(new Integer(i).toString());
			jb[i].addActionListener(new Lis());  //注册监听器
		}
		ok.addActionListener(new Lis());    //注册监听器
		cancel.addActionListener(new Lis());   //注册监听器
	}
	
	public void launchFrame(){
		Container c = getContentPane();
		GridLayout gl = new GridLayout(4, 3, 5, 5);
		jp1.add(jl);
		jp1.add(jt);
		jp2.setLayout(gl);
		for(int i = 1; i < 10; i++){
			jp2.add(jb[i]);
		}
		jp2.add(ok);
		jp2.add(jb[0]);
		jp2.add(cancel);
		c.add(jp1, "North");
		c.add(jp2, "Center");
		setTitle("电话号码");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500, 500);
		setSize(400, 200);
		setVisible(true);
	}
	
	//内部类
	class Lis implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Object source = e.getSource();
			FileOutputStream file = null;
			try {
				file = new FileOutputStream("E:/java/aaa.txt", true);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			if(source == ok){
				str = jt.getText();
				if(str.length() != 11){
					JOptionPane.showMessageDialog(null, "电话号码的位数不对！请重新输入。", "错误提示", JOptionPane.ERROR_MESSAGE);
					jt.setText("");
					
					
				}
				else{
					JOptionPane.showMessageDialog(null, "输入的电话号码是：" + str, "提示！", JOptionPane.INFORMATION_MESSAGE);
					try {
						file.write(str.getBytes());
						file.write('\n');
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			else
				if(source == cancel){
					str = "";
					jt.setText(str);
				}
				else{
					str += e.getActionCommand();
					jt.setText(str);
				}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		page_185_ShowGridLayout sg = new page_185_ShowGridLayout();
		sg.launchFrame();
	}

}
