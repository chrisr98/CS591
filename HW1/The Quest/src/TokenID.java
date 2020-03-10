import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Keeps a list of players 

public class TokenID {

	public static ArrayList<Integer> playerTokens = new ArrayList<Integer>();
	
	private static ArrayList<String[]> playerStats = new ArrayList<String[]>();
	
	@SuppressWarnings("rawtypes")
	private static List<ArrayList> listOfMixedTypes = new ArrayList<ArrayList>();

	

	
	public TokenID() 
	{
		// TODO Auto-generated constructor stub
	}
	
	// Add number players to the list
	public TokenID(int playerID, String[] playerInfo)
	{
		playerStats.add(playerInfo);
		playerTokens.add(playerID);
		listOfMixedTypes.add(playerTokens);
		listOfMixedTypes.add(playerStats);
		
	}
	
	// Returns player number/ID
	public String getPlayer(int playerNumber)
	{
		return Arrays.toString(playerStats.get(playerNumber));
	}
	//this is stupid
	
	// Print list of players
	public static void printTokenList()
	{
		System.out.printf("List of Tokens: %n");
		for (int i = 0; i < playerStats.size(); i++) {
			System.out.printf("Hero %d %s %n", playerTokens.get(i), Arrays.toString(playerStats.get(i)));
		}
		
	}
}
