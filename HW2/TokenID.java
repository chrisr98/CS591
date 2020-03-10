import java.util.ArrayList;

public class TokenID {

	public static ArrayList<Integer> playerTokens = new ArrayList<Integer>();
	
	
	public TokenID(int players)
	{
		for (int i = 1; i <= players; i++) {
			playerTokens.add(i);
		}
	}
	public int getPlayer(int playerNumber)
	{
		return playerTokens.get(playerNumber-1);
	}
	
	
	
	public static void printTokenList()
	{
		System.out.printf("List of players: %n");
		for (int i = 0; i < playerTokens.size(); i++) {
			System.out.printf("Player %d %n", playerTokens.get(i));
		}
		
	}
}
