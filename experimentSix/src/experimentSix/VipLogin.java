package experimentSix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VipLogin {
	private JPanel jp;
	private JTextField[] jt ;
	private JLabel jlName, jlID, jlMailBox, jlPassword, jlEnsurePass;
	private JButton jb1, jb2;

	public VipLogin(){
		jp = new JPanel();
		for(int i = 1; i <= 4; i++){
			jt[i] = new JTextField(15);
		}
		jlName = new JLabel("����");
		jlID = new JLabel("�û���");
		jlMailBox = new JLabel("����");
		jlPassword = new JLabel("����");
		jlEnsurePass = new JLabel("ȷ������");
		jb1 = new JButton("ȡ��");
		jb2 = new JButton("ȷ��");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
