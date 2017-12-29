package org.ysh.java.core.chapter11;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

/**
 * 屏幕截图测试
 * @author ysh
 *
 */
public class PrintScreenDemo {

	public static void main(String[] args) throws AWTException, IOException {
		// TODO Auto-generated method stub
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice screen = environment.getDefaultScreenDevice();
        Robot robot = new Robot(screen);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        BufferedImage image = robot.createScreenCapture(new Rectangle(0, 0, screenSize.width, screenSize.height));
        File imgFile = new File("/home/ysh/screen_captcha.jpg");
        OutputStream os = new FileOutputStream(imgFile);
        ImageIO.write(image, "jpeg", os);
	}

}
