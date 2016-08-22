package kiloboltgame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;


public class StartingClass extends Applet implements Runnable, KeyListener {
	// Methods are frameworks for execution provided by the
	// Applet class. In this Applet's life cycle, major events will
	// call one of these methods and execute it

	// Override test for errors upon compilation. We are using it to
	// annotate that we are overriding methods from a parent calss
	// it informs you when you make mistakes

	// super refers to the super class.
	
	private Robot robot;
	private Image image, character;
	private Graphics second; 
	private URL base;
	/*
	 *  We make them static so we can create getters and
	 *  setters for them to be used in other classes for movement 
	 */
	private static Background bg1, bg2;
	
	@Override
	public void init() {
		// Kind of like how a normal function runs the
		// main (String args[]) method

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
		addKeyListener(this);

		// Applet title
		// Assigns the applet window to the frame variable
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Q-Bot Alpha");
		try {
			base = getDocumentBase();
		} catch (Exception e) {
			// TODO; handle exception
		}
		
		// Image setups
		character = getImage(base, "data/character.png");
	}

	@Override
	public void start() {
		robot = new Robot();
		
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
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
			robot.update();
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
	@Override
	public void update(Graphics g) {
		/*
		 *  Used for double buffering
		 *  Prevents tearing and flickering
		 *  Retains the previous position of the screen's current image
		 *  for a short amount of time so the movement of the image
		 *  looks smooth and natural 
		 *  
		 */
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			// Called for off screen images; creates a Graphics context
			second = image.getGraphics();
		}
		// Basically saves current graphics context of image into second
		second.setColor(getBackground());
		// Fill second image rectangle from 0, 0 to getWidth, getHeight
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);
		
		// Draws as much of the class image that is currently
		// available to the g's Graphics context
		g.drawImage(image, 0, 0, this);
	}
	
	@Override
	public void paint(Graphics g) {
		// image variable, x, y, observer 
		// Top left corner of robot is 61 pixels to left and 63 above center
		g.drawImage(character, robot.getCenterX() - 61, robot.getCenterY() - 63, this);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Upon press of the button
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			System.out.println("Move up");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("Move down");
			break;
		case KeyEvent.VK_LEFT:
			robot.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			robot.moveRight();
			break;
		case KeyEvent.VK_SPACE:
			robot.jump();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Upon release of the button
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			System.out.println("Stop move up");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("Stop move down");
			break;
		case KeyEvent.VK_LEFT:
			robot.stop();
			break;
		case KeyEvent.VK_RIGHT:
			robot.stop();
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("Stop jump");
			break;
		}
	}
	
}
