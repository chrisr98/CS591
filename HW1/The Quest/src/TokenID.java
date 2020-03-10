import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Keeps a list of players 

public class TokenID {

	private static ArrayList<Integer> playerTokens = new ArrayList<Integer>();
	
	private static ArrayList<Inventory> heroBags = new ArrayList<Inventory>();
	
	private static ArrayList<String[]> playerStats = new ArrayList<String[]>();
	
	
	
	@SuppressWarnings("rawtypes")
	private static List<ArrayList> listOfMixedTypes = new ArrayList<ArrayList>();

	

	
	public TokenID() {
		// TODO Auto-generated constructor stub
		Inventory hero1 = new Inventory();
		Inventory hero2 = new Inventory();
		Inventory hero3 = new Inventory();
		heroBags.add(hero1);
		heroBags.add(hero2);
		heroBags.add(hero3);
		
	}
	
	// Add number players to the list
	public void addHero(int heroNum, String[] heroInfo) {
		playerStats.add(heroInfo);
		playerTokens.add(heroNum);
	}
	
	// Returns player number/ID
	public String[] getHero(int heroNumber) {
		return playerStats.get(heroNumber);
	}

	// Print list of heroes
	public void printHeroList() {
		System.out.printf("List of Heroes: %n");
		for (int i = 0; i < playerStats.size(); i++) {
			System.out.printf("Hero %d %s %n", i+1, Arrays.toString(playerStats.get(i)));
		}
		
	}
	
	private void addToBag(int heroNum, String[] item, String itemType) {
		if(itemType.equals("armor")) {
			heroBags.get(heroNum-1).addArmor(item);
		} else if(itemType.equals("potion")) {
			heroBags.get(heroNum-1).addPotion(item);
		} else if(itemType.equals("spell")) {
			heroBags.get(heroNum-1).addSpell(item);
		} else if(itemType.equals("weapon")) {
			heroBags.get(heroNum-1).addWeapon(item);
		} else {
			System.out.printf("Unidentified items cannot be added");
		}
		
	}
	
}
