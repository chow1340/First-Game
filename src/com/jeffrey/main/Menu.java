package com.jeffrey.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.jeffrey.main.Game.STATE;

public class Menu extends MouseAdapter{
	
	Game game;
	Handler handler;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed (MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameState == STATE.Menu) {
			if(mouseOver(mx, my, 210, 150, 200, 64)) {
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler, 5));
				
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-32), r.nextInt(Game.HEIGHT-32), ID.BasicEnemy, handler, 5, 100));
				BasicEnemy.BasicEnemyCount += 1; 
			}
			
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				System.exit(1);
			}
		}
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	//Check if mouse is in the square
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if( my > y && my <  y  + height) {
				return true;
			} else return false;
		} else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if (Game.gameState == STATE.Menu) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1,  30);
			
			
			g.setFont(fnt);
			g.setColor(Color.white);;
			g.drawString("Menu", 240,  50);
			
			g.setFont(fnt);
			g.drawString("Play", 260,  195);
			g.drawRect(210, 150, 200, 64);
			
			g.drawString("Quit", 260,  395);
			g.drawRect(210, 350, 200, 64);
		}
		
		if (Game.gameState == STATE.End) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1,  30);
			String score = Integer.toString(HUD.score);

			g.setFont(fnt2);
			g.setColor(Color.white);
			
			
			g.drawString("Score: " + score, 240, 50);
			
			g.drawString("Play Again", 240,  195);
			g.drawRect(210, 150, 200, 64);
			
			g.drawString("Quit", 260,  395);
			g.drawRect(210, 350, 200, 64);
			
			
		}

	}
}
