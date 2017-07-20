package org.ysh.java.core.simpletools;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class JSFTPFrame extends JDialog{
	private static final long serialVersionUID = 1L;
	
	public JSFTPFrame(){
			setLayout(new BorderLayout());
			JPanel panel = new JPanel();
			add(panel,BorderLayout.NORTH);
			panel.add(new JLabel("username"));
			final JTextField unameField = new JTextField(15);
			panel.add(unameField);
			panel.add(new JLabel("password"));
			final JTextField pswdField = new JTextField(15);
			panel.add(pswdField);
			panel.add(new JLabel("ip/port"));
			final JTextField ipField = new JTextField();
			ipField.setColumns(15);
			panel.add(ipField);
			panel.add(new JLabel(":"));
			final JTextField portField = new JTextField(5);
			panel.add(portField);
			panel.add(new JLabel("path:"));
			final JTextField pathField = new JTextField(30);
			panel.add(pathField);
			JButton btn = new JButton("Query");
			panel.add(btn);
			final JTextArea resArea = new JTextArea();
			JScrollPane sp = new JScrollPane(resArea);
			add(sp,BorderLayout.CENTER);
			
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String uname = unameField.getText();
					String pswd = pswdField.getText();
					String host = ipField.getText();
					int port = Integer.parseInt(portField.getText());
					String path = pathField.getText();
					
					try {
						Vector<LsEntry> filelst = sshSFtp(host,port,uname,pswd,path);
						Iterator<LsEntry> iter = filelst.iterator();
						StringBuilder builder = new StringBuilder("");
						while(iter.hasNext()){
							LsEntry next = iter.next();
							builder.append(next+"\r\n");
						}
						
						resArea.setText(builder.toString());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			
			setTitle("SFTP Client");
			setSize(1400,600);
			setVisible(true);
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		sshSFtp("192.168.0.167", 22, "root", "root","/");
		new JSFTPFrame();
	}

	private static Vector<LsEntry> sshSFtp(String host,int port,String uname,String pswd,String path) throws Exception{
		
		Session session = null;
		ChannelSftp channel = null;
		
		JSch jsch = new JSch();
		//采用指定的端口连接服务器
		session = jsch.getSession(uname, host, port);
		//如果服务器连接不上，则抛出异常
		if(null == session){
			throw new Exception("session is null");
		}
		//设置登陆主机的密码
		session.setPassword(pswd);
		//设置第一次登陆的时候提示，可选值：(ask | yes | no)
		session.setConfig("StrictHostKeyChecking", "no");
		//设置登陆超时时间
		session.connect(30000);
		
		channel = (ChannelSftp) session.openChannel("sftp");
		channel.connect(1000);
		
		Vector<LsEntry> filelst = channel.ls(path);//遍历该目录------
		//进入服务器指定的文件夹上下两行代码的顺序一定不能乱，
		//不然就会报出2:No Such file的错误error，而不是异常exception了。
		channel.cd(path);
		/*Iterator<LsEntry> iter = filelst.iterator();
		
		while(iter.hasNext()){
			LsEntry next = iter.next();
			System.out.println(next.getFilename());
		}*/
		
		session.disconnect();
		channel.disconnect();
		
		return filelst;
	}
}
