package cn.sxt.game;

import java.awt.Graphics;
import java.awt.Image;

public class Explode {

	/**
	 * @param args
	 */
	double x,y;
	static Image[] imgs=new Image[6];
	static{
		for(int i=0;i<6;i++){
			imgs[i]=GameUtil.getImage("images/explode/e"+(i+1)+"png");
			imgs[i].getWidth(null);
			
		}
	}
	int count;
	public void draw(Graphics g){
		if(count<=5){
			g.drawImage(imgs[count], (int)x, (int)y, null);
			count++;
			System.out.println("count="+count);
		}
	}
	
	public Explode(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
