package com.jeffrey.main;

import java.awt.Graphics;
import java.util.LinkedList;

//Maintain, update or renders all of our objects
public class Handler {
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		//Gets the objects from the list
		for(int i=0; i<object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		//loops through and renders the game object
		for (int i=0; i<object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public void removeAll() {
		for (int i = 0; i<object.size(); i++) {
			object.remove(i);
			System.out.println(object.size());
		}
	}
}
