package net.eliasbota.pgl;

public class Point {
	
	private int myX = 0, myY = 0, targetX = 0, targetY = 0;
	
	public Point(int myX, int myY, int targetX, int targetY) {
		this.myX = myX;
		this.myY = myY;
		this.targetX = targetX;
		this.targetY = targetY;
	}

	public int getMyX() {
		return myX;
	}

	public void setMyX(int myX) {
		this.myX = myX;
	}

	public int getMyY() {
		return myY;
	}

	public void setMyY(int myY) {
		this.myY = myY;
	}

	public int getTargetX() {
		return targetX;
	}

	public void setTargetX(int targetX) {
		this.targetX = targetX;
	}

	public int getTargetY() {
		return targetY;
	}

	public void setTargetY(int targetY) {
		this.targetY = targetY;
	}
	
	

}
