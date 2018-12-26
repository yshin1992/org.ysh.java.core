package org.ysh.java.core.chapter10;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MusicPlayerApplet extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String FILE_URL_PREFIX = "file:///";
	
	private JButton selectBtn;
	
	private JFileChooser chooser = new JFileChooser();
	
	@Override
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				selectBtn = new JButton("Select Music File");
				chooser.setCurrentDirectory(new File("E:/CloudMusic"));
				chooser.setFileFilter(new FileNameExtensionFilter("Music File", "wav","au"));
				
				selectBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int result = chooser.showOpenDialog(MusicPlayerApplet.this);
						if(JFileChooser.APPROVE_OPTION == result){
							URL url;
							try {
								url = new URL(FILE_URL_PREFIX + chooser.getSelectedFile().getAbsolutePath());
								MusicPlayerApplet.this.play(url);
							} catch (MalformedURLException e1) {
								e1.printStackTrace();
							}
						}
					}
				});
				add(selectBtn);
			}
		});
	}

}
