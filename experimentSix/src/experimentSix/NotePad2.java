package experimentSix;
import javax.swing.*;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class NotePad2 extends JFrame implements ItemListener{
	JFileChooser jfc;    //JFileChooser provides a simple mechanism for the user to choose a file. 
	JTextPane textArea;  //编辑区
	static String content;
	File file;
	JRadioButton rbred;
	JRadioButton rbblue;
	JRadioButton rbblack;
	JButton jb = new JButton("设置字体");
	JLabel jl = new JLabel("设置字体");
	JTextField jt = new JTextField(5);
	
	
	public NotePad2() {
		content = new String();
		jfc = new JFileChooser(".");
		//创建文件过滤器
		FileNameExtensionFilter filter = new FileNameExtensionFilter("text file", "txt");
		//在文件选择器中加入过滤器
		jfc.addChoosableFileFilter(filter);
		textArea = new JTextPane();
		JScrollPane scrollpane = new JScrollPane(textArea);
		add(scrollpane);
		//建立菜单栏
		JMenuBar menubar = new JMenuBar();
		JPanel jp = new JPanel();
		setJMenuBar(menubar);
		//改变字体大小
		ButtonGroup g = new ButtonGroup(); 
		JMenu menu1 = new JMenu("文件");
		JMenu menu2 = new JMenu("字体");
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(jp);
		//建立菜单项***文件
		JMenuItem saveFileItem = new JMenuItem("保存");
		JMenuItem saveAsFileItem = new JMenuItem("另存为");
		JMenuItem exitItem = new JMenuItem("Exit");
		menu1.add(saveFileItem);
		menu1.add(saveAsFileItem);
		menu1.add(exitItem);
		//文本格式
		final JCheckBoxMenuItem bold = new JCheckBoxMenuItem("粗体");
		final JCheckBoxMenuItem etalic = new JCheckBoxMenuItem("斜体");
		rbred = new JRadioButton("     ");
		rbblue = new JRadioButton("     ");
		rbblack = new JRadioButton("     ");
		rbred.setBackground(Color.red);
		rbblue.setBackground(Color.blue);
		rbblack.setBackground(Color.black);
		menu2.add(bold);
		menu2.add(etalic);
		jp.add(rbred);
		jp.add(rbblue);
		jp.add(rbblack);
		jp.add(jl);
		jp.add(jt);
		jp.add(jb);
		rbred.addItemListener(this);
		rbblue.addItemListener(this);
		rbblack.addItemListener(this);
		g.add(rbred);
		g.add(rbblue);
		g.add(rbblack);
		jb.addActionListener(new lis());
		jt.setText("12");
		//改变字形
		bold.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bold.isSelected()){
					Font f = new Font("", Font.BOLD, Integer.parseInt(jt.getText()));
					textArea.setFont(f);
				}
				
			}
		});
		etalic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(etalic.isSelected()){
					Font f = new Font("TimesRoman", Font.ITALIC, Integer.parseInt(jt.getText()));
					textArea.setFont(f);
				}
			}
		});
		//创建 *保存* 监听器
		saveFileItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(file == null){
					jfc.showSaveDialog(NotePad2.this);
					file = jfc.getSelectedFile();}
					String text = textArea.getText();
					try{
						saveFile(file, text);
					}catch(Exception ex){
						JOptionPane.showMessageDialog(NotePad2.this, "保存文件失败，原因\n" + ex);
					}
					NotePad2.this.setTitle(file.getName());
					}});
		//创建 *另存为*监听器
		saveAsFileItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jfc.showDialog(NotePad2.this, "另存为");
				file = jfc.getSelectedFile();
				String text = textArea.getText();
				try{
					saveFile(file, text);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(NotePad2.this, "文件保存失败，原因\n" + ex);}
				NotePad2.this.setTitle(file.getName());
			}
		});
		//创建 *退出* 监听器
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		//在窗口放入菜单栏
		setJMenuBar(menubar);
		setSize(500, 600);
		setLocation(200, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//改变字体大小
	class lis implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source == jb){
				String str = jt.getText();
				String STR = textArea.getText();
				textArea.setText("");
				SimpleAttributeSet set = new SimpleAttributeSet();
				StyleConstants.setFontSize(set, Integer.parseInt(str));// 设置字体大小
				Document doc = textArea.getStyledDocument();
				try
				{
				doc.insertString(doc.getLength(), STR, set);//插入文字
				}
				catch (BadLocationException ex)
				{
				}
				
			}
		}
		
	}
	//将文本区中的内容写到指定文件中
	protected void saveFile(File file, String str) throws IOException {
		content = str;
		FileWriter filewriter = new FileWriter(file);
		filewriter.write(content);
		filewriter.close();
	}

	public static void main(String[] args) {

		NotePad2 np = new NotePad2();
		np.setTitle("文本编辑器");
		np.setVisible(true);
	}
	public void itemStateChanged(ItemEvent e) {
		if(rbred.isSelected()){	
			String str = textArea.getText();
			insertDocument(str, Color.red);
		}
		if(rbblue.isSelected()){
			String str = textArea.getText();
			insertDocument(str, Color.blue);
		}
		if(rbblack.isSelected()){
			String str = textArea.getText();
			insertDocument(str, Color.black);
		}
	}
	public void insertDocument(String text , Color textColor)//根据传入的颜色及文字，将文字插入文本域
	{
	SimpleAttributeSet set = new SimpleAttributeSet();
	StyleConstants.setForeground(set, textColor);//设置文字颜色
	SimpleAttributeSet attrSet = new SimpleAttributeSet();
	Document doc = textArea.getStyledDocument();
	textArea.setText("");
	try
	{
		Font f = new Font("TimesRoman", Font.ITALIC, Integer.parseInt(jt.getText()));
		textArea.setFont(f);
		doc.insertString(doc.getLength(), text, set);//插入文字
	}
	catch (BadLocationException e)
	{
	}
	}

}
