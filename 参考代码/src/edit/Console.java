package edit;

import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Console extends JDialog {
	JTextArea textArea = new JTextArea();
	JTextField textFieldInput = new JTextField();

	/**
	 * Create the dialog.
	 */
	public Console(final Window window) {
		setTitle("¿ØÖÆÌ¨");
		setResizable(false);
		setBounds(100, 100, 633, 332);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 627, 282);
		getContentPane().add(scrollPane);
		textArea.setEditable(false);
		
		scrollPane.setViewportView(textArea);
		textArea.setFont(new  Font("ºÚÌå",Font.BOLD,15));
		
		textFieldInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.consoleOutput();
			}
		});
		textFieldInput.setForeground(Color.BLACK);
		textFieldInput.setBounds(0, 283, 534, 21);
		getContentPane().add(textFieldInput);
		textFieldInput.setColumns(10);
		
		JButton btnInput = new JButton("\u8F93\u5165");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.consoleOutput();
			}
		});
		btnInput.setBounds(534, 282, 93, 23);
		getContentPane().add(btnInput);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
}

