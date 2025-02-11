import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */

/**
 * @author chrisr98
 *
 */
public class CreateBoard 
{
	List<positionTTT> boardTicTacToe = new ArrayList<positionTTT>();
	
	public List<positionTTT> createTicTacToeBoard(int size)
	{
		//create a TicTacToe board and store it in a list
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				boardTicTacToe.add(new positionTTT(i, j));
			}
		}
		
		return boardTicTacToe;
	}

	
	public List<List<positionTTT>> initializeWinningLines(int boardSize, boolean OaO)
	{
		//create a list of winning line so that the game will "brute-force" check 
		//if a player satisfied any winning condition(s).
		List<List<positionTTT>> winningLines = new ArrayList<List<positionTTT>>();
				
		//Win on x-axis
		List<positionTTT> oneWinCondtion = new ArrayList<positionTTT>();
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				oneWinCondtion.add(new positionTTT(i, j, 1));
			}
			winningLines.add(oneWinCondtion);
			oneWinCondtion = new ArrayList<positionTTT>();
		}
		

		// Win on y-axis
		oneWinCondtion = new ArrayList<positionTTT>();
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				oneWinCondtion.add(new positionTTT(j, i, 1));
			}
			winningLines.add(oneWinCondtion);
			oneWinCondtion = new ArrayList<positionTTT>();
		}
		
		
		// Win diagonally
		oneWinCondtion = new ArrayList<positionTTT>();
		for (int i = 0; i < boardSize; i++) {
			oneWinCondtion.add(new positionTTT(i, i, 1));
		}
		winningLines.add(oneWinCondtion);
		
		
		oneWinCondtion = new ArrayList<positionTTT>();
		for (int i = 0, j = boardSize - 1; i < boardSize; i++, j--) {
			oneWinCondtion.add(new positionTTT(j, i, 1));
		}
		winningLines.add(oneWinCondtion);
		
		
		
		if(OaO == true)
		{
//			Figure out how to handle the other 2 diagonal winning condition (The non centered ones)
//			This is not scalable, or at least I don't think
			oneWinCondtion = new ArrayList<positionTTT>();
			for (int i = 0, j = 1; i < boardSize-1; i++, j++) {
				oneWinCondtion.add(new positionTTT(i, j, 1));
			}
			winningLines.add(oneWinCondtion);
			
			oneWinCondtion = new ArrayList<positionTTT>();
			for (int i = 0, j = 1; i < boardSize-1; i++, j++) {
				oneWinCondtion.add(new positionTTT(j, i, 1));
			}
			winningLines.add(oneWinCondtion);
			
			oneWinCondtion = new ArrayList<positionTTT>();
			for (int i = 1, j = boardSize-1; i < boardSize; i++, j--) {
				oneWinCondtion.add(new positionTTT(j, i, 1));
			}
			winningLines.add(oneWinCondtion);
			
			oneWinCondtion = new ArrayList<positionTTT>();
			for (int i = 0, j = boardSize-2; i < boardSize-1; i++, j--) {
				oneWinCondtion.add(new positionTTT(j, i, 1));
			}
			winningLines.add(oneWinCondtion);
			
			
		}

		
		return winningLines;
	}
	
	public int getStateOfPositionFromBoard(positionTTT position, int size)
	{
		//a helper function to get state of a certain position in the Tic-Tac-Toe board by given position TicTacToe
		int index = position.x+position.y*size;
		return this.boardTicTacToe.get(index).state;
	}
	
	public void printBoardTicTacToe(int size)
	{
		
		//print in "graphical" display
		for (int i = 0; i < size; i++) 
		{	
			System.out.print("["); // boundary
			for (int j = 0; j < size; j++) 
			{
				if (this.getStateOfPositionFromBoard(new positionTTT(i,j), size)==1)
				{
					System.out.print(" X "); //print cross "X" for position marked by player 1
				}
				else if(this.getStateOfPositionFromBoard(new positionTTT(i,j), size)==2)
				{
					System.out.print(" O "); //print cross "O" for position marked by player 2
				}
				else if(this.getStateOfPositionFromBoard(new positionTTT(i,j), size)==0)
				{
					System.out.print(" _ "); //print "_" if the position is not marked
				}
				if(j==size-1)
				{
					System.out.print("]"); // boundary
					System.out.println();
				}
			}
			System.out.println();
		}
	}
		
	
	
	
	
}
