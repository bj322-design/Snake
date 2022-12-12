import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.ArrayList;

public class Snake {

	public static void main(String agrs[]) {
		Scanner scan = new Scanner(System.in); 
		
		//for the time to compare to later for the clock system.
		LocalTime time1 = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss");
		/*This was a test part of the time code
		 * System.out.println(time1.format(formatter)); //this is the test to see if it prints
		 */
		
		boolean start_New_Game = true; //the While statement that will run the program effectively
		String input; // the input that the user will give to move the snake everytime
		
		int[][] board = new int[20][20]; //form the 2d array that will store and print the board 
		int startx = 10;
		int starty = 10; 
		int score = 0;
		
		int apple_start_x = 3;
		int apple_start_y = 3; 
		int apple_ran_x = apple_start_x;
		int apple_ran_y = apple_start_y; 
		
		ArrayList<Integer> memory_x = new ArrayList<>(); //this is the memory for the snake cord x
		ArrayList<Integer> memory_y = new ArrayList<>(); //this is the memory for the snake cord y
		
		String inputMemory = "w"; 
		
		String timeStr1 = time1.format(formatter);//need to convert to string then int
		int timeInt1 = Integer.parseInt(timeStr1);
		
		for(int x = 0; x < 20; x ++) {  //this will put a 1 where the outside of the board is
			for(int y = 0; y < 20; y++) {
				if(x == 0 || x == 19) {
					board[x][y] = 1;
				}
				if(y == 0 || y == 19) {
					board[x][y] = 1;
				}
			}
		}
		


		board [apple_start_x][apple_start_y] = 3;//the start point of the apple on the board
		
		while(start_New_Game) {
			board [startx][starty] = 2;	//will put the start point of the player
			
			
			//supposed to leave a track of the player if the score is greater than 0
			int memSize_x = memory_x.size()-1;
			int memSize_y = memory_y.size()-1;
			
			if(score != 0) {	
				System.out.println("memx before: " + memory_x);
				memory_x.add(startx);
					
				if(memSize_x > 0 /*&& score == memSize_x*/) {
					memory_x.remove(0);
					System.out.println("memx after: " + memory_x);
				}
				
				
				System.out.println("memy before: " + memory_y);
				memory_y.add(starty);
				
				if(memSize_y > 0 /*&& score == memSize_y*/) {
					memory_y.remove(0);
					System.out.println("memy before: " + memory_y);
				}
							
			}
			
			//this will help form the trail by making all in the trail equal to 2 for the print out next
			for(int mx: memory_x) {
				for(int my: memory_y) {
					board[mx][my] = 2; 
				}
			}
			
			//This will print out the board every time the while loop runs
			for(int i = 0; i < 20; i++) {
				for(int j = 0; j < 20; j++) {						
					//board outline is made of the *'s
					if(board[i][j] == 1) {
						System.out.print("* ");
						
					//if it is 2 it will print out the sprite for the user aka #
					}else if(board[i][j] == 2) {
						System.out.print("# ");
					
					//if it is 3 it will print out the sprite for the apple aka @
					}else if(board [i][j] == 3){
						System.out.print("@ ");
						
					//if it is nothing than it will print out nothing or a space in the board
					}else{
						System.out.print("  ");
					} 
				}
				System.out.print("\n");
			}
		
			//now its the logic of the game itself 
			
			LocalTime time2 = LocalTime.now(); //will make a new time object to compare to to update ever time.
			String timeStr2 = time2.format(formatter);//need to convert to string then int
			int timeInt2 = Integer.parseInt(timeStr2);
			
			
			
			/*test sections 
			*System.out.println(time1.format(formatter).compareTo(time2.format(formatter)));
			*System.out.println(time2.format(formatter)); 
			*/
			if(timeInt1 != timeInt2) {
				input = inputMemory;
			}else {
				input = scan.next(); //taking the user input be it (W, A, S, D)
			}
			
			//converts it to lower case to compare it to other things
			input = input.toLowerCase(); 
			
			end(input); //if the user types in end it will end the program

			input = input.substring(0,1); 
			
			
			//if input is = to nothing after a second than it will make input = to the last input
			
			if(input.equals("w")) {
				board[startx][starty] = 0;
				inputMemory = "w"; 
				
			
				System.out.println(memory_x);
				System.out.println(memory_y);
				
				while(score > memory_x.size() || score > memory_y.size()) {
					System.out.println(memory_x); 
					memory_x.add(startx);
					
					System.out.println(memory_x);
					
					
					System.out.println(memory_y); 
					memory_y.add(starty);
					System.out.println(memory_y);
				}
				
					
				if(startx != 1) {
					startx --;
				}else {
					System.out.println("\tYOU DIED D:\n\tYOUR SCORE WAS " + score);
					break; 
				}
			
			}else if(input.equals("s")){
				board[startx][starty] = 0;
				inputMemory = "s"; 
				
				if(startx != 18) {
					startx ++;
				}else {
					System.out.println("\tYOU DIED D:\n\tYOUR SCORE WAS " + score);
					break; 
				}
			
			}else if(input.equals("a")) {
				board[startx][starty] = 0;
				inputMemory = "a"; 
				
				if(starty != 1) {
					starty --;
				}else {
					System.out.println("\tYOU DIED D:\n\tYOUR SCORE WAS " + score);
					break; 
				}
				
			}else if(input.equals("d")) {
				board[startx][starty] = 0;
				inputMemory = "d"; 
				
				if(starty != 18) {
					starty ++;
				}else {
					System.out.println("\tYOU DIED D:\n\tYOUR SCORE WAS " + score);
					break; 
				}
				
			}else if(input.equals("end")){
				start_New_Game = false; 
			}
			
			
			//this will prevent the trail from going on till infinity
			for(int mx: memory_x) {
				for(int my: memory_y) {
					board[mx][my] = 0; 
				}
			}
			
			//The apple random movement if hit also the apple relocates and adds one point to score
			if(startx == apple_ran_x && starty == apple_ran_y) {
				score++; 
				apple_ran_x = (int)((Math.random() * (18 - 1) + 1));
				apple_ran_y = (int)((Math.random() * (18 - 1) + 1));
				board[apple_ran_x][apple_ran_y] = 3;
			}
			
			
			
			System.out.println("Your current score is: " + score);
			//start_New_Game = false; //test varible to bypass everything and just make sure the board is working
			
			//this will update the time1 varible so it can be used to compare to time2 next time it runs
			time1 = LocalTime.now();
			timeStr1 = time1.format(formatter);//need to convert to string then int
			timeInt1 = Integer.parseInt(timeStr1);
			System.out.println("\n\n\t\tThe time1 is: " + timeInt1);
		}//end of while loop
		
		
	}//end of main method
	
	public static void end(String input) {
		if(input.equals("end")){
			System.exit(0);	
		}
	}
}