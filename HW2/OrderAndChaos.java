import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author chrisr98
 *
 */
public class OrderAndChaos 
{

	private CreateBoard board = new CreateBoard();
	private List<List<positionTTT>>  allWinningLines = new ArrayList<>();
	private int boardSize = 6;
	private TokenID players = new TokenID(2);
	private int player1 = players.getPlayer(1);
	private int player2 = players.getPlayer(2);
	private boolean OaOWinCon = true;
	
	
	public OrderAndChaos() {
		// TODO Auto-generated constructor stub
		// Creates the board and initialize all possible winning lines
		
		
		//If Order And Chaos
		
		board.createTicTacToeBoard(boardSize); //Set board to OaOBoard


		allWinningLines = board.initializeWinningLines(boardSize, OaOWinCon);
				
	}
	
	private void printAllWinningLines()
	{
		//print all winning lines to help understand in what cases will any player win
		System.out.println(allWinningLines.size());
		for (int i=0;i<allWinningLines.size();i++)
		{
			System.out.println("Winning Line "+i+":");
			for (int j=0;j<allWinningLines.get(i).size();j++)
			{
				allWinningLines.get(i).get(j).printPositionTTT();
			}
		}
	}
	
	
	 //Checks to see if game is over and the win condition
    private int isEnded(CreateBoard board, int size){
		List<List<positionTTT>> winningLines = allWinningLines;
//		int maxBoardSize = board.boardTicTacToe.size(); 
				
				
		for(int i=0;i<winningLines.size();i++){
			

			positionTTT p0 = winningLines.get(i).get(0);
			positionTTT p1 = winningLines.get(i).get(1);
			positionTTT p2 = winningLines.get(i).get(2);
			positionTTT p3 = winningLines.get(i).get(3);
			positionTTT p4 = winningLines.get(i).get(4);
			
			

			int state0 = board.getStateOfPositionFromBoard(p0, size);
			int state1 = board.getStateOfPositionFromBoard(p1, size);
			int state2 = board.getStateOfPositionFromBoard(p2, size);
			int state3 = board.getStateOfPositionFromBoard(p3, size);
			int state4 = board.getStateOfPositionFromBoard(p4, size);
			
			int astate0 = state0;
			int astate1 = state1;
			int astate2 = state2;
			int astate3 = state3;
			int astate4 = state4;
			
			
			//Figure out how to handle the other 2 diagonal winning condition (The non centered ones)
			if(winningLines.get(i).size() == 6)
			{
				positionTTT a0 = winningLines.get(i).get(1);
				positionTTT a1 = winningLines.get(i).get(2);
				positionTTT a2 = winningLines.get(i).get(3);
				positionTTT a3 = winningLines.get(i).get(4);
				positionTTT a4 = winningLines.get(i).get(5);
				
				astate0 = board.getStateOfPositionFromBoard(a0, size);
				astate1 = board.getStateOfPositionFromBoard(a1, size);
				astate2 = board.getStateOfPositionFromBoard(a2, size);
				astate3 = board.getStateOfPositionFromBoard(a3, size);
				astate4 = board.getStateOfPositionFromBoard(a4, size);
				
			}
			
			

			//if they have the same state (marked by same player) and they are not all marked.
			if(state0 == state1 && state1 == state2 && state2 == state3 && state3 == state4 && state0 != 0 ||
					astate0 == astate1 && astate1 == astate2 && astate2 == astate3 && astate3 == astate4 && astate0 != 0){
				//Game is over with a winning player/ 1 or 2
				return 1;
			}
		}
		for(int i=0;i<board.boardTicTacToe.size();i++){
			if(board.boardTicTacToe.get(i).state==0){
				//game is not ended, continue
				return 0;
			}
		}
		return 2; //Player 2 wins if player 1 cannot win
	}
    
    // checks to see if player move is valid and updates board if it is
    private boolean playerMoves(positionTTT move, List<positionTTT> board)
    {
    	for (int i = 0; i < board.size(); i++) 
    	{
    		int x = board.get(i).x;
    		int y = board.get(i).y;
			if (x == move.x && y == move.y)
			{
				if(board.get(i).state == 0)
				{
					board.get(i).state = move.state;
					return true;
				} else
				{
					System.out.println("Invalid move!");
					System.out.println("Please enter your move again:");
					validate(move.state, board);
					return true;
				}
			} else if (move.x > board.size() || move.y > board.size() || move.x < 0 || move.y < 0) //Check if move is within bounding of board
			{
				System.out.println("Invalid move!");
				System.out.println("Please enter your move again:");
				validate(move.state, board);
				return true;
			}
		}
		return false;
    }
    
    // Helper function to help validate player move if they keep inputing wrong thing
    private positionTTT validate(int player, List<positionTTT> board)
    { 
    	Scanner scan = new Scanner(System.in);
    	int totalNumberCell = board.size() * board.size();
    	int i = scan.nextInt();
		int j = scan.nextInt();
		positionTTT temp = new positionTTT(i, j, player);
		boolean valid = false;
		int count = 0;
		//As long as input isn't valid
    	while (!valid)
		{
    		//Get new input
    		int x = board.get(count).x;
    		int y = board.get(count).y;
    		//Check if spot is empty
			if (x == temp.x && y == temp.y && board.get(count).state == 0)
			{
				System.out.println("You entered: (" + i + "," + j + ")");
				valid = true;
				board.get(count).state = temp.state;
				break;
			} else if(count < totalNumberCell)
			{
				count++;
				continue;
			} else
			{
				System.out.println("Invalid move!");
				System.out.println("Please enter your move again:");
				i = scan.nextInt();
				j = scan.nextInt();
			}
			
		} 
    	return temp;
    	
    }
    
    
    
	public int run()
	{
		printAllWinningLines();
		
		//Sets up the info at the beginning
				System.out.println("Welcome to Order and Chaos!");
				System.out.println("Player 1 is Order and Player 2 is Chaos.");
				System.out.println("Inputs should be entered in \'0 1\' format, with a space in between the numbers.");
				

				System.out.println();
				int turn = player1;
				int token;
				
				
				Scanner scan = new Scanner(System.in);

				
				while (isEnded(board, boardSize) == 0) 
				{
					board.printBoardTicTacToe(boardSize);
					
					if(turn == 1)
					{
						System.out.println("Order it is your turn");
					} else
					{
						System.out.println("Chaos it is your turn");
					}
					
					//If user does not input Int, it stops everything
					try 
					{
						//Initialize who goes first based on user input
						//Ask what token to use
						System.out.println("Which token would you like to place? 'X'(1) or 'O'(2)?");
						System.out.println("Enter 1 or 2");
						
						
						token = scan.nextInt();
						boolean valid = false;

						while (!valid) {

							if(token == 1)
							{
								System.out.println("You have chosen 'X' \n");
								valid = true;
								break;
							} else if (token == 2)
							{
								System.out.println("You have chosen 'O' \n");
								valid = true;
								break;
							} else
							{
								System.out.println("Invalid input, go again: ");
								token = scan.nextInt();					
							}
						}

					} catch (InputMismatchException e) {
						// TODO: handle exception
						return -100;
					}
	
					
					if (turn == 1) 
					{
						//Only accepts int not letters, will force user to go again otherwise
						try
						{
							System.out.println("Order enter your move:");
							int i = scan.nextInt();
							int j = scan.nextInt();
							System.out.println("You entered: (" + i + "," + j + ")");
							positionTTT player1Move = new positionTTT(i, j, token);
							playerMoves(player1Move, board.boardTicTacToe);
							turn = player2;
						} catch (InputMismatchException e) 
						{
							System.out.println("Cannot enter letters, go again: ");
							turn = player1;
						}		
						
					} else if (turn == 2) 
					{	
						//Only accepts int not letters, will force user to go again otherwise
						try
						{
							System.out.println("Chaos enter your move:");
							int i = scan.nextInt();
							int j = scan.nextInt();
							System.out.println("You entered: (" + i + "," + j + ")");
							positionTTT player2Move = new positionTTT(i, j, token);
							playerMoves(player2Move, board.boardTicTacToe);
							turn = player1;
						} catch (InputMismatchException e) 
						{
							System.out.println("Cannot enter letters, go again: ");
							turn = player2;
						}
						
						
					} else {
						System.out.println("Error");
						return -100;
					}
					scan.nextLine(); // clears the buffer
				}
				
				if (isEnded(board, boardSize) == 1)
				{
					board.printBoardTicTacToe(boardSize);
					System.out.println("The winner is Player 1!");
					return 1;
				} else if(isEnded(board, 3) == 2)
				{
					board.printBoardTicTacToe(boardSize);
					System.out.println("The winner is Player 2!");
					return 2;
				} else
				{
					board.printBoardTicTacToe(boardSize);
					System.out.println("The winner is Player 2!");
					return 2;
				}
				
	}
	
	
}
