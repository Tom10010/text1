package experimentSix;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Notepad extends JFrame{

	JFileChooser jfc;    //JFileChooser provides a simple mechanism for the user to choose a file. 
	JTextArea textArea;  //�༭��
	static String content;
	File file;
	
	public Notepad() {
		content = new String();
		jfc = new JFileChooser(".");
		//�����ļ�������
		FileNameExtensionFilter filter = new FileNameExtensionFilter("text file", "txt");
		//���ļ�ѡ�����м��������
		jfc.addChoosableFileFilter(filter);
		textArea = new JTextArea(10, 20);
		JScrollPane scrollpane = new JScrollPane(textArea);
		add(scrollpane);
		//�����˵���
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu menu1 = new JMenu("�ļ�");
		JMenu menu2 = new JMenu("�༭");
		JMenu formatMenu = new JMenu("��ʽ");
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(formatMenu);
		
		//�����˵���***�ļ�
		JMenuItem newFileItem = new JMenuItem("�½�");
		JMenuItem openFileItem = new JMenuItem("��");
		JMenuItem saveFileItem = new JMenuItem("����");
		JMenuItem saveAsFileItem = new JMenuItem("���Ϊ");
		JMenuItem exitItem = new JMenuItem("Exit");
		menu1.add(newFileItem);
		menu1.add(openFileItem);
		menu1.add(saveFileItem);
		menu1.add(saveAsFileItem);
		menu1.add(exitItem);
		
		//�����˵���***�༭
		JMenuItem cutItem= new JMenuItem("����");
		JMenuItem copyItem = new JMenuItem("����");
		JMenuItem pasteItem = new JMenuItem("ճ��");
		menu2.add(cutItem);
		menu2.add(copyItem);
		menu2.add(pasteItem);
		
		//����ʽ�˵�
		JPopupMenu pm = new JPopupMenu();
		JMenuItem pcutItem = new JMenuItem("����");
		JMenuItem pcopyItem = new JMenuItem("����");
		JMenuItem ppasteItem = new JMenuItem("ճ��");
		
		//����*��ʽ*�˵��ĸ�ѡ��
		final JCheckBoxMenuItem wrapItem = new JCheckBoxMenuItem("�Զ�����");
		formatMenu.add(wrapItem);
		
		//���� *�½�* �ļ�����
		newFileItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(content.equals(textArea.getText())){
			textArea.setText("");
		}
				else{
					int value = JOptionPane.showConfirmDialog(Notepad.this, "�Ƿ񱣴��������޸ģ�", "��ʾ", JOptionPane.YES_NO_OPTION);
					if(value == JOptionPane.YES_OPTION){
						String text = textArea.getText();
						try{saveFile(file, text);
							textArea.setText("");
						}catch(Exception ex){
							JOptionPane.showMessageDialog(Notepad.this, "�ļ�����ʧ��, ԭ��\n" + ex);
						}	
						}
					else if (value == JOptionPane.NO_OPTION){
						textArea.setText("");
					}
					
				}
				Notepad.this.setTitle("�½��ĵ�");
				file = null;
			}
		});
		
		//���� *��*������
		openFileItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jfc.showOpenDialog(Notepad.this);
				file = jfc.getSelectedFile();
				if(file == null){
					textArea.setText("û��ѡ���ļ�");
					return;
				}
				textArea.setText("");
				try{
					String content = getFileContent(file);
					textArea.setText(content);
					Notepad.this.setTitle(file.getName());
				}catch(Exception ex){
					textArea.setText("��ȡ�ļ�ʧ�ܣ�ԭ��\n" + ex);	}}});
		//���� *����* ������
		saveFileItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(file == null){
					jfc.showSaveDialog(Notepad.this);
					file = jfc.getSelectedFile();}
					String text = textArea.getText();
					try{
						saveFile(file, text);
					}catch(Exception ex){
						JOptionPane.showMessageDialog(Notepad.this, "�����ļ�ʧ�ܣ�ԭ��\n" + ex);
					}
					Notepad.this.setTitle(file.getName());
					}});
		//���� *���Ϊ*������
		saveAsFileItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jfc.showDialog(Notepad.this, "���Ϊ");
				file = jfc.getSelectedFile();
				String text = textArea.getText();
				try{
					saveFile(file, text);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(Notepad.this, "�ļ�����ʧ�ܣ�ԭ��\n" + ex);}
				Notepad.this.setTitle(file.getName());
			}
		});
		//���� *�˳�* ������
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		//���� *�༭* ������
		cutItem.addActionListener( new CutListener());
		copyItem.addActionListener( new CopyListener());
		pasteItem.addActionListener( new PasteListener());
		
		//���� *��ʽ* ������
		wrapItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(wrapItem .isSelected()){
					textArea.setLineWrap(true);
				}
				else{
					textArea.setLineWrap(false);
				}
				
			}
		});
		
		//��������ʽ�˵��ĸ��˵���ļ�����//����Ҽ�
		pcutItem.addActionListener(new CutListener());
		pcopyItem.addActionListener(new CopyListener());
		ppasteItem.addActionListener(new PasteListener());
		
		//Ϊ�ı��༭��������������
		textArea.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				popup(e);
			}
			public void mousePressed(MouseEvent e){
				popup(e);
			}
			public void popup(MouseEvent e){
				pm.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		
		//�ڴ��ڷ���˵���
		setJMenuBar(menubar);
		setSize(360, 500);
		setLocation(200, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class CutListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			textArea.cut();
		}
	}
	class CopyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			textArea.copy();
		}
	}
	class PasteListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			textArea.paste();
		}
	}
	
	//��ָ�����ļ��л�ȡ�ļ�����
	protected String getFileContent(File file2) throws IOException {
		content = "";
		FileReader filereader = new FileReader(file);
		BufferedReader reader = new BufferedReader(filereader);
		String line = "";
		while((line = reader.readLine()) != null){
			content += line + "\n";
		}
		reader.close();
		return content;
	}

	//���ı����е�����д��ָ���ļ���
	protected void saveFile(File file, String str) throws IOException {
		content = str;
		FileWriter filewriter = new FileWriter(file);
		filewriter.write(content);
		filewriter.close();
	}

	public static void main(String[] args) {

		Notepad np = new Notepad();
		np.setTitle("�ı��༭��");
		np.setVisible(true);
	}

}
