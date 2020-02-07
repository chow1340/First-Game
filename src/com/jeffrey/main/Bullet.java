package com.jeffrey.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

public class Bullet extends GameObject{
	
	private Handler handler;
	private String direction;
		
	private Bullet bullet;
	
	public Bullet(int x, int y, ID id, int speed, Handler handler, String direction) {
		super(x, y, id, speed);
		this.handler = handler;
		this.direction = direction;
	}

	public void tick() {
//		x += speed;
//		y += speed;
//		
//		System.out.println(handler.object.size());
		
		if(x > Game.WIDTH || x < 0) {
			handler.object.remove(this);
		}
		
		if(y>Game.HEIGHT  || y < 0) {
			handler.object.remove(this);
		}
		
		switch(direction) {
			case "up": 
				y -= speed;
				break;
			
			case "down":
				y += speed;
				break;
			
			case "left":
				x -= speed;
				break;
			
			case "right":
				x += speed;
				break;
				
			default:
				y -= speed;
				
		}
	}
	
	
//	private void clamp(int var, int min, int max) {
//		if(var >= max || var <= min) {
//			handler.removeObject(this);
//		}
//		
//	}
	

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x,y,7,7);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,10,10);
	}

}


