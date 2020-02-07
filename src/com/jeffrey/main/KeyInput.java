package com.jeffrey.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean heldDown;
    Timer timer;

	
	public KeyInput(Handler handler) {
		this.handler =  handler;
		
	}
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		//Loop through the game objects to see which player is moved
		for(int i =0; i< handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			//If player == ID, run keys
			if (tempObject.id == ID.Player) {
				if (key == KeyEvent.VK_W) tempObject.setVelY(tempObject.speed * -1);
				if (key == KeyEvent.VK_S) tempObject.setVelY(tempObject.speed);
				if (key == KeyEvent.VK_A) tempObject.setVelX(tempObject.speed * -1);
				if (key == KeyEvent.VK_D) tempObject.setVelX(tempObject.speed);	
				
				if(key == KeyEvent.VK_UP) {
					Player.shootDirection = "up";
				}
				if(key == KeyEvent.VK_DOWN) {
					Player.shootDirection = "down";
				}
				if(key == KeyEvent.VK_LEFT) {
					Player.shootDirection = "left";
				}
				if(key == KeyEvent.VK_RIGHT) {
					Player.shootDirection = "right";
				}
				
			}
		}
		
		
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		//Loop through the game objects to see which player is moved
		for(int i =0; i< handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			//If you are going in the direction of the key you are releasing, stop
			//If going in another direction, do not do anything
			if (tempObject.id == ID.Player) {
				if (key == KeyEvent.VK_W) {
					if (tempObject.velY < 0) {
						tempObject.setVelY(0);
					}
				}
				if (key == KeyEvent.VK_S) {
					if (tempObject.velY > 0) {
						tempObject.setVelY(0);
					}
				}
				if (key == KeyEvent.VK_A) {
					if (tempObject.velX < 0) {
						tempObject.setVelX(0);
					}
				}
				if (key == KeyEvent.VK_D) {
					if (tempObject.velX > 0) {
						tempObject.setVelX(0);
					}
				}
			}
		}
		if(key == KeyEvent.VK_UP) {
			heldDown = false;
		}
	}
}
