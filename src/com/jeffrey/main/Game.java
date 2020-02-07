package com.jeffrey.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -9169052948511319523L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12*9;
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private Random r;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	
	public enum STATE {
		Menu,
		Game,
		End,
	}
	
	public static STATE gameState = STATE.Menu;
	
	public Game() {
		handler = new Handler();
		menu = new Menu(this, handler);

		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);

		new Window(WIDTH, HEIGHT, "Jeffrey's Game", this);
		
		r = new Random();
		
		hud = new HUD(handler);
		spawner = new Spawn(handler, hud);	
	
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void  run() {
		this.requestFocus();
//		Game Loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long  now = System.nanoTime();
			delta +=  (now-lastTime)/ns;
			lastTime = now;
			while(delta >=1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
//				System.out.println("FPS: "+frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		if(gameState == STATE.Game) {
			hud.tick();
			spawner.tick();
		} else if (gameState == STATE.Menu || gameState == STATE.End) {
			menu.tick();
		}
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		

		if(gameState == STATE.Game) {
			handler.render(g);
			hud.render(g);
		} else if (gameState == STATE.Menu || gameState == STATE.End) {
			menu.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max) {
		if(var >= max) 
			return var = max;
		else if (var <= min)	
			return min;
		else 
			return var;
	}
	
	public static void main(String args[]){
		new Game();
	}
}
