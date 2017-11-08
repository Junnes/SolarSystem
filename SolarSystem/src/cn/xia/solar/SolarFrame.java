package cn.xia.solar;

import java.awt.Graphics;
import java.awt.Image;

import cn.xia.util.Constant;
import cn.xia.util.GameUtil;
import cn.xia.util.MyFrame;

/**
 * 太阳系的主窗口
 * @author hp
 *
 */
public class SolarFrame extends MyFrame{
	Image bg = GameUtil.getImage("image/back.jpg");
	Star sun = new Star("image/sun30.png",Constant.GAME_WIDTH/2,Constant.GAME_HIGTH/2);
	Planet shui = new Planet(sun,"image/shui.png",50,40,0.09);
	Planet jin = new Planet(sun,"image/jin.png",100,60,0.08);
	Planet earth = new Planet(sun,"image/di.png",150,80,0.07);
	Planet yue = new Planet(earth,"image/yue.png",30,30,0.1,true);
	Planet huo = new Planet(sun,"image/huo.png",200,100,0.05);
	Planet mu = new Planet(sun,"image/mu.png",300,200,0.04);
	Planet tu = new Planet(sun,"image/tu.png",360,240,0.03);
	Planet tian = new Planet(sun,"image/tian.png",400,270,0.02);
	Planet hai = new Planet(sun,"image/hai.png",460,300,0.01);
	
	public void paint(Graphics g){
		g.drawImage(bg,0,0,null);
		sun.draw(g);
		shui.draw(g);
		jin.draw(g);
		earth.draw(g);
		yue.draw(g);
		huo.draw(g);
		mu.draw(g);
		tu.draw(g);
		tian.draw(g);
		hai.draw(g);
	}
	
	public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}
}
