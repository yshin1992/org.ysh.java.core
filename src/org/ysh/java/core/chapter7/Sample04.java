package org.ysh.java.core.chapter7;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Sample04 {

	static void fontList(){
		String[] fontFamilyNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for(String fontFamily : fontFamilyNames){
			System.out.println(fontFamily);
		}
		
		System.out.println("Total : " + fontFamilyNames.length);
	}
	
	public static void main(String[] args) {
//		fontList();
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new FontFrame();
			}
		});
	}
	
}


class FontFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FontFrame(){
		setTitle("Draw String");
		setSize(300,200);
		
		FontComponent comp = new FontComponent();
		this.add(comp);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

class FontComponent extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D) g;
		
		String msg = "Hello,World";
		
		//设置字体
		Font font = new Font("Liberation Mono",Font.PLAIN,36);
		g2D.setFont(font);
		
		//获取字体的有关
		FontMetrics metrics = getFontMetrics(font);
		//上坡度
		System.out.println(metrics.getAscent());
		System.out.println(metrics.getDescent());
		System.out.println(metrics.getLeading());
		
		//返回这个图形文本中，指定字体特征的字体绘制环境
		FontRenderContext frc = g2D.getFontRenderContext();
		//获取字符串的边界
		Rectangle2D bounds = font.getStringBounds(msg, frc);
		
		//设法让字符串水平和垂直居中
		double x = (this.getWidth()-bounds.getWidth())/2;
		double y = (this.getHeight()-bounds.getHeight())/2;
		
		LineMetrics lm = metrics.getLineMetrics(msg, g);
		System.out.println(lm.getAscent());
		System.out.println(lm.getDescent());
		System.out.println(lm.getLeading());
		
		//获取基线位置
		double ascent = -bounds.getY();
		double baseY = y + ascent;
		
		g2D.drawString(msg, (int)x, (int)baseY);
		
		g2D.setPaint(Color.LIGHT_GRAY);
		
		g2D.draw(new Line2D.Double(x,baseY,x+bounds.getWidth(),baseY));
		Rectangle2D rect = new Rectangle2D.Double();
		rect.setFrameFromDiagonal(x,y,x+bounds.getWidth(),y+bounds.getHeight());
		g2D.draw(rect);
	}
	
	
	
}