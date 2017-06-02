import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class page_189_KeyTest extends JFrame{
	private KeyPanel kp = new KeyPanel();
	public page_189_KeyTest() {
		getContentPane().add(kp);
		kp.setFocusable(true);
	}

	public static void main(String[] args) {
		page_189_KeyTest kt = new page_189_KeyTest();
		kt.setTitle("键盘事件实例");
		kt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		kt.setSize(300, 300);
		kt.setVisible(true);
	}

}

class KeyPanel extends JPanel implements KeyListener{
	private int keynumber = 0;
	private float rightKeyNumber = 0.0f;
	private float accurate = 0.0f;
	private boolean stop = true;
	
	//产生随机数
	private Random r = new Random();
	private char keychar = (char)(r.nextInt(26) + 65);
	public KeyPanel(){
		addKeyListener(this);
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keynumber ++;
		if(Character.toUpperCase((e.getKeyChar()) == keychar)){
			keychar = (char)(r.nextInt(26) + 65);
			rightKeyNumber++;
			repaint();
		}
	}
	
	
}