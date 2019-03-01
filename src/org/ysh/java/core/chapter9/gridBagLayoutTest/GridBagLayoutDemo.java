package org.ysh.java.core.chapter9.gridBagLayoutTest;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * GridBagLayout实例
 * 这里对GridBagConstraints参数进行说明
 * gridx、gridy:这两个参数指定了组件左上角行和列的位置
 * gridwidth、gridheight指定了组件占据的行数和列数
 * weightx、weighty表示区域的增量域，如果设置为0，则这个区域永远为初始尺寸,在需要组件填充整个区域时建议设置为100
 * fill 用来指定这个组件如何填充整个区域,GridBagConstraints.NONE/BOTH/HORIZONTAL/VERTICLE分别表示不填充/都填充/水平方向填充/垂直方向填充
 * anchor 用于指定当组件不进行填充时，组件应该摆放在区域的什么位置
 * Insets对象的四个参数left,top,right,bottom分别指定左上右下四个位置的附加的空白区域（可以理解为外部填充）。
 * ipadx、ipady与Insets相对应，指定组件的内部填充
 * 
 * 指定gridx,gridy,gridwidth,gridheight有另一种方法
 * 可以将gridx、gridy设置为常量GridBagConstraints.RELATIVE。然后，按照标准的顺序，将组件添加到网格组布局中。
 * 即第一行从左向右，然后再开始新的一行，依次类推。通过gridwidth和gridheight给组件设置横跨的行数和列数，这里
 * 如果想让某个组件为最后一行或最后一列，则不要给出一个实际的数值，使用常量GridBagConstraints.REMAINDER来替代。这样
 * 会告诉布局管理器这个组件时本行上的最后一个组件。
 * @author yshin1992
 *
 */
public class GridBagLayoutDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GridBagLayoutDemo().new LoginFrame();
	}

	class LoginFrame extends JFrame{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 4883658002210492367L;

		private JLabel nameLabel,paswdLabel;
		
		private JTextField nameField;
		
		private JPasswordField pswdField;
		
		private JButton loginBtn,exitBtn;
		
		public LoginFrame(){
			GridBagLayout layout = new GridBagLayout();
			setLayout(layout);
			
			GridBagConstraints gbc = new GridBagConstraints(1, 0, 2, 1, 50d,50d, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 1, 1), 10,10);
			nameLabel = new JLabel("用户名");
			add(nameLabel,gbc);
			
			nameField = new JTextField();
			add(nameField,new GridBagConstraints(4, 0, 4, 1, 100d, 100d, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10,10,10,10), 10, 10));
			
			paswdLabel = new JLabel("密码");
			add(paswdLabel,new GridBagConstraints(1, 2, 1, 1, 50d,50d, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 1, 1), 10,10));
			
			
			pswdField = new JPasswordField();
			add(pswdField,new GridBagConstraints(4, 2, 4, 1, 100d, 100d, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10,10,10,10), 10, 10));
			
			add(new JLabel(""),new GridBagConstraints(0, 4, 1, 1, 0d,0d, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 1, 1), 10,10));
			loginBtn = new JButton("登录");
			add(loginBtn,new GridBagConstraints(1, 4, 2, 1, 50d,50d, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 1, 1), 10,10));
			add(new JLabel(""),new GridBagConstraints(4, 4, 1, 1, 50d,50d, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 1, 1), 10,10));
			exitBtn = new JButton("退出");
			add(exitBtn,new GridBagConstraints(5, 4, 2, 1, 50d,50d, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 1, 1), 10,10));
			add(new JLabel(""),new GridBagConstraints(8, 4, 1, 1, 0d,0d, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 1, 1), 10,10));
			
			this.setSize(320,180);
			this.setVisible(true);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setTitle("GridBagLayout Frame");
		}
	}
}
