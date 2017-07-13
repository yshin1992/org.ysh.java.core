package org.ysh.java.core.chapter9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * JTextArea
 * @author yshin1992
 *
 */
public class Sample03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JTextAreaFrame();
	}

}

class JTextAreaFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JTextAreaFrame(){
		setTitle("TextArea Component");
		setSize(400,400);
		
		JPanel northPanel = new JPanel(new GridLayout(2,2));
		northPanel.add(new JLabel("username",SwingConstants.RIGHT));
		final JTextField nameField = new JTextField();
		northPanel.add(nameField);
		northPanel.add(new JLabel("password",SwingConstants.RIGHT));
		final JPasswordField pswdField = new JPasswordField();
		northPanel.add(pswdField);
		
		add(northPanel,BorderLayout.NORTH);
		
		final JTextArea textArea = new JTextArea(8,40);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.setViewportView(textArea);
		
		add(scrollPanel,BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel(new FlowLayout());
		JButton insertBtn = new JButton("Insert");
		insertBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textArea.getText();
				text += nameField.getText() + "/" + new String(pswdField.getPassword())+"\n";
				textArea.setText(text);
			}
		});
		southPanel.add(insertBtn);
		add(southPanel,BorderLayout.SOUTH);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}