package org.ysh.java.core.chapter9;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Slider实例
 * @author yansh
 *
 */
public class Sample07 {

	public static void main(String[] args) {
		try {
			new SliderFrame();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	static class SliderFrame extends JFrame{

		private static final long serialVersionUID = 1L;
		//用于存放各个Slider和Label
		private JPanel sliderPanel;
		//用于显示Slider的值
		private JTextField text;
		//Slider滑动事件监听器
		private ChangeListener listener;
		
		public SliderFrame() throws IOException {
			setTitle("Slider Frame");
			setSize(350,450);
			
			//初始化SliderPanel
			sliderPanel = new JPanel();
			sliderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			//初始化事件监听器，监听滑块滑动的结果值
			listener = new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					JSlider  source = (JSlider) e.getSource();
					text.setText(source.getValue() + "");
				}
			};
			
			JSlider slider = new JSlider();
			//普通的Slider
			addSlider(slider, "Plain");
			
			//设置带有标尺的Slider
			slider = new JSlider();
			slider.setPaintTicks(true);//显示标尺
			slider.setMajorTickSpacing(20);//按照给定的滑块单元的倍数设置大标尺
			slider.setMinorTickSpacing(5);//按照给定的滑块单元的倍数设置小标尺
			addSlider(slider, "Ticks");
			
			//设置自动对齐标尺的slider
			slider = new JSlider();
			slider.setPaintTicks(true);//显示标尺
			slider.setMajorTickSpacing(20);//按照给定的滑块单元的倍数设置大标尺
			slider.setMinorTickSpacing(5);//按照给定的滑块单元的倍数设置小标尺
			slider.setSnapToTicks(true);//设置对齐标尺
			addSlider(slider, "Snap to tick");
			
			//设置不显示滑块轨迹的slider
			slider = new JSlider();
			slider.setPaintTicks(true);//显示标尺
			slider.setMajorTickSpacing(20);//按照给定的滑块单元的倍数设置大标尺
			slider.setMinorTickSpacing(5);//按照给定的滑块单元的倍数设置小标尺
			slider.setSnapToTicks(true);//设置对齐标尺
			slider.setPaintTrack(false);//不显示滑块轨迹
			addSlider(slider, "No track");
			
			//设置标向反转的slider
			slider = new JSlider();
			slider.setPaintTicks(true);//显示标尺
			slider.setMajorTickSpacing(20);//按照给定的滑块单元的倍数设置大标尺
			slider.setMinorTickSpacing(5);//按照给定的滑块单元的倍数设置小标尺
			slider.setSnapToTicks(true);//设置对齐标尺
			slider.setInverted(true);//不显示滑块轨迹
			addSlider(slider, "Inverted");
			
			//设置显示刻度的Slider
			slider = new JSlider();
			slider.setPaintTicks(true);//显示标尺
			slider.setMajorTickSpacing(20);//按照给定的滑块单元的倍数设置大标尺
			slider.setMinorTickSpacing(5);//按照给定的滑块单元的倍数设置小标尺
			slider.setSnapToTicks(true);//设置对齐标尺
			slider.setPaintLabels(true);//显示标尺的刻度
			addSlider(slider, "Paint Labels");
			
			//设置自定义的刻度的Slider
			slider = new JSlider();
			slider.setPaintTicks(true);//显示标尺
			slider.setMajorTickSpacing(20);//按照给定的滑块单元的倍数设置大标尺
			slider.setMinorTickSpacing(5);//按照给定的滑块单元的倍数设置小标尺
			slider.setSnapToTicks(true);//设置对齐标尺
			slider.setPaintLabels(true);//显示标尺的刻度
			Dictionary<Integer,Component> labelTable= new Hashtable<Integer,Component>();
			labelTable.put(0, new JLabel("A"));
			labelTable.put(20, new JLabel("B"));
			labelTable.put(40, new JLabel("C"));
			labelTable.put(60, new JLabel("D"));
			labelTable.put(80, new JLabel("E"));
			labelTable.put(100, new JLabel("F"));
			slider.setLabelTable(labelTable);
			addSlider(slider, "Custome Labels");
			
			//使用图片作为刻度标签的Slider
			slider = new JSlider();
			slider.setPaintTicks(true);//显示标尺
			slider.setMajorTickSpacing(20);//按照给定的滑块单元的倍数设置大标尺
			slider.setMinorTickSpacing(5);//按照给定的滑块单元的倍数设置小标尺
			slider.setSnapToTicks(true);//设置对齐标尺
			slider.setPaintLabels(true);//显示标尺的刻度
			Dictionary<Integer,Component> iconTable= new Hashtable<Integer,Component>();
			BufferedImage icon =ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("album1.png"));
			iconTable.put(0, new JLabel(new ImageIcon(icon)));
			iconTable.put(20, new JLabel(new ImageIcon(icon)));
			iconTable.put(40, new JLabel(new ImageIcon(icon)));
			iconTable.put(60, new JLabel(new ImageIcon(icon)));
			iconTable.put(80, new JLabel(new ImageIcon(icon)));
			iconTable.put(100, new JLabel(new ImageIcon(icon)));
			slider.setLabelTable(iconTable);
			addSlider(slider, "Icon Labels");
			
			text  = new JTextField();
			add(sliderPanel,BorderLayout.CENTER);
			add(text,BorderLayout.SOUTH);
			
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		//用于添加新的Slider
		private void addSlider(JSlider s,String description) {
			s.addChangeListener(listener);
			JPanel panel = new JPanel();
			panel.add(new JLabel(description));
			panel.add(s);
			sliderPanel.add(panel);
		}
		
	}
}

