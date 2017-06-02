package 图形界面;
import javax.swing.*;
import java.awt.*;
public class DrawOnJPanel extends JFrame{
	

	public static void main(String[] args){
		DrawOnJPanel f = new DrawOnJPanel();
		DrawPanel p = new DrawPanel(); 
		f.setTitle("绘制图形");
		f.setSize(500, 500);
		f.setLocation(200, 200);
		f.setVisible(true);
		f.add(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class DrawPanel extends JPanel{
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.red);
		g.drawString("zhanghongtao", 200, 200);
		g.drawLine(10, 20, 30, 40);
		
	}
}