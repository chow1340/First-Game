package com.jeffrey.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {

	private Handler handler;
	private int health;
	public static int FastEnemyCount =0;

	public FastEnemy(int x, int y, ID id, Handler handler, int speed, int health) {
		super(x, y, id, speed);
		velX = speed;
		velY = speed;
		this.handler = handler;
		this.speed = speed;
		this.health = health;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(this.health <= 0) {
			handler.removeObject(this);
			FastEnemyCount -= 1;
		}
		
		if(y <= 0 || y >= Game.HEIGHT -32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
		
		handler.addObject(new Trail(x,y,ID.Trail,Color.cyan, 16, 16, 0.06f, handler, 0));
		
		collision();
	}

	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(x,y,16,16);
		g.setColor(Color.green);
		g.fillRect(x, y-10, this.health/3, 4);
		
		
	}
	private void collision() {
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i); 
			if(tempObject.id == ID.Bullet) {
				if(getBounds().intersects(tempObject.getBounds())) {
					this.health -= 34;
					handler.removeObject(tempObject);
				}
			}
		}
	}
	
}
