package experimentSix;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Notepad extends JFrame{

	JFileChooser jfc;    //JFileChooser provides a simple mechanism for the user to choose a file. 
	JTextArea textArea;  //编辑区
	static String content;
	File file;
	
	public Notepad() {
		content = new String();
		jfc = new JFileChooser(".");
		//创建文件过滤器
		FileNameExtensionFilter filter = new FileNameExtensionFilter("text file", "txt");
		//在文件选择器中加入过滤器
		jfc.addChoosableFileFilter(filter);
		textArea = new JTextArea(10, 20);
		JScrollPane scrollpane = new JScrollPane(textArea);
		add(scrollpane);
		//建立菜单栏
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu menu1 = new JMenu("文件");
		JMenu menu2 = new JMenu("编辑");
		JMenu formatMenu = new JMenu("格式");
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(formatMenu);
		
		//建立菜单项***文件
		JMenuItem newFileItem = new JMenuItem("新建");
		JMenuItem openFileItem = new JMenuItem("打开");
		JMenuItem saveFileItem = new JMenuItem("保存");
		JMenuItem saveAsFileItem = new JMenuItem("另存为");
		JMenuItem exitItem = new JMenuItem("Exit");
		menu1.add(newFileItem);
		menu1.add(openFileItem);
		menu1.add(saveFileItem);
		menu1.add(saveAsFileItem);
		menu1.add(exitItem);
		
		//建立菜单项***编辑
		JMenuItem cutItem= new JMenuItem("剪切");
		JMenuItem copyItem = new JMenuItem("复制");
		JMenuItem pasteItem = new JMenuItem("粘贴");
		menu2.add(cutItem);
		menu2.add(copyItem);
		menu2.add(pasteItem);
		
		//弹出式菜单
		JPopupMenu pm = new JPopupMenu();
		JMenuItem pcutItem = new JMenuItem("剪切");
		JMenuItem pcopyItem = new JMenuItem("复制");
		JMenuItem ppasteItem = new JMenuItem("粘贴");
		
		//创建*格式*菜单的复选框
		final JCheckBoxMenuItem wrapItem = new JCheckBoxMenuItem("自动换行");
		formatMenu.add(wrapItem);
		
		//创建 *新建* 的监听器
		newFileItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(content.equals(textArea.getText())){
			textArea.setText("");
		}
				else{
					int value = JOptionPane.showConfirmDialog(Notepad.this, "是否保存所做的修改？", "提示", JOptionPane.YES_NO_OPTION);
					if(value == JOptionPane.YES_OPTION){
						String text = textArea.getText();
						try{saveFile(file, text);
							textArea.setText("");
						}catch(Exception ex){
							JOptionPane.showMessageDialog(Notepad.this, "文件保存失败, 原因\n" + ex);
						}	
						}
					else if (value == JOptionPane.NO_OPTION){
						textArea.setText("");
					}
					
				}
				Notepad.this.setTitle("新建文档");
				file = null;
			}
		});
		
		//创建 *打开*监听器
		openFileItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jfc.showOpenDialog(Notepad.this);
				file = jfc.getSelectedFile();
				if(file == null){
					textArea.setText("没有选择文件");
					return;
				}
				textArea.setText("");
				try{
					String content = getFileContent(file);
					textArea.setText(content);
					Notepad.this.setTitle(file.getName());
				}catch(Exception ex){
					textArea.setText("读取文件失败，原因\n" + ex);	}}});
		//创建 *保存* 监听器
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
						JOptionPane.showMessageDialog(Notepad.this, "保存文件失败，原因\n" + ex);
					}
					Notepad.this.setTitle(file.getName());
					}});
		//创建 *另存为*监听器
		saveAsFileItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jfc.showDialog(Notepad.this, "另存为");
				file = jfc.getSelectedFile();
				String text = textArea.getText();
				try{
					saveFile(file, text);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(Notepad.this, "文件保存失败，原因\n" + ex);}
				Notepad.this.setTitle(file.getName());
			}
		});
		//创建 *退出* 监听器
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		//创建 *编辑* 监听器
		cutItem.addActionListener( new CutListener());
		copyItem.addActionListener( new CopyListener());
		pasteItem.addActionListener( new PasteListener());
		
		//创建 *格式* 监听器
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
		
		//创建弹出式菜单的各菜单项的监听器//鼠标右键
		pcutItem.addActionListener(new CutListener());
		pcopyItem.addActionListener(new CopyListener());
		ppasteItem.addActionListener(new PasteListener());
		
		//为文本编辑区创建鼠标监听器
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
		
		//在窗口放入菜单栏
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
	
	//从指定的文件中获取文件内容
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

	//将文本区中的内容写到指定文件中
	protected void saveFile(File file, String str) throws IOException {
		content = str;
		FileWriter filewriter = new FileWriter(file);
		filewriter.write(content);
		filewriter.close();
	}

	public static void main(String[] args) {

		Notepad np = new Notepad();
		np.setTitle("文本编辑器");
		np.setVisible(true);
	}

}
