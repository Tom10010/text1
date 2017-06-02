package page174_10_2;

import javax.swing.*;
import java.awt.*;

public class DrawOnJPanel extends JFrame{

	public static void main(String[] args) {
		DrawPanel p = new DrawPanel();
		DrawOnJPanel f = new DrawOnJPanel();
		f.setTitle("»æÖÆÍ¼ÐÎ");
		f.getContentPane().add(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation(400, 300);
		f.setSize(600, 500);
		f.setVisible(true);
	}
}
class DrawPanel extends JPanel{
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.red);
		g.drawString("×Ö·û´®", 20, 50);
		g.drawLine(120, 10, 200, 50);
		g.drawRect(60, 80, getWidth()/2 - 30, getHeight()/2 - 30);
		g.drawOval(60, 80, getWidth()/2 -30, getHeight()/2 - 30);
	}
}
