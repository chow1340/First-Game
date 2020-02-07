package com.jeffrey.main;

import java.awt.Color;
import java.awt.Graphics;

import com.jeffrey.main.Game.STATE;

public class HUD {
	
	public static int HEALTH = 10;
	private int greenValue = 255;
	
	public static int score = 0;
	private int level = 1;
	private Handler handler;
	
	public HUD(Handler handler) {
		this.handler = handler;
	}
	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		
		greenValue = HEALTH*2;
		
		score++;
		if(HEALTH <= 0) {
			Game.gameState = STATE.End;
			handler.removeAll();
		}
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect(15, 15, HEALTH*2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		g.drawString("Score: " + score, 10, 64);
		g.drawString("Level: " + level, 10, 80);
	}
	
	public void score(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	
}
