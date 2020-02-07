package com.jeffrey.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {
	
	private Handler handler;
	private int HEALTH;
	public static int BasicEnemyCount = 0;


	public BasicEnemy(int x, int y, ID id, Handler handler, int speed, int HEALTH) {
		super(x, y, id, speed);
		velX = 5;
		velY = 5;
		this.handler = handler;
		this.speed = speed;
		this.HEALTH = HEALTH;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	private void collision() {
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i); 
			if(tempObject.id == ID.Bullet) {
				if(getBounds().intersects(tempObject.getBounds())) {
					this.HEALTH -= 20;
					handler.removeObject(tempObject);
				}
			}
		}
	}
	
	public void tick() {
		if(HEALTH <= 0) {
			handler.removeObject(this);
			BasicEnemyCount -=  1;
		}
		x += velX;
		y += velY;
		
		collision();
		
		if(y <= 0 || y >= Game.HEIGHT -32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
		
//		handler.addObject(new Trail(x,y,ID.Trail,Color.red, 32, 32, 0.08f, handler, 0));
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x,y,32,32);
		g.setColor(Color.green);
		g.fillRect(x, y-10, this.HEALTH/3, 4);
		
	}
	
}
