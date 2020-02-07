package com.jeffrey.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SpeedPlus extends GameObject{

	public SpeedPlus(int x, int y, ID id, int speed) {
		super(x, y, id, speed);
	}

	public void tick() {
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(x, y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}
	
}
