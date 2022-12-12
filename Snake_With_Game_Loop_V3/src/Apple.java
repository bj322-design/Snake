public class Apple {

	//fields
	private Snake snakyboi;
	private Board boardyboi;
	private int appleXCord;
	private int appleYCord;
	private int score;
	
	/**
	 * Default constructor will put the apple in a random spot on the board
	 */
	public Apple(Snake s, Board b) {
		snakyboi = s;
		boardyboi = b;
		moveApple();
		score = 0;
	}
	
	public Apple(Snake s, Board b, int aX, int aY) {
		snakyboi = s;
		boardyboi = b;
		appleXCord = aX;
		appleYCord = aY;
		score = 0;
	}
	
	
	public void moveApple() {
		//boardyboi.clearSpace(appleXCord, appleYCord);
		
		setXCord((int) (Math.random()* (boardyboi.getColums() -2)) + 1);
		setYCord((int) (Math.random()* (boardyboi.getRows() - 2)) + 1); 
		
System.out.println("Apple X: " + appleXCord);
System.out.println("Apple Y: " + appleYCord);

		while(appleXCord == snakyboi.getXCord() || appleXCord == 0) {
			appleXCord = (int) Math.random()*((boardyboi.getColums()) + 1) + 1;
		}
		
		while(appleYCord == snakyboi.getYCord() || appleYCord == 0) {
			appleYCord = (int) Math.random()*((boardyboi.getRows()) + 1) + 1; 
		}
		
	}
	
	public int getAppleXCord() {
		return appleXCord;
	}
	
	public int getAppleYCord() {
		return appleYCord;
	}
	
	public void setXCord(int x) {
		appleXCord = x;
	}
	
	public void setYCord(int y) {
		appleYCord = y;
	}
	
	public int getScore() {
		return score;
	}
	
	public void increaseScore() {
		score ++;
		moveApple();
		
	}
	
}
