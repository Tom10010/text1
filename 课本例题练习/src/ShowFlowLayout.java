import javax.swing.*;
import java.awt.*;

public class ShowFlowLayout extends JFrame{

	private JButton[] b;
	private JButton jb;
	public  ShowFlowLayout(){
		b = new JButton[5];
		for(int i = 1; i <= 5; i++){
			b[i-1] = new JButton("°´Å¥ " + i);
		}
		jb = new JButton("hahaahahahahh");
	}
	public void launchFrame(){
		JFrame f;
		f = new JFrame("aaaa");
		f.setSize(500, 500);
		f.setLocation(500, 500);
		f.setVisible(true);
		Container c = f.getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.RIGHT,10,15));
		for(int i = 0; i < 5; i++){
			c.add(b[i]);
		}
		c.add(jb);
		setTitle("FlowLayout ÊµÀý");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//pack();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShowFlowLayout show = new ShowFlowLayout();
		show.launchFrame();
	}

}
