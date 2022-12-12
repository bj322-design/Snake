import java.util.*;
import java.lang.Thread;

public class Runner {
	
	
	@SuppressWarnings("resource")
	public static void main(String [] agrs) throws InterruptedException {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter the number of Colums for the board ");
		int colums = scan.nextInt();
				
		System.out.print("Please enter the number of Rows for the board ");
		int rows = scan.nextInt();
		
		new MyFrame(); //initiate the popup window to control and monitor key strokes
		
		Board b = new Board(colums, rows);
						
		int startx = colums/2;
		int starty = rows/2;
		
		
		//int startx = 21; //start cord of x
		//int starty = 21; //start cord of y
		Snake s = new Snake(startx, starty, b);
		
		Apple a = new Apple(s, b);
		
		b.setSnake(s);
		b.setApple(a);
		
		
		while (s.validMove()) {
			b.constructBoard();
			
			//String userInput = scan.next().toLowerCase().substring(0, 1);
		
			String userInput = Character.toString(MyFrame.keyReleased1());
			
			if(userInput.equals("w")) {
				s.moveX(-1);
				b.scoreCheck();
				
			}else if(userInput.equals("a")) {
				s.moveY(-1);
				b.scoreCheck();
			
			}else if(userInput.equals("s")) {
				s.moveX(1);
				b.scoreCheck();
				
			}else if(userInput.equals("d")) {
				s.moveY(1);
				b.scoreCheck();
			
			}else if(userInput.equals(" ")) {
				System.out.println("----------THE GAME IS NOW PAUSED----------");
			}
			
		
			b.display();
			Thread.sleep(500); // will stop the program for x time in miliseconds (good one is 500)
		}
		
		//System.out.println("Your Score was: " + a.getScore()); //it would be redundent if it said it again

		
	}//End of main method
	
	
}//End of Runner class




