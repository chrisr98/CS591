import java.util.List;

//This is an interface for what methods all board games should include.



public interface BoardGame {
	
	// A method to check if the game is over
	int isEnded(CreateBoard board);
	// A method to move player
	boolean playerMoves(positionTTT move, List<positionTTT> board);
	// A method to validate the plater move 
	positionTTT validate(int player, List<positionTTT> board);
	// A method to run the game
	int run();
}
