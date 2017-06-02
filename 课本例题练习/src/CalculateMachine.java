import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CalculateMachine extends JFrame{
	int operato = 0;
	double num = 0;
	private JLabel jl;
	private JTextField jt;  //输入框
	private JButton[] jb;   //数字，操作符等按钮
	private JPanel jp1, jp2;  //界面分块
	private static String Num1 = "";  //第一个运算数
	private static String Num2 = "";  //第二个运算数
	
	//构造函数
	public CalculateMachine() {
		jb = new JButton[20];
		jt = new JTextField(20);
		jp1 = new JPanel();
		jp2 = new JPanel();
		jl = new JLabel("计算结果：");
		jb[0] = new JButton("del");  jb[1] = new JButton("C");	jb[2] = new JButton("√￣");  jb[3] = new JButton("+");
		jb[4] = new JButton("1");    jb[5] = new JButton("2");	jb[6] = new JButton("3");    jb[7] = new JButton("-");
		jb[8] = new JButton("4");    jb[9] = new JButton("5");	jb[10] = new JButton("6");   jb[11] = new JButton("*");
		jb[12] = new JButton("7");   jb[13] = new JButton("8");	jb[14] = new JButton("9");   jb[15] = new JButton("/");
		jb[16] = new JButton("±");   jb[17] = new JButton("0"); jb[18] = new JButton(".");   jb[19] = new JButton("=");
		for(int i = 0; i < 20; i++){
			jb[i].addActionListener(new lis());
		}
	}
	
	public void launchFrame() throws Exception{
		Container c = getContentPane();
		GridLayout gr = new GridLayout(5, 4, 3, 3);
		jp1.add(jt);
		jp1.add(jl);
		jp2.setLayout(gr);
		for(int i = 0; i < 20; i++){
			jp2.add(jb[i]);
		}
		c.add(jp1,"North");
		c.add(jp2, "Center");
		setTitle("计算器");
		
		setSize(500,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 100);
		setVisible(true);		
	}
	class lis implements ActionListener {
		int i = 0;
		private double num1 = 0.0f, num2 = 0.0f;
		public void actionPerformed(ActionEvent e) {
			//try{
			Object source = e.getSource();
			if(source == jb[1]){  //运算符 C
				Num1 = "";
				Num2 = "";
				operato = 0;
				jt.setText(Num1);
				jt.setText(Num2);
				//Num2 = "";
			}
			else if(source == jb[0]){  //运算符  del
				if(Num1.length() != 0){
					Num1 = Num1.substring(0, Num1.length()-1);
					jt.setText(Num1);
				}
			}
			else if(source == jb[2]){  //运算符 √￣
				if(Num1.length() == 0)
					jl.setText("没有输入底数");
				else{
					num1 = Double.valueOf(Num1).doubleValue();
					jl.setText("计算结果：" + Math.sqrt(num1));
				}
			}
			else if(source == jb[3]){ //运算符 +
				if(Num1.length() != 0){
					num1 = Double.valueOf(Num1).doubleValue();
					num = num1;
					operato = '+';
					Num1 += e.getActionCommand();
					jt.setText(Num1);
				}
			}
			else if(source == jb[7]){ //运算符 -
				if(Num1.length() != 0){
					num1 = Double.valueOf(Num1).doubleValue();
					num = num1;
					operato = '-';
					Num1 += e.getActionCommand();
					jt.setText(Num1);
				}
			}
			else if(source == jb[11]){ //运算符 *
				if(Num1.length() != 0){
					num1 = Double.valueOf(Num1).doubleValue();
					num = num1;
					operato = '*';
					Num1 += e.getActionCommand();
					jt.setText(Num1);
				}
			}
			else if(source == jb[15]){ //运算符 /
				if(Num1.length() != 0){
					num1 = Double.valueOf(Num1).doubleValue();
					num = num1;
					operato = '/';
					Num1 += e.getActionCommand();
					jt.setText(Num1);
				}
			}
			else if(source == jb[19]){ //运算符 =
				if(Num1.length() != 0){
					//System.out.println(Num2);
					
					if(operato == '+'){
						num2 = Double.valueOf(Num2).doubleValue();
						jl.setText("计算结果：" + (double)(num + num2));
					}
					else if(operato == '-'){
						num2 = Double.valueOf(Num2).doubleValue();
						jl.setText("计算结果：" + (double)(num - num2));
					}
					else if(operato == '*'){
						num2 = Double.valueOf(Num2).doubleValue();
						jl.setText("计算结果：" + (double)(num * num2));
					}
					else if(operato == '/'){
						num2 = Double.valueOf(Num2).doubleValue();
						if(num2 !=0.0f)
							jl.setText("计算结果：" + num1 / num2);
						else 
							jl.setText("除数为 0");
					}
					else if(operato == ' '){
						num1 = Double.valueOf(Num1).doubleValue();	
						jl.setText("计算结果：" + num1);
						Num1 = "";
						Num2 = "";
						jt.setText("");
					}
				}
				num1 = 0;
				num2 = 0;
				num = 0;
				Num1 = "";
				Num2 = "";
			}
			else if(source == jb[16]){//
				Num1 += '-';
				jt.setText(Num1);
			}
			else if(operato == 0){
					Num1 += e.getActionCommand();
					jt.setText(Num1);
					i++;
				}
			else if(operato == '+' || operato == '-' || operato == '*' || operato == '/'){
				System.out.println(Num2);
				Num2 +=e.getActionCommand();
				System.out.println(Num2);
				Num1 += e.getActionCommand();
				System.out.println(Num2);
				jt.setText(Num1);
			}
		/*}catch (Exception e1){
			JOptionPane.showConfirmDialog(null, "输入有误！", "错误提示！", JOptionPane.ERROR_MESSAGE);
			num1 = 0;
			num2 = 0;
			operato = 0;
			Num1 = "";
			Num2 = "";
			num = 0;
			jt.setText("");
		}*/
			}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculateMachine c = new CalculateMachine();
		try {
			c.launchFrame();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showConfirmDialog(null, "输入有误！", "错误提示！", JOptionPane.ERROR_MESSAGE);
		}
	}

}
