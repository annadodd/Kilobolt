package kiloboltgame;

import java.applet.Applet;
import java.awt.Graphics;

public class StartingClass extends Applet implements Runnable {
	// Methods are frameworks for execution provided by the
	// Applet class. In this Applet's life cycle, major events will 
	// call one of these methods and execute it
	
	// Override test for errors upon compilation. We are using it to 
	// annotate that we are overriding methods from a parent calss
	// it informs you when you make mistakes 
	
	// super refers to the super class. 
	@Override
	public void init() {
		// TODO: Auto generated method stub
		super.init();
	}

	@Override
	public void start() {
		// TODO: Auto generated method stub
		//super.start();
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		// TODO: Auto generated method stub
		super.stop();
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// Game loop is in the run method of the class
		while(true) {
			
		}
	}
}
