import java.util.*;

public class PlayerID {
	
	private static ArrayList<String> playerSymbol = new ArrayList<String>();
	private static ArrayList<Integer> playerTokens= new ArrayList<Integer>();
	
	private static List<ArrayList> listOfMixedTypes = new ArrayList<ArrayList>();

	
	
	
	
	
	public PlayerID(int playerID, String tokenID)
	{
		playerSymbol.add(tokenID);
		playerTokens.add(playerID);
		listOfMixedTypes.add(playerTokens);
		listOfMixedTypes.add(playerSymbol);
	}
	
}
