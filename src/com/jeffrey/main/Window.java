package com.jeffrey.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6909134033524130309L;
	
	public Window(int width, int height, String title, Game game) {
//		JFrame is an inbuilt library for java that gives us a frame for our window
		
		JFrame frame = new  JFrame(title);
		
		frame.setPreferredSize(new Dimension (width, height));
		frame.setMaximumSize(new Dimension (width, height));
		frame.setMinimumSize(new Dimension (width, height));
		
		//Makes an X button for JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	
}
