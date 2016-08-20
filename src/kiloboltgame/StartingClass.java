package kiloboltgame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

import com.kilobolt.robotgame.Settings;

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
		// Kind of like how a normal function runs the
		// main (String args[]) method

		// TODO: Auto generated method stub
		super.init();

		// Define certain params for the applet including:

		// Size of applet
		setSize(800, 480); // most common Android resolution

		// Background color
		setBackground(Color.BLACK);
		// Makes sure that when the game starts, the applet takes focus
		// and our input goes directly into it
		// If not enabled, you would have to click inside the applet
		// before it starts handling keyboard events
		setFocusable(true);

		// Applet title
		// Assigns the applet window to the frame variable
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Q-Bot Alpha");
		

	}

	@Override
	public void start() {
		// TODO: Auto generated method stub
		// super.start();
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
		while (true) {
			//
			/*
			 * Built in method. This calls the paint method (in which we draw
			 * objects onto the screen). We haven't created paint method yet but
			 * every 17 milliseconds, the paint method will be called
			 */
			repaint();
			try {
				// 1000 milliseconds (1 second) / 60 frames per second
				// = 17 milliseconds per frame. Hence 17
				// In a try block because this may fail
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
