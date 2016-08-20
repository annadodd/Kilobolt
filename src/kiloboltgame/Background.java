package kiloboltgame;

public class Background {
	/*
	 *  We will be doing the following :
	 *  1. Creating variables that we wil be using to manip bg
	 *  2. Defining ctor 
	 *  3. Creating an update() method that lets us move the bg
	 *  4. Adding getters/setters
	 */
	private int bgX, bgY, speedX;
	public Background (int x, int y) {
		bgX = x;
		bgY = y;
		speedX = 0;
	}
	
	public void update() {
		bgX += speedX;
		if (bgX <= -2160) {
			bgX += 4320;
		}
	}
	
}

