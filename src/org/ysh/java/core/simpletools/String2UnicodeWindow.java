package org.ysh.java.core.simpletools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 主窗口
 * @author MCXR
 *
 */
public class String2UnicodeWindow extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7728285587749826103L;

	//窗体的宽度
	private static final int WINDOW_WIDTH = 800;
	//窗体的高度
	private static final int WINDOW_HEIGHT = 600;
	//控件之间的行间距
	private static final int LINE_SEPERATE = 10;
	//控件的高度
	private static final int COMPONENTS_HEIGHT = 30;
	
	private static final int ALIGNMENT_SEPERATE = 10;
	
	private static final int COMPONENTS_MAX_WIDTH = WINDOW_WIDTH - 2 * ALIGNMENT_SEPERATE;
	
	private JPanel mainPanel; //主面板
	
	private JButton convertBtn1,convertBtn2;//转换按钮
	
//	private JCheckBox AlphabetBox,PunctuationBox;//忽略字母和符号
	
	private JLabel titleLabel1,titleLabel2,resultLabel;//标题标签
	
	//ascii文本框，转换的UTF8结果文本框，UTF8文本框，转换的ascii文本框
	private JTextField stringField,unicodeResultField,unicodeField,stringResultField;
	
	public String2UnicodeWindow() {
		// TODO 自动生成的构造函数存根
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		this.add(mainPanel);
		
		//Line 1
		titleLabel1 = new JLabel("中文 --> Unicode编码");
		titleLabel1.setBounds(ALIGNMENT_SEPERATE, LINE_SEPERATE, COMPONENTS_MAX_WIDTH, COMPONENTS_HEIGHT);
		mainPanel.add(titleLabel1);
		
		/**
		 * 忽略字母和符号的后期添加
		 */
//		AlphabetBox = new JCheckBox();
//		PunctuationBox = new JCheckBox();
		
		//Line 2
		stringField = new JTextField();
		stringField.setBounds(ALIGNMENT_SEPERATE,COMPONENTS_HEIGHT + LINE_SEPERATE, WINDOW_WIDTH - 200, COMPONENTS_HEIGHT );
		mainPanel.add(stringField);
		
		convertBtn1 = new JButton("转换");
		convertBtn1.setBounds(WINDOW_WIDTH - 170, COMPONENTS_HEIGHT + LINE_SEPERATE, 160, COMPONENTS_HEIGHT);
		convertBtn1.addActionListener(this);
		mainPanel.add(convertBtn1);
		
		//Line 3
		resultLabel = new JLabel("转换结果");
		resultLabel.setBounds(ALIGNMENT_SEPERATE,(COMPONENTS_HEIGHT + LINE_SEPERATE)*2,COMPONENTS_MAX_WIDTH ,COMPONENTS_HEIGHT);
		mainPanel.add(resultLabel);
		//Line 4
		unicodeResultField = new JTextField();
		unicodeResultField.setBounds(ALIGNMENT_SEPERATE,(COMPONENTS_HEIGHT + LINE_SEPERATE)*3,COMPONENTS_MAX_WIDTH ,COMPONENTS_HEIGHT);
		unicodeResultField.setEditable(false);
		mainPanel.add(unicodeResultField);
		
		//Line 5
		titleLabel2 = new JLabel("Unicode编码 --> 汉字");
		titleLabel2.setBounds(ALIGNMENT_SEPERATE,(COMPONENTS_HEIGHT + LINE_SEPERATE)*4,COMPONENTS_MAX_WIDTH,COMPONENTS_HEIGHT);
		mainPanel.add(titleLabel2);
		
		//Line 6
		unicodeField = new JTextField();
		unicodeField.setBounds(ALIGNMENT_SEPERATE,(COMPONENTS_HEIGHT + LINE_SEPERATE)*5, WINDOW_WIDTH - 200, COMPONENTS_HEIGHT );
		mainPanel.add(unicodeField);
		
		convertBtn2 = new JButton("转换");
		convertBtn2.setBounds(WINDOW_WIDTH - 170, (COMPONENTS_HEIGHT + LINE_SEPERATE)*5, 160, COMPONENTS_HEIGHT);
		convertBtn2.addActionListener(this);
		mainPanel.add(convertBtn2);
		
		//Line 7
		resultLabel = new JLabel("转换结果");
		resultLabel.setBounds(ALIGNMENT_SEPERATE,(COMPONENTS_HEIGHT + LINE_SEPERATE)*6,COMPONENTS_MAX_WIDTH ,COMPONENTS_HEIGHT);
		mainPanel.add(resultLabel);
		
		//Line 8
		stringResultField = new JTextField();
		stringResultField.setBounds(ALIGNMENT_SEPERATE,(COMPONENTS_HEIGHT + LINE_SEPERATE)*7,COMPONENTS_MAX_WIDTH ,COMPONENTS_HEIGHT);
		stringResultField.setEditable(false);
		mainPanel.add(stringResultField);
		
		this.setTitle("中文和Unicode编码转换工具");
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new String2UnicodeWindow();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource() == convertBtn1)
		{
			String chinese = stringField.getText();
			String translateResult = String2UnicodeTool.string2Unicode(chinese);
			System.out.println(translateResult);
			unicodeResultField.setText(translateResult);
		}
		else if(e.getSource() == convertBtn2)
		{
			String unicodes = unicodeField.getText();
			String chinese = String2UnicodeTool.unicode2String(unicodes);
			System.out.println(chinese);
			stringResultField.setText(chinese);
		}
	}
}
