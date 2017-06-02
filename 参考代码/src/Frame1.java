

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.event.*;

public class Frame1 extends JFrame {
    Container c = new Container();

    Label la = new Label("请帮助边远山区的可怜儿童们!");

    JMenuBar jmb = new JMenuBar();

    JMenu file = new JMenu("File");

    JMenu edit = new JMenu("Edit");

    JMenu option = new JMenu("Option");

    JMenu about = new JMenu("about");

    JMenuItem open = new JMenuItem("Open");

    JMenuItem save = new JMenuItem("Save as");

    JMenuItem exit = new JMenuItem("Exit");

    JMenuItem copy = new JMenuItem("Copy");

    JMenuItem cut = new JMenuItem("Cut");

    JMenuItem paste = new JMenuItem("Paste");

    JMenuItem delete = new JMenuItem("DeleteAll");

    JMenuItem italic = new JMenuItem("Italic");

    JMenuItem bold = new JMenuItem("Bold");

    JMenuItem version = new JMenuItem("about");

    JMenuItem help = new JMenuItem("help");

    JTextPane ta = new JTextPane();

    JFileChooser chooser = new JFileChooser();

    FileInputStream filestream = null;

    myversion exitversion = new myversion();

    String selected = new String();

    int dot, mark;

    public Frame1() {
        chooser.setSize(400, 350);
        chooser.setDialogTitle("请帮助边远山区的可怜儿童们！");
        chooser.setVisible(true);
        la.setSize(200, 20);
        la.setBackground(Color.orange);
        Font f = new Font("TimesRoman", Font.PLAIN, 16);
        c = this.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(ta, "Center");
        this.setJMenuBar(jmb);
        jmb.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        jmb.add(file);
        jmb.add(edit);
        jmb.add(option);
        jmb.add(about);
        jmb.add(la);
        file.add(open);
        file.add(save);
        file.add(exit);
        edit.add(copy);
        edit.add(cut);
        edit.add(paste);
        edit.add(delete);
        option.add(italic);
        option.add(bold);
        about.add(version);
        about.add(help);
        open.addActionListener(new ListenActionForJfilechooser());
        save.addActionListener(new ListenActionForJfilechooser());
        exit.addActionListener(new exitListener());
        copy.addActionListener(new copyListener());
        cut.addActionListener(new cutListener());
        paste.addActionListener(new pasteListener());
        delete.addActionListener(new deleteListener());
        italic.addActionListener(new italicListener());
        bold.addActionListener(new boldListener());
        version.addActionListener(new showversion());
        ta.addCaretListener(new taListener());
        ta.setFont(f);
    }

    class boldListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Font f = new Font("TimesRoman", Font.BOLD, 16);
            ta.setFont(f);
        }
    }

    class italicListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Font f = new Font("TimesRoman", Font.ITALIC, 16);
            ta.setFont(f);
        }
    }
    

    class deleteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Font f = new Font("TimesRoman", Font.PLAIN, 16);
            ta.setText(null);
            ta.setFont(f);
        }
    }

    class cutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String s1 = new String();
            selected = selectedString();
            s1 = ta.getText();
            int length = s1.length();
            if (dot < mark) {
                ta.setText(s1.substring(0, dot) + s1.substring(mark, length));
            } else {
                ta.setText(s1.substring(0, mark) + s1.substring(dot, length));
            }
        }
    }

    class pasteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ta.paste();
        }
    }

    class taListener implements CaretListener {
        public void caretUpdate(CaretEvent e) {
            dot = e.getDot(); // 取得光标开始位置
            mark = e.getMark();// 取得光标结束位置
        }
    }

    class copyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            selected = selectedString();
        }
    }

    class exitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class ListenActionForJfilechooser implements ActionListener {
        int result;

        File file;

        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (e.getSource() == open) {
                int state = chooser.showOpenDialog(null);
                file = chooser.getSelectedFile();
                if (file != null && state == JFileChooser.APPROVE_OPTION) {
                    try {
                        filestream = new FileInputStream(file);
                        la.setText("打开的文件是：" + file.getName());
                    } catch (Exception e1) {
                        // TODO 自动生成 catch 块
                        e1.printStackTrace();
                    }
                    try {

                        ta.read(filestream, this);
                    } catch (Exception e1) {

                        e1.printStackTrace();
                    }
                }
            }
            if (e.getSource() == save) {
                result = chooser.showSaveDialog(ta);
                file = null;
                if (result == JFileChooser.APPROVE_OPTION) {
                    file = chooser.getSelectedFile();
                    la.setText("存储文件名为:" + file.getName());
                } else if (result == JFileChooser.CANCEL_OPTION) {
                    la.setText("您没有选择任何文件");
                }

                FileOutputStream fileOutStream = null;

                if (file != null) {
                    try {
                        fileOutStream = new FileOutputStream(file);
                    } catch (FileNotFoundException fe) {
                        la.setText("File Not Found");
                        return;
                    }

                    String content = ta.getText();

                    try {
                        fileOutStream.write(content.getBytes());
                    } catch (IOException ioe) {
                        la.setText("写入文件错误");
                    } finally {
                        try {
                            if (fileOutStream != null)
                                fileOutStream.close();
                        } catch (IOException ioe2) {
                        }
                    }
                }
            }

        }
    }

    class showversion implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            exitversion.setVisible(true);
        }
    }

    class myversion extends Frame {

        Label l1 = new Label("Author:  ChangTiger ");

        Label l2 = new Label("Version 0.1");

        Label l3 = new Label("2007.11.6");

        Label l4 = new Label("Tel:13576947833");

        myversion() {
            this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));

            this.add(l1);
            this.add(l2);
            this.add(l3);
            this.add(l4);

            this.setBounds(200, 180, 300, 200);

            this.addWindowListener(new myWindowListener());

        }
    }

    class myWindowListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            exitversion.setVisible(false);
        }
    }

    String selectedString() {
        String s = new String();
        s = ta.getText();
        if (dot < mark) {
            s = s.substring(dot, mark);
        } else {
            s = s.substring(mark, dot);
        }
        return s;
    }

    public static void main(String[] args) {
       /* Frame1 frame1 = new Frame1();
        frame1.setSize(500, 400);
        frame1.setVisible(true);*/
    	String[] aaa = new String[3];
		aaa[0] = "aaa";
		aaa[1] = "bbb";
		aaa[2] = "ccc";
		for(String a : aaa){
			System.out.print(" " +a);
		}
    }
}
 