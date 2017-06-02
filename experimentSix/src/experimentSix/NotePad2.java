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
	JTextPane textArea;  //�༭��
	static String content;
	File file;
	JRadioButton rbred;
	JRadioButton rbblue;
	JRadioButton rbblack;
	JButton jb = new JButton("��������");
	JLabel jl = new JLabel("��������");
	JTextField jt = new JTextField(5);
	
	
	public NotePad2() {
		content = new String();
		jfc = new JFileChooser(".");
		//�����ļ�������
		FileNameExtensionFilter filter = new FileNameExtensionFilter("text file", "txt");
		//���ļ�ѡ�����м��������
		jfc.addChoosableFileFilter(filter);
		textArea = new JTextPane();
		JScrollPane scrollpane = new JScrollPane(textArea);
		add(scrollpane);
		//�����˵���
		JMenuBar menubar = new JMenuBar();
		JPanel jp = new JPanel();
		setJMenuBar(menubar);
		//�ı������С
		ButtonGroup g = new ButtonGroup(); 
		JMenu menu1 = new JMenu("�ļ�");
		JMenu menu2 = new JMenu("����");
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(jp);
		//�����˵���***�ļ�
		JMenuItem saveFileItem = new JMenuItem("����");
		JMenuItem saveAsFileItem = new JMenuItem("���Ϊ");
		JMenuItem exitItem = new JMenuItem("Exit");
		menu1.add(saveFileItem);
		menu1.add(saveAsFileItem);
		menu1.add(exitItem);
		//�ı���ʽ
		final JCheckBoxMenuItem bold = new JCheckBoxMenuItem("����");
		final JCheckBoxMenuItem etalic = new JCheckBoxMenuItem("б��");
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
		//�ı�����
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
		//���� *����* ������
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
						JOptionPane.showMessageDialog(NotePad2.this, "�����ļ�ʧ�ܣ�ԭ��\n" + ex);
					}
					NotePad2.this.setTitle(file.getName());
					}});
		//���� *���Ϊ*������
		saveAsFileItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jfc.showDialog(NotePad2.this, "���Ϊ");
				file = jfc.getSelectedFile();
				String text = textArea.getText();
				try{
					saveFile(file, text);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(NotePad2.this, "�ļ�����ʧ�ܣ�ԭ��\n" + ex);}
				NotePad2.this.setTitle(file.getName());
			}
		});
		//���� *�˳�* ������
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		//�ڴ��ڷ���˵���
		setJMenuBar(menubar);
		setSize(500, 600);
		setLocation(200, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//�ı������С
	class lis implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source == jb){
				String str = jt.getText();
				String STR = textArea.getText();
				textArea.setText("");
				SimpleAttributeSet set = new SimpleAttributeSet();
				StyleConstants.setFontSize(set, Integer.parseInt(str));// ���������С
				Document doc = textArea.getStyledDocument();
				try
				{
				doc.insertString(doc.getLength(), STR, set);//��������
				}
				catch (BadLocationException ex)
				{
				}
				
			}
		}
		
	}
	//���ı����е�����д��ָ���ļ���
	protected void saveFile(File file, String str) throws IOException {
		content = str;
		FileWriter filewriter = new FileWriter(file);
		filewriter.write(content);
		filewriter.close();
	}

	public static void main(String[] args) {

		NotePad2 np = new NotePad2();
		np.setTitle("�ı��༭��");
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
	public void insertDocument(String text , Color textColor)//���ݴ������ɫ�����֣������ֲ����ı���
	{
	SimpleAttributeSet set = new SimpleAttributeSet();
	StyleConstants.setForeground(set, textColor);//����������ɫ
	SimpleAttributeSet attrSet = new SimpleAttributeSet();
	Document doc = textArea.getStyledDocument();
	textArea.setText("");
	try
	{
		Font f = new Font("TimesRoman", Font.ITALIC, Integer.parseInt(jt.getText()));
		textArea.setFont(f);
		doc.insertString(doc.getLength(), text, set);//��������
	}
	catch (BadLocationException e)
	{
	}
	}

}
