package com.jeffrey.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HealthPlus extends GameObject{

	public HealthPlus(int x, int y, ID id, int speed) {
		super(x, y, id, speed);
	}

	public void tick() {
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x,y,16,16);
	}

	
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}
	
}
