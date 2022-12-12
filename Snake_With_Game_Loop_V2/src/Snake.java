public class Snake {

	//fields
	private int xCord;
	private int yCord;
	private Board b;
	
	/**
	 * Contructor for Snake
	 * @param xC
	 * @param yC
	 */
	public Snake(int xC, int yC, Board bo) {
		xCord = xC;
		yCord = yC;
		b = bo;
	}
	
	public void moveX(int m) {
		if(validMove()) {
			xCord += m; 
		}
	}
	
	public void movey(int m) {
		if(validMove()) {
			yCord += m;
		}
	}
	
	public boolean validMove() {
		if(b.validMove(xCord, yCord)) {
			return true;
		}
		
		return false;
	}
	
	
	public int getXCord() {
		return xCord;
	}
	
	public int getYCord() {
		return yCord;
	}
	
}
