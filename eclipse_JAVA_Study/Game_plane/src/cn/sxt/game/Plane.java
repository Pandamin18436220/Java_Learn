package cn.sxt.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject{
	boolean left,up,right,down;
	int speed=3;
	boolean live=true;
	public Plane(Image planeImg, double x, double y) {
		// TODO Auto-generated constructor stub
		this.img=planeImg;
		this.x=x;
		this.y=y;
		this.width=planeImg.getWidth(null);
		this.height=planeImg.getHeight(null);
	}

	public void drawSelf(Graphics g){
		if(live){
		g.drawImage(img, (int)x, (int)y, null);
		if(left){
			x-=speed;
		}
		if(right){
			x+=speed;
		}
		if(up){
			y-=speed;
		}
		if(down){
			y+=speed;
		}
	  }else{
		  
	  }
	}
	//增加相应方向
	public void addDirection(KeyEvent e){
		//System.out.println("###"+e.getKeyCode());
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left=true;
			break;
		case KeyEvent.VK_UP:
			up=true;
			break;
		case KeyEvent.VK_RIGHT:
			right=true;
			break;
		case KeyEvent.VK_DOWN:
			down=true;
			break;
		}
	}
	//取消相应方向
	public void minuDirection(KeyEvent e){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left=false;
			break;
		case KeyEvent.VK_UP:
			up=false;
			break;
		case KeyEvent.VK_RIGHT:
			right=false;
			break;
		case KeyEvent.VK_DOWN:
			down=false;
			break;
		}
	}
	
}
