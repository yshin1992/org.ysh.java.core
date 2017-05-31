package org.ysh.java.core.chapter7;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Sample05 {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ImageFrame();
			}
		});
	}
}

class ImageFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageFrame(){
		setTitle("Draw Image");
		setSize(400,400);
		
		ImageComponent comp = new ImageComponent("album1.png");
		this.add(comp);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

class ImageComponent extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String src;
	
	public ImageComponent(String src){
		this.src = src;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		if(null == src)
			return;
		
		try {
			BufferedImage bufferedImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(src));
			
			g.drawImage(bufferedImage, 0,0, null);
			
			int imgWidth = bufferedImage.getWidth();
			
			int imgHeight = bufferedImage.getHeight();
			
			for(int i = 0 ; i * imgWidth < getWidth();i++){
				for(int j=0;j*imgHeight < getHeight();j++){
					if( i+ j >0){
						g.copyArea(0, 0, imgWidth, imgHeight, i * imgWidth, j*imgHeight);
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}