package com.jeffrey.main;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	private int spawnRate = 0;
	private float spawnSpeed = 1;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		spawnRate += spawnSpeed;
		if(spawnRate >= 200) {
			spawnRate  = 0;
			Game.clamp(spawnRate, 1, 3);
			hud.setLevel(hud.getLevel()+1);
			if(BasicEnemy.BasicEnemyCount <= 5) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-64), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, handler, 5, 100));
				BasicEnemy.BasicEnemyCount += 1;
			}
		
			if(hud.getLevel() % 3 == 0) {
				if(FastEnemy.FastEnemyCount <= 2) {
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-64), r.nextInt(Game.HEIGHT-64),ID.FastEnemy, handler, 8, 100));
					FastEnemy.FastEnemyCount += 1;
				}
				spawnSpeed += 0.5;
			}
			
			if(hud.getLevel() % 5 == 0) {
				handler.addObject(new HealthPlus(r.nextInt(Game.WIDTH-34), r.nextInt(Game.HEIGHT - 34), ID.HealthPlus, 0));
			}
			
			if(hud.getLevel() % 10 == 0) {
				handler.addObject(new SpeedPlus(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.SpeedPlus, 0));
			}
		}		
	}
}
