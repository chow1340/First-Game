package com.jeffrey.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Player extends GameObject {

	Handler handler;
	Random r = new Random();
	private Bullet bullet;
	public static String shootDirection = "up";

	public Player(int x, int y, ID id, Handler handler, int speed) {
		super(x, y, id, speed);
		this.handler = handler;
		this.speed = speed;
		this.x = x;
		this.y = y;

		bullet();
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	public void tick() {
		x += velX;
		y += velY;

		// Clamp sets so you can't go past the window
		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);

		collision();
		handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.09f, handler, 0));

	}

	private void bullet() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() { // Function runs every MINUTES minutes.
				// Run the code you want here
				handler.addObject(new Bullet(x + 13, y + 13, ID.Bullet, 20, handler, shootDirection));
			}
		}, 0, 100);
	}

	// When player intersects with another object, run function
	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.BasicEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 0.5;
				}

			}
			if (tempObject.getId() == ID.HealthPlus) {
				if (getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH += 10;
					handler.removeObject(tempObject);
				}
			}
			if (tempObject.getId() == ID.SpeedPlus) {
				if (getBounds().intersects(tempObject.getBounds())) {
					speed += 1;
					handler.removeObject(tempObject);
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		if (id == ID.Player)
			g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}

}
