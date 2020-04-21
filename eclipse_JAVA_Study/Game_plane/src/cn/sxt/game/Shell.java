package cn.sxt.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 * ÅÚµ¯Àà
 * @author Pandamin
 *
 */
public class Shell extends GameObject{
	double degree;

	public Shell() {
		x=200;
		y=200;
		width=10;
		height=10;
		speed=3;
		degree=Math.random()*Math.PI*2;
	}
	@Override
	public void drawSelf(Graphics g) {
		// TODO Auto-generated method stub
		super.drawSelf(g);
		Color c=g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval((int)x, (int)y, width, height);
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		
		//±ß½ç·´µ¯
		if(x<0||x>Constant.GAME_WIDH-width){
			degree=Math.PI-degree;
		}
		if(y<0||y>Constant.GAME_HEIGHT-height)
			degree=-degree;
	}
	
}
