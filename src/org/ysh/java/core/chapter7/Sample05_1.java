package org.ysh.java.core.chapter7;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.filechooser.FileFilter;

public class Sample05_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new ImageSelectorFrame();
			}
		});
	}

}

class ImageSelectorFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private JMenuBar bar = new JMenuBar();
	
	private JMenu fileMenu = new JMenu("文件(Alt+F)");
	
	private JMenuItem openItem = new JMenuItem("打开");
	
	private JMenuItem exitItem = new JMenuItem("退出");

	private JFileChooser fileChooser = new JFileChooser();
	
	private static final String[] imgSuffixes = {"bmp","jpg","tiff","gif","pcx","tga","exif","fpx","svg","cdr","pcd","dxf","ufo","eps","ai","raw"};
	
	private File imgFile;
	
	private DrawComponent drawComponent;
	
	private JToolBar toolBar = new JToolBar();
	
	private JButton previous = new JButton("上一张");
	
	private JButton next = new JButton("下一张");
	
	private JMenu lafmenu = new JMenu("Appearance");
	
	private class PreviousNextAction extends AbstractAction{
		
		private static final long serialVersionUID = 1L;
		private boolean isPrevious;
		
		public PreviousNextAction(boolean isPrevious){
			this.isPrevious = isPrevious;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//当图片为空时不触发寻找下一张图片的功能
			if(null == imgFile){
				return;
			}
			File currentDirectory = fileChooser.getCurrentDirectory();
			File[] fileLst = currentDirectory.listFiles(new java.io.FileFilter() {
				
				@Override
				public boolean accept(File pathname) {
					// TODO Auto-generated method stub
					return isImage(pathname);
				}
			});
			String imgFileName = imgFile.getName();
			int index = 0;
			for(int i=0;i<fileLst.length;i++){
				if(fileLst[i].getName().equals(imgFileName)){
					index = i;
					break;
				}
			}
			
			if(isPrevious){
				if(index == 0){
					imgFile = fileLst[index];
				}else{
					imgFile = fileLst[index-1];
				}
			}else{
				if(index == fileLst.length-1){
					imgFile = fileLst[index];
				}else{
					imgFile = fileLst[index + 1];
				}
			}
			drawComponent.repaint();
		}
	};
	
	/**
	 * 外观菜单栏项设置
	 */
	private void makeMenus(){
		LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
		if(null != installedLookAndFeels && installedLookAndFeels.length>0){
			for(final LookAndFeelInfo laf : installedLookAndFeels){
				JMenuItem item = new JMenuItem(laf.getName());
				lafmenu.add(item);
				item.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							UIManager.setLookAndFeel(laf.getClassName());
							SwingUtilities.updateComponentTreeUI(ImageSelectorFrame.this);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
			}
		}
	}
	
	class DrawComponent extends JComponent{

		private static final long serialVersionUID = 1L;

		private void drawImage(Graphics g,BufferedImage img){
			int imgHeight = img.getHeight();
			int imgWidth = img.getWidth();
			//将图片绘制在中心，如果图片长度或宽度大于图片面板的长度或宽度，则按照图片比例进行绘制
			int contW = this.getWidth();
			int contH = this.getHeight();
			
			if(imgHeight > contH){
				//图片高度 大于 面板高度的时候，将高度至于最大，图片宽度等比例缩小
				imgWidth = imgWidth * contH / imgHeight;
				imgHeight = contH;
				//注意如果图片缩小后的宽度仍然大于面板宽度的话，则进一步按照等比例将高度进行缩小
				if(imgWidth > contW){
					imgHeight = imgHeight * contW / imgWidth;
					imgWidth = contW;
				}
				
			}else if(imgWidth > contW){
				//图片宽度大于面板宽度的处理办法与上述相同
				imgHeight = imgHeight * contW / imgWidth;
				imgWidth = contW;
				if(imgHeight > contH){
					imgWidth = imgWidth * contH / imgHeight;
					imgHeight = contH;
				}
			}
			g.drawImage(img, (contW-imgWidth)/2,(contH - imgHeight)/2,imgWidth,imgHeight,null);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			if(null == imgFile)
				return;
			try {
				BufferedImage img = ImageIO.read(imgFile);
				drawImage( g, img);
			} catch (IOException e) {
				System.err.println(imgFile.getName());
				e.printStackTrace();
				//下述代码会导致图片失真
				/*if ("Unsupported Image Type".equals(e.getMessage())) {
					// Find a suitable ImageReader
						final Iterator<?> readers = ImageIO.getImageReadersByFormatName("JPEG");
						ImageReader reader = null;
						while (readers.hasNext()) {
							reader = (ImageReader) readers.next();
							if (reader.canReadRaster()) {
								break;
							}
						}
						// Stream the image file (the original CMYK image)
						ImageInputStream input;
						try {
							input = ImageIO.createImageInputStream(new FileInputStream(imgFile));
							reader.setInput(input);
							// Read the image raster
							final Raster raster = reader.readRaster(0, null);
							// Create a new RGB image
							final BufferedImage bi = new BufferedImage(raster.getWidth(),
							raster.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);
							// Fill the new image with the old raster
							bi.getRaster().setRect(raster);
							drawImage(g,bi);
						} catch (IOException e1) {
							System.out.println(imgFile.getName());
							e1.printStackTrace();
						}
						
					}*/
			}
		}
	}
	
	public ImageSelectorFrame(){
		//添加快捷键
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		//添加打开文件的事件监听器
		openItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				if(fileChooser.showOpenDialog(ImageSelectorFrame.this) == JFileChooser.APPROVE_OPTION){
					imgFile = fileChooser.getSelectedFile();
					//重绘面板
					drawComponent.repaint();
				}
			}
		});
		
		//添加快捷键Ctrl E
		exitItem.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(JOptionPane.showConfirmDialog(ImageSelectorFrame.this, "确认退出?") == JOptionPane.OK_OPTION){
					System.out.println("Sytem exit");
					System.exit(0);
				}
			}
		});
		fileMenu.add(openItem);
		fileMenu.setMnemonic('F');
		fileMenu.add(exitItem);
		bar.add(fileMenu);
		
		makeMenus();
		bar.add(lafmenu);
		
		
		//初始化FileChooser的当前目录、文件过滤
		fileChooser.setCurrentDirectory(new File("/"));
		fileChooser.setFileFilter(imgFilter);
		//设置只能单选
		fileChooser.setMultiSelectionEnabled(false);;
		
		drawComponent = new DrawComponent();
		this.add(drawComponent,BorderLayout.CENTER);
		
		previous.addActionListener(new PreviousNextAction(true));
		next.addActionListener(new PreviousNextAction(false));
		toolBar.add(previous);
		toolBar.add(next);
		
		//添加快捷键，实现Ctrl + <- 实现翻看上一张图片的功能
		ActionMap preAm = previous.getActionMap();
		preAm.put("previous", new PreviousNextAction(true));
		InputMap preIm = previous.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		preIm.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, InputEvent.CTRL_MASK), "previous");
		//再添加一个快捷键，验证一个ActionMap可以对应多个InputMap
		preIm.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK), "previous");
		
		//添加快捷键，实现Ctrl + -> 实现翻看下一张图片的功能
		ActionMap nextAm = next.getActionMap();
		nextAm.put("next", new PreviousNextAction(false));
		InputMap nextIm = next.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		nextIm.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, InputEvent.CTRL_MASK), "next");
		
		nextIm.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK), "next");
		
		this.add(toolBar,BorderLayout.NORTH);
		this.setJMenuBar(bar);
		
		this.setSize(1024,900);
		
		this.setTitle("图片浏览器");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
	
	
	private FileFilter imgFilter = new FileFilter() {
		
		@Override
		public String getDescription() {
			return Arrays.toString(imgSuffixes);
		}
		
		@Override
		public boolean accept(File f) {
			return isImage(f) || f.isDirectory();
		}
	};
	
	private boolean isImage(File f){
		if(null == f) 
			return false;
		String fileSuffix = f.getName().substring(f.getName().lastIndexOf('.') + 1).toLowerCase();
		for(String suffix : imgSuffixes){
			if(suffix.equals(fileSuffix)){
				return true;
			}
		}
		return false;
	}
}

