package cn.xia.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import cn.xia.util.GameUtil;

public class Planet extends Star{
	//除了图片坐标 行星沿着某个椭圆运行:长轴,短轴,速度,角度; 绕着某个Star.
	double longAxis;     
	double shortAxis;
	double speed;
	double degree;
	Star center;
	boolean satellite;
	
	

	public Planet(Star center,String imgpath, double longAxis, double shortAxis, double speed,boolean satellite) {
		this(center, imgpath, longAxis, shortAxis, speed);
		this.satellite = satellite;
	}
	
	public Planet(Star center,String imgpath, double longAxis, double shortAxis, double speed) {
		super(GameUtil.getImage(imgpath));
		this.center = center;
		this.x=center.x+longAxis;
		this.y=center.y;
		
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		
	}
	
	public void draw(Graphics g){
		//g.drawImage(img,(int)x,(int)y,null);
		super.draw(g);
		//沿着椭圆轨迹飞行
		if(!satellite){
			//drawTrace(g);
			
		}
		move();
	}
	
	public void move(){
		x=(center.x+15) + longAxis*Math.cos(degree);
		y=(center.y+15) + shortAxis*Math.sin(degree);
		
		degree +=speed;
	}
	
	public void drawTrace(Graphics g){
		double ovalX,ovalY,ovalWidth,ovalHeigth;
		
		ovalWidth=longAxis*2;
		ovalHeigth= shortAxis*2;
		ovalX=center.x-longAxis+15;
		ovalY=center.y-shortAxis+15;
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeigth);
		g.setColor(c);
	}
	
	
	public Planet(String imgpath, double x, double y) {
		super(imgpath, x, y);
	}
	public Planet(Image img, double x, double y) {
		super(img, x, y);
	}

}
