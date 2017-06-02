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
		jlName = new JLabel("姓名");
		jlID = new JLabel("用户名");
		jlMailBox = new JLabel("邮箱");
		jlPassword = new JLabel("密码");
		jlEnsurePass = new JLabel("确定密码");
		jb1 = new JButton("取消");
		jb2 = new JButton("确定");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
