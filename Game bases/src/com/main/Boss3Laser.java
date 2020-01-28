package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
@SuppressWarnings("unused")
public class Boss3Laser extends GameObject{
	
	private int WidthLaser;
	private int HeightLaser;
	
	private Handler handler;
	
	private Random r=new Random();
	

	public Boss3Laser(float x, float y, ID id, Handler handler, int WidthLaser, int HeightLaser) {
		super(x, y, id);
		this.WidthLaser=WidthLaser;
		this.HeightLaser=HeightLaser;
//		velX=0;
//		velY=0;
		this.handler= handler;
	}
	public void tick() {
//		x+=velX;
//		y+=velY;
//		if(y<=0)
//			velY*=-1;
//		else if(y+HeightLaser>=Game.HEIGHT)
//			handler.removeObject(this);
//		if(x<=0) 
//			velX*=-1;
//		else if(x+WidthLaser>= Game.WIDTH)
//			handler.removeObject(this);

	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int)y, WidthLaser,HeightLaser);
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, WidthLaser,HeightLaser);
	}

}
