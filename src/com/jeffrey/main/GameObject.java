package com.jeffrey.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	protected int x;
	protected int y;
	protected ID id;
	protected int velX, velY;
	protected int speed;
	
	public GameObject(int x, int y, ID id, int speed) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.speed = speed;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	
//	SET/GET METHODS 
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public ID getId() {
		return id;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public int getVelY() {
		return velY;
	}
	public int getVelX() {
		return velX;
	}
}
