public class Board {
	
	private int colums;
	private int rows;
	private int[][] board;
	private Snake s;
	private Apple a;
	
	public Board(int c, int r) {
		colums = c + 1;
		rows = r + 1;
		System.out.println(colums);
		System.out.println(rows);
		
		//forms the basis for a board array
		board = new int[colums][rows];
	}
	
	public void setSnake(Snake snakyboi) {
		s = snakyboi;
	}
	
	public void setApple(Apple app) {
		a = app;
	}
	
	public void constructBoard() {		
		
		for(int x = 0; x < board.length; x ++) {
			for(int y = 0; y < board[x].length; y ++) {
				if(x == s.getXCord() && y == s.getYCord()) {
					board[x][y] = 1; //1 = snake
				
				}else if(x == a.getAppleXCord() && y == a.getAppleYCord()) {
					board[x][y] = 2; //2 == apple local
					
				}else if(x == 0 || x == colums-1) {
					board[x][y] = 3;//0 = outline
					
				}else if(y == 0 || y == rows -1) {
					board[x][y] = 3;//0 = outline
				}
			}
		}
	}
	
	public boolean validMove(int xCord, int yCord) {
		if(xCord > 0 && xCord < rows) {
			if(yCord > 0 && yCord < colums) {
				return true;
			}
		}
		
		return false;
	}
	
	public int getColums() {
		return colums;
	}
	
	public int getRows() {
		return rows;
	}
	
	
	public void display() {
		for(int x = 0; x < board.length; x ++) {
			
			for(int y = 0; y < board[x].length; y ++) {
				if(board[x][y] == 3) {
					System.out.print("* "); //board outline

				}else if(board[x][y] == 1) {
					System.out.print("# "); //snake
					
				}else if(board[x][y] == 2) {
					System.out.print("@ "); //apple
				
				}else {
					System.out.print("  ");
				}
			}
			
			System.out.print("\n");
		}
		
		
		
	}
	
	public void clearSpace(int x, int y) {
		board[x][y] = 0;
	}
	
	public void moveTail(int x, int y) {
		try {
			board[x][y] = 1;
		}
		catch(ArrayIndexOutOfBoundsException a) {
			System.out.println("----------YOU HAVE DIED----------");
		}
		
	}
	
	public void scoreCheck() {
		if(s.getXCord() == a.getAppleXCord()) {
			if(s.getYCord() == a.getAppleYCord()) {
				a.increaseScore();
			}
		}
		System.out.println("Score: " + a.getScore());
	}
	
	
	
}
