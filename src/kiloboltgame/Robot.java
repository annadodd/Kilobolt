package kiloboltgame;

public class Robot {
	/*
	 * Adding our main character. We will do the following within the
	 * class:
	 * Manage x,y coodinates and speed
	 * Make updates to speed and position
	 * Allow other classes to retrieve its x, y related variables
	 * 
	 * Methods will be divided into these categories:
	 * 1. Constantly updated methods that are called on each iteration 
	 * of the game loop
	 * 2. Methods that are only called upon player input
	 * 3. Helper methods that retrieve and change the value of variables
	 * in the class
	 * 
	 * 
	 */
	// x,y coordinates of robot character's center
	private int centerX = 100;
	private int centerY = 382;
	
	// Changes to true if character is in air, reverts to false when grounded
	private boolean jumped = false;
	
	// Rate at which x and y positions change
	private int speedX = 0;
	private int speedY = 1;
	
	public void update() {
		// Will be called on each iteration of the for loop
		
		// Moves character or scrolls background accordingly
		if (speedX < 0) {
			// Move center coordinate back--no scroll needed
			centerX += speedX;
		} else if (speedX == 0) {
			System.out.println("Do not scroll the background.");
		} else {
			if (centerX <= 150) {
				// Move center coordinate forward--no scroll needed
				
				centerX += speedX;
			} else {
				System.out.println("Scroll background here");
			}
		}
		
		// Updates Y position
		if (centerY + speedY >= 382) {
			// Where character's center Y would b if standing on ground
			centerY = 382;
		} else {
			// Determines new position
			centerY += speedY;
		}
		
		// Handles jumping
		if (jumped == true) {
			// While being in the air, add 1 to speedY to bring
			// character downwards
			speedY += 1;
			// Don't let center go out of screen bounds
			if (centerY + speedY >= 382)
			{
				centerY = 382;
				speedY = 0;
				jumped = false;
			}
		}
		
		// Prevents going beyond X coordinate of 0
		// how...
		if (centerX + speedX <= 60) {
			centerX = 61;
		}
	}
	
	public void moveRight() {
		speedX = 6;
	}
	
	public void moveLeft() {
		speedX = -6;
	}
	
	public void stop() {
		speedX = 0;
	}
	
	public void jump() {
		if (jumped == false) {
			// grounded; bring up in air and set jumped
			speedY = -15;
			jumped = true;
		}
	}
	public int getCenterX() {
		return centerX;
	}
	
	public int getCenterY() {
		return centerY;
	}

	public boolean isJumped() {
		return jumped;
	}

	public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}
	

}
