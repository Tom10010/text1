import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseText extends JFrame{
	private JLabel label1, label2;
	public MouseText() {
		super("鼠标监听测试");
		Container c = getContentPane();
		c.setLayout(new BorderLayout(5, 5));
		
		//创建标签对象    显示  严禁入内
		label1 = new JLabel("严禁涉黄！", SwingConstants.CENTER);
		label2 = new JLabel();  //创建标签对象   并不显示文本
		
		//设定 label2 的对齐方式为  居中
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		
		//设置字体
		Font g = new Font("宋体", Font.BOLD, 25);
		label1.setFont(g);
		label2.setForeground(Color.RED);
		c.setBackground(Color.YELLOW);
		c.add(label1, BorderLayout.NORTH);
		c.add(label2, BorderLayout.CENTER);
		c.addMouseMotionListener(new MouseMotionHandler());
		c.addMouseListener(new MouseEventHandler());
		setSize(360, 300);
		setVisible(true);
		setLocation(300, 220);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public class MouseMotionHandler implements MouseMotionListener{
		public void mouseDragged(MouseEvent e) {
			label2.setText("鼠标正在拖动，其位置为：X=" + e.getX() + "Y=" + e.getY());
			
		}
		public void mouseMoved(MouseEvent e) {
		}
		
	}

	public class MouseEventHandler implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			label2.setText("点击鼠标！");;
		}

		
		public void mousePressed(MouseEvent e) {
			label2.setText("按压鼠标");
		}

		
		public void mouseReleased(MouseEvent e) {
			label2.setText("鼠标进入，但是没有拖动！");
		}


		public void mouseEntered(MouseEvent e) {
			label2.setText("鼠标闯入！");
		}

		public void mouseExited(MouseEvent e) {
			label2.setText("鼠标离开，警报解除！");
		}
		
	}
	public static void main(String[] args) {
		MouseText m = new MouseText();
	}

}
