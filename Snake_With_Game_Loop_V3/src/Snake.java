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
			b.clearSpace(xCord, yCord);
			xCord += m; 
			b.moveTail(xCord, yCord);
		}
	}
	
	public void moveY(int m) {
		if(validMove()) {
			b.clearSpace(xCord, yCord);
			yCord += m;
			b.moveTail(xCord, yCord);
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
