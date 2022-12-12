import java.util.*;

public class Runner {
	
	
	public static void main(String [] agrs) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter the number of Colums for the board ");
		int colums = scan.nextInt();
	
		System.out.print("Please enter the number of Rows for the board ");
		int rows = scan.nextInt();
		
		
		Board b = new Board(colums, rows);
						
		int startx = colums/2;
		int starty = rows/2;
		
		
		//int startx = 21; //start cord of x
		//int starty = 21; //start cord of y
		Snake s = new Snake(startx, starty, b);
		
		Apple a = new Apple(s, b);
		
		b.setSnake(s);
		b.setApple(a);
		
		b.constructBoard();
		
		b.display();
		
		
	}//End of main method
	

}//End of Runner class




