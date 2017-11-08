package cn.xia.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{
	
	/**
	 * 加载窗口
	 */
	public void launchFrame() {
		setSize(Constant.GAME_WIDTH, Constant.GAME_HIGTH);
		setLocation(0, 0);
		setVisible(true);
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
	}
	private Image offScreenImage = null; //双缓冲解决闪屏
	public void update(Graphics g){
		if(offScreenImage == null){
			offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HIGTH);
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage,0,0,null);
	}
	
	/**
	 * 定义一个重画窗口的线程类
	 * @author hp
	 *
	 */
	class PaintThread extends Thread{
		
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
