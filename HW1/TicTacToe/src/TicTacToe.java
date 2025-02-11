import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner; 

/**
 * 
 */

/**
 * @author chrisr98
 * Date: 02/05/2020
 *
 */
public class TicTacToe {

	/**
	 * Initialize board state and values
	 */
	
//	private List<positionTTT> board = new ArrayList<>();
	private CreateBoard board = new CreateBoard();
	private List<List<positionTTT>>  allWinningLines = new ArrayList<>();
	private int boardSize = 3;
	private TokenID player = new TokenID(2);
	private boolean OaOWinCon = false;
	
	
	public TicTacToe() {
		// TODO Auto-generated constructor stub
		// Creates the board and initialize all possible winning lines
		
		//If TicTacToe

		board.createTicTacToeBoard(boardSize); 		//set board to TTTBoard
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
		for(int i=0;i<winningLines.size();i++){

			positionTTT p0 = winningLines.get(i).get(0);
			positionTTT p1 = winningLines.get(i).get(1);
			positionTTT p2 = winningLines.get(i).get(2);

			int state0 = board.getStateOfPositionFromBoard(p0, size);
			int state1 = board.getStateOfPositionFromBoard(p1, size);
			int state2 = board.getStateOfPositionFromBoard(p2, size);

			//if they have the same state (marked by same player) and they are not all marked.
			if(state0 == state1 && state1 == state2 && state0 != 0){
				//Game is over with a winning player/ 1 or 2
				return state0;
			}
		}
		for(int i=0;i<board.boardTicTacToe.size();i++){
			if(board.boardTicTacToe.get(i).state==0){
				//game is not ended, continue
				return 0;
			}
		}
		return -1; //call it a draw
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
	
    //Run the game
	public int run()
	{
		//Sets up the info at the beginning
		System.out.println("Welcome to Tic-Tac-Toe!");
		System.out.println("Player 1 is \'X\' and Player 2 is \'O\'.");
		System.out.println("Inputs should be entered in \'0 1\' format, with a space in between the numbers.");
		
		//Ask who would like to go first
		System.out.println("Who would like to go first? Player 1 or Player 2?");
		System.out.println("Enter 1 or 2");
		
		
		System.out.println();
		int turn = player.getPlayer(1);
		
		
		Scanner scan = new Scanner(System.in);

		//If user does not input Int, it stops everything
		try 
		{
			//Initialize who goes first based on user input
			int answer = scan.nextInt();
			boolean valid = false;

			while (!valid) {

				if(answer == 1)
				{
					System.out.println("Player 1 goes first \n");
					turn = player.getPlayer(1);
					valid = true;
					break;
				} else if (answer == 2)
				{
					System.out.println("Player 2 goes first \n");
					turn = player.getPlayer(2);
					valid = true;
					break;
				} else
				{
					System.out.println("Invalid input, go again: ");
					answer = scan.nextInt();					
				}
			}

		} catch (InputMismatchException e) {
			// TODO: handle exception
			return -100;
		}
		
		while (isEnded(board, boardSize) == 0) 
		{
			board.printBoardTicTacToe(boardSize);
			
					
			
			if (turn == 1) 
			{
				//Only accepts int not letters, will force user to go again otherwise
				try
				{
					System.out.println("Player X enter your move:");
					int i = scan.nextInt();
					int j = scan.nextInt();
					System.out.println("You entered: (" + i + "," + j + ")");
					positionTTT player1Move = new positionTTT(i, j, 1);
					playerMoves(player1Move, board.boardTicTacToe);
					turn = player.getPlayer(2);
				} catch (InputMismatchException e) 
				{
					System.out.println("Cannot enter letters, go again: ");
					turn = player.getPlayer(1);
				}		
				
			} else if (turn == 2) 
			{	
				//Only accepts int not letters, will force user to go again otherwise
				try
				{
					System.out.println("Player O enter your move:");
					int i = scan.nextInt();
					int j = scan.nextInt();
					System.out.println("You entered: (" + i + "," + j + ")");
					positionTTT player2Move = new positionTTT(i, j, 2);
					playerMoves(player2Move, board.boardTicTacToe);
					turn = player.getPlayer(1);
				} catch (InputMismatchException e) 
				{
					System.out.println("Cannot enter letters, go again: ");
					turn = player.getPlayer(2);
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
		} else if(isEnded(board, boardSize) == 2)
		{
			board.printBoardTicTacToe(boardSize);
			System.out.println("The winner is Player 2!");
			return 2;
		} else
		{
			board.printBoardTicTacToe(boardSize);
			System.out.println("Stalemate!! There is no winner");
			return 0;
		}
		
	}
	

}
