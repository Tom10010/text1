//主界面
package edit;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Utilities;
import javax.swing.undo.UndoManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JToolBar;
import javax.swing.JButton;

public class Window {

	JFrame frame;
	JTextArea textArea = new JTextArea();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnNewMenuFile = new JMenu("\u6587\u4EF6(F)");
	private JMenuItem menuItemNew = new JMenuItem("\u65B0\u5EFA ");
	private JMenuItem menuItemOpen = new JMenuItem("\u6253\u5F00");
	private JMenuItem menuItemSave = new JMenuItem("\u4FDD\u5B58");
	private JMenuItem menuItemExit = new JMenuItem("\u9000\u51FA");
	private JMenuItem menuItemSaveAs = new JMenuItem("\u53E6\u5B58\u4E3A");
	private File currentFile;
	private final JMenu menuEdit = new JMenu("\u7F16\u8F91(E)");
	private final JMenuItem menuItemSelect = new JMenuItem("\u67E5\u627E");
	private final JMenuItem menuItemReplace = new JMenuItem("\u66FF\u6362 ");
	private final JMenuItem menuItemSelectAll = new JMenuItem("\u5168\u9009");
	private final JMenuItem menuItemData = new JMenuItem("\u65F6\u95F4/\u65E5\u671F");
	private final JMenu menuForm = new JMenu("\u683C\u5F0F(O)");
	private final JMenuItem menuItem = new JMenuItem("\u5B57\u4F53");
	private final JCheckBox checkBox = new JCheckBox("\u81EA\u52A8\u6362\u884C");
	private final JLabel label = new JLabel("\u884C\uFF1A");
	private final JLabel label_1 = new JLabel("\u5217\uFF1A");
	private final JPopupMenu popupMenu = new JPopupMenu();
	private final JMenuItem menuItemCopy = new JMenuItem("\u590D\u5236");
	private final JMenuItem menuItemPaste = new JMenuItem("\u7C98\u8D34");
	private final JMenuItem menuItemCut = new JMenuItem("\u526A\u5207");
	private final JMenuItem menuItemUndo = new JMenuItem("\u64A4\u9500");;
	private UndoManager um = new UndoManager();
	private final JMenuItem menuItemRedo = new JMenuItem("\u6062\u590D");
	private JLabel labelLine = new JLabel("0");
	private JLabel labelCol = new JLabel("0");
	private JLabel labelCharNum = new JLabel("0");
	private Process po;
	private Console con;
	private static Window window;

	/**
	 * 启动程序
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    window = new Window();
					window.frame.setVisible(true);
					window.textArea.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * 初始化窗口
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("新建文本");
		frame.setBounds(100, 100, 900, 700);
		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				if(!textArea.getText().equals(""))
					fileNew();
				System.exit(0);
			}
		});
		frame.getContentPane().setLayout(null);
		label.setBounds(30, 3, 35, 15);	
		frame.getContentPane().add(label);
		label_1.setBounds(120, 3, 33, 15);
		frame.getContentPane().add(label_1);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 26, 894, 625);
		frame.getContentPane().add(scrollPane);
		
		//注册撤销可编辑监听器
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener(){
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
		});
		
		//监听光标移动
		textArea.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if(getLineNum(textArea)!=-1){
					labelCol.setText(Integer.valueOf(getColumnNum(textArea)).toString());
					labelLine.setText(Integer.valueOf(getLineNum(textArea)).toString());
					labelCharNum.setText(Integer.valueOf(getCharNum(textArea)).toString());
				}else{
					labelCol.setText("0");
					labelLine.setText(Integer.valueOf((Integer.valueOf( labelLine.getText() )+1)).toString());
					labelCharNum.setText(Integer.valueOf(getCharNum(textArea)).toString());
				}
			}
		});
		textArea.setFont(new Font("黑体",Font.BOLD,18));
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		addPopup(textArea, popupMenu);
		menuItemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		menuItemCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.copy();
			}
		});
		popupMenu.add(menuItemCopy);
		menuItemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		menuItemCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.cut();
			}
		});
		
		popupMenu.add(menuItemCut);
		menuItemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		menuItemPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.paste();
			}
		});
		
		popupMenu.add(menuItemPaste);
		menuItemUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					um.undo();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(frame, "没有可撤销的操作！");
				}
			}
		});
		
		popupMenu.add(menuItemUndo);
		menuItemRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					um.redo();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(frame, "没有可恢复的操作！");
				}
			}
		});
		
		popupMenu.add(menuItemRedo);
		
		JLabel label_2 = new JLabel("\u5B57\u6570\uFF1A");
		label_2.setBounds(211, 3, 50, 15);
		frame.getContentPane().add(label_2);
		
		
		labelLine.setBounds(56, 3, 54, 15);
		frame.getContentPane().add(labelLine);
		
		
		labelCol.setBounds(147, 3, 54, 15);
		frame.getContentPane().add(labelCol);
		
		
		labelCharNum.setBounds(251, 3, 54, 15);
		frame.getContentPane().add(labelCharNum);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(730, 3, 164, 23);
		frame.getContentPane().add(toolBar);
		
		JButton btnUndo = new JButton("\u2190 \u64A4\u9500(U)");
		btnUndo.setMnemonic('U');
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					um.undo();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(frame, "没有可撤销的操作！");
				}
			}
		});
		toolBar.add(btnUndo);
		
		JButton btnRedo = new JButton("\u2192 \u6062\u590D(R)");
		btnRedo.setMnemonic('R');
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					um.redo();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(frame, "没有可恢复的操作！");
				}
			}
		});
		toolBar.add(btnRedo);
		frame.setJMenuBar(menuBar);			
		mnNewMenuFile.setMnemonic('F');
		menuBar.add(mnNewMenuFile);		
		menuItemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		menuItemNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fileNew();
			}
		});
		mnNewMenuFile.add(menuItemNew);		
		menuItemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		menuItemOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileOpen();
			}
		});
		mnNewMenuFile.add(menuItemOpen);	
		menuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		menuItemSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileSave();
			}
		});
		mnNewMenuFile.add(menuItemSave);		
		menuItemSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileSaveAs();
			}
		});
		mnNewMenuFile.add(menuItemSaveAs);		
		menuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_MASK));
		mnNewMenuFile.add(menuItemExit);
		menuEdit.setMnemonic('E');
		
		menuBar.add(menuEdit);
		menuItemSelect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		menuItemSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select();
			}
		});
		
		menuEdit.add(menuItemSelect);
		menuItemReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		menuItemReplace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				replace();
			}
		});
		
		menuEdit.add(menuItemReplace);
		menuItemSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		menuItemSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.selectAll();
			}
		});
		
		menuEdit.add(menuItemSelectAll);
		menuItemData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append(new Date().toString());
			}
		});
		
		menuEdit.add(menuItemData);
		menuForm.setMnemonic('O');
		
		menuBar.add(menuForm);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FontSelect();
			}
		});
		
		menuForm.add(menuItem);
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected())
					textArea.setLineWrap(true);
				else
					textArea.setLineWrap(false);
			}
		});
		checkBox.setSelected(true);
		
		menuForm.add(checkBox);
		
		JMenu mnp = new JMenu("JAVA(P)");
		mnp.setMnemonic('P');
		menuBar.add(mnp);
		
		JMenuItem mntmjavaCompile = new JMenuItem("\u7F16\u8BD1\u7A0B\u5E8F");
		mntmjavaCompile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				compile();
			}
		});
		mnp.add(mntmjavaCompile);
		
		JMenuItem mntmjavaRun = new JMenuItem("\u8FD0\u884C\u7A0B\u5E8F");
		mntmjavaRun.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mntmjavaRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(compile())
					run();
				
			}
		});
		mnp.add(mntmjavaRun);
	}
	
	private void select(){
		Select.launch(this);
	}
	
	private void FontSelect(){
		FontSelect.launch(this);
	}
	
	private void replace(){
		Replace.launch(this);
	}
	
	private void fileSave(){
    	FileWriter fw = null;
   		BufferedWriter bw = null;
   		if(currentFile != null){
    		try{
   			fw = new FileWriter(currentFile);
    		bw = new BufferedWriter(fw);
    		bw.write(this.textArea.getText());
    		} catch (IOException e) {
    			e.printStackTrace();
    		}finally{
    			try {
    				if(fw != null&&bw != null){
    					bw.close();
    					fw.close();
    					JOptionPane.showMessageDialog(frame, "保存成功！");
    				}
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
   		}else{
   			fileSaveAs();
   		}
	}
	
	private void fileNew(){
		if(!this.textArea.getText().equals(new String(""))){
			int option = JOptionPane.showOptionDialog(frame, "是否保存当前文本",
					"提示", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, 
					null, null, null);
			switch(option){
			case JOptionPane.OK_OPTION:
				fileSave();
					break;
			case JOptionPane.NO_OPTION:
				this.textArea.setText("");
				break;
			case JOptionPane.CANCEL_OPTION:
				return;
			}
		}
	}
	
	private void  fileSaveAs(){
		FileWriter fw = null;
		BufferedWriter bw = null;
		JFileChooser chooser = new JFileChooser();
	    int returnVal = chooser.showSaveDialog(frame);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	File save = chooser.getSelectedFile();
	    	try {
	    		if(save.exists()){
	    			int option = JOptionPane.showOptionDialog(frame ,"该文本文件已经存在，确定要覆盖吗？", 
	    					"警告",	JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
	    					null,null,JOptionPane.CANCEL_OPTION);
	    			switch(option){
	    			case JOptionPane.OK_OPTION:
	    				break;
	    			case JOptionPane.CANCEL_OPTION:
	    				return;
	    			}
	    		}else
	    			save.createNewFile();
	    		fw = new FileWriter(save);
				bw = new BufferedWriter(fw);
				bw.write(this.textArea.getText());
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(fw != null&&bw != null){
						bw.close();
						fw.close();
						JOptionPane.showMessageDialog(frame, "保存成功！");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	    }
	}
	
//	文件打开对话框
	private void fileOpen(){
		FileReader fr = null;
		BufferedReader br = null;
		if(!this.textArea.getText().equals(new String(""))){
			int option = JOptionPane.showOptionDialog(frame, "是否保存当前文本",
					"提示", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, 
					null, null, null);
			switch(option){
			case JOptionPane.OK_OPTION:
				fileSave();
					break;
			case JOptionPane.NO_OPTION:
				break;
			case JOptionPane.CANCEL_OPTION:
				return;
			}
			this.textArea.setText("");
		}
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "文本", "txt","java");
		    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(frame);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	currentFile = chooser.getSelectedFile();
	    	try {
	    		fr = new FileReader(currentFile);
				br = new BufferedReader(fr);
				String read = null;
				while((read = br.readLine()) !=null){
					this.textArea.append(read+"\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(fr != null&&br != null){
						br.close();
						fr.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	    }
	    if(currentFile != null)
	    	frame.setTitle(currentFile.getName());
	    else
	    	frame.setTitle("新建文本");
	}
	//改变文本框字体
	public void changeTextFont(String font,String style,String size){
		int newStyle;
		int newSize = Integer.valueOf(size);
		if(style.equals("粗体"))
			newStyle = Font.BOLD;
		else if(style.equals("斜体"))
			newStyle = Font.ITALIC;
		else
			newStyle = Font.PLAIN;
		textArea.setFont(new Font(font,newStyle,newSize));
		menuBar.updateUI();
	}
	
	//返回文本总字数
	private int getCharNum(JTextComponent text){
		String s = text.getText();
		int spaceNum = 0;
		for(int i = 0;i < s.length();i++){
			if(s.charAt(i) == ' ')
				spaceNum++;
		}
		return s.length()-spaceNum - Integer.valueOf(labelLine.getText())+1;
	}
		
	//返回行号
	private int  getLineNum(JTextComponent text)   { 
//		没有自动换行
/*		int   caretPosition   =   text.getCaretPosition(); 
		Element   root   =   text.getDocument().getDefaultRootElement(); 
		return   root.getElementIndex(   caretPosition   )   +   1;  	*/	
		
		Rectangle rec = null;
		int pos = text.getCaretPosition();
		for(int i = 1;i<2;i++){
			try {
				rec = textArea.modelToView(pos);
			} catch (BadLocationException e) {
				return -1;
			}
		}
		if(rec != null)
			return rec.y / rec.height + 1;
		else
			return +1;
	}
		
	//返回列号
	private  int   getColumnNum(JTextComponent text)   { 
		int   offset   =   text.getCaretPosition(); 
		int   column; 
		try   { 
			column   =   offset   -   Utilities.getRowStart(text,   offset); 
		}   catch   (BadLocationException   e)   { 
			column   =   -1; 
		} 
		return   column+1; 
	} 
	
//	编译java文件
	private boolean compile(){
		fileSave();
		if(currentFile == null){
			JOptionPane.showMessageDialog(this.frame, "没有可用的Java源文件！");
			return false;
		}
		if(currentFile.getName().startsWith(".java",currentFile.getName().length()-6)){
			JOptionPane.showMessageDialog(this.frame, "当前文件不是Java源文件！");
			return false;
		}
		String err = null;
		String allErr = "";
		try {
			Process po = Runtime.getRuntime().exec("javac "+currentFile.getPath()); 
			BufferedReader br = new BufferedReader(new InputStreamReader(po.getErrorStream()));
			while((err = br.readLine()) != null){
				allErr += "\n"+err;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		if(!allErr.equals("")){
			con = new Console(window);
			con.textArea.setText("错误或警告："+allErr);
			con.textFieldInput.setEditable(false);
			return false;
		}
		else{
			JOptionPane.showMessageDialog(this.frame, "编译完成");
			return true;
		}
	}
	

	private void run(){	
		new Thread(){
			public void  run(){
				consoleInput();
			}
		}.start();	
	}
	
	//从控制台读数据
	public void consoleInput(){
		try {
			con = new Console(window);
			con.textFieldInput.requestFocus();
			String fileName = currentFile.getName().substring(0,currentFile.getName().length()-5);
			String filePath = currentFile.getPath().substring(0,currentFile.getPath().indexOf(currentFile.getName()));
			po = Runtime.getRuntime().exec("java -cp "+filePath+" "+fileName);
			new Thread(){
				public void  run(){
					consoleErrInput();
				}
			}.start();	
			BufferedReader br = new BufferedReader(new InputStreamReader(po.getInputStream()));
			String runTimeMessage = null;
			while(true){
				while((runTimeMessage = br.readLine()) != null)
					con.textArea.append(runTimeMessage+"\n");
				synchronized(this){
					wait();
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//从控制台读错误数据
		public void consoleErrInput(){
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(po.getErrorStream()));
				String runTimeErr = null;
				while(true){
					while((runTimeErr = br.readLine()) != null)
						con.textArea.append(runTimeErr+"\n");
					synchronized(this){
						wait();
					}
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	
//	向控制台写数据
	public void consoleOutput(){
		try{
			PrintWriter pw = new PrintWriter(po.getOutputStream());
			String str = con.textFieldInput.getText();
			if(str.length() != 0){
				pw.write(str+"\n");
				pw.flush();
			}
			con.textArea.append(str+"\n");
			con.textFieldInput.setText("");	
			synchronized(this){
				notify();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}


