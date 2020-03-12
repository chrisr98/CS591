import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TheQuest extends CreateBoard implements BoardGame {

	
	private CreateBoard board = new CreateBoard();
	private List<List<positionTTT>>  allWinningLines = new ArrayList<>();
	private int row = 8;
	private int column = 8;
	private int size = row;
	private TokenID players = new TokenID();
	private QuestInfo questInf = new QuestInfo();
	private static int maxHeroes = 3;
	private static int minHeroes = 1;
	private int currentNumHeroes = 0;
	private initMarket market = new initMarket();
	private positionTTT currentLoc;
	private int previousState = 0;
	private Hero heroSelect = new Hero();
	private fightSequence fight;
	
	public TheQuest() {
		// TODO Auto-generated constructor stub\
		board.createTicTacToeBoard(row, column);
		currentLoc = board.boardTicTacToe.get(0);
		
	}
	
	
	// Checks to see if game is over and the win condition
	@Override
	public int isEnded(CreateBoard board) {
		// TODO Auto-generated method stub
		
		// Pseudo code remember to change
		boolean playerDead = true;
		if (!playerDead) {
			System.out.println("Player Died");
			return 0;
		} 
		else {
			System.out.println("You exited game");
			return 1;
		}
	}


	 // checks to see if player move is valid and updates board if it is
	@Override
	public boolean playerMoves(String move, List<positionTTT> board) {
		// TODO Auto-generated method stub
		positionTTT spot = new positionTTT(currentLoc.x, currentLoc.y, 1);
		boolean valid = false;
		//checks which direction and if valid
		if(move.equals("w") || move.equals("W")) {
			if (validate(spot.x-1, board)) {
				spot.x -= 1;
				valid = true;
			}
		} else if (move.equals("a") || move.equals("A")) {
			if(validate(spot.y-1, board)) {
				spot.y -= 1;
				valid = true;
			}
		} else if (move.equals("s") || move.equals("S")) {
			if(validate(spot.x+1, board)) {
				spot.x += 1;
				valid = true;
			}
		} else if (move.equals("d") || move.equals("D")) {
			if(validate(spot.y+1, board)) {
				spot.y += 1;
				valid = true;
			}
		} else {
			System.out.println("Not a valid move!");
		}
		//if valid store info to update cell displays accordingly
		if(valid == true)
		{
			int temp = this.board.getStateOfPositionFromBoard(spot, row);
			 
			if (temp == 0) {
				System.out.println("Prepare for battle!");
				//Add battle function
			} else if (temp == 2) {
				market();
			} else if (temp == 3) {
				System.out.println("Can't enter non-accessible cells!");
				return false;
			}
			currentLoc.state = previousState;
			previousState = temp;
			currentLoc = spot;
		}
		

		return  valid;
	}

	// Helper function to help validate player move if they keep inputing wrong thing
	@Override
	public boolean validate(int move, List<positionTTT> board) {
		// TODO Auto-generated method stub
		if (move >= size || move < 0) {
			System.out.println("Not a valid move!");
			return false;
		}
		return true;
	}

	
	//Run the game
	@Override
	public int run() {
		// TODO Auto-generated method stub

		//Sets up the info at the beginning
		System.out.println("Welcome to The Quest!");
		System.out.println("To quit press q/Q. ");
		System.out.println("***Note: You cannot quit while in a fight or in the market.***\n");
	
		//Let's player select heroes.
		Scanner scan = new Scanner(System.in);
		String userInput;
		if (setHeroes() == -100)
		{
			return -100;
		}
		
		//Set board, starting position for player and print it.
		board.setTileStates();
		
		//Name/mana/strength/agility/dexterity/starting money/starting experience

		
		System.out.println("\nHero # -->_______Name________: | Mana | Strength | Agility | Dexterity | Money | EXP | HP");
		System.out.println("_______________________________________________________________");
		players.printHeroList();
		System.out.println("_______________________________________________________________");
		board.printBoard();
		
		System.out.println("Enter your move!");
		System.out.println("You can move using 'w/W','a/A','s/S',and 'd/D'");
		System.out.println("Entering an 'M' spot opens the market");
		System.out.println("Entering an '_' spot triggers an encounter");
		System.out.println("A '&' spot is not accessible");
		System.out.println("To quit press q/Q. ");
		
		//Continuously get user to enter next input
		while((userInput = scan.next())!=null) {
		
			positionTTT tempLoc = currentLoc;
			int tempState = previousState;
			
			if(userInput.equals("q") || userInput.equals("Q")) {
				break;
			} else if(userInput.equals("i") || userInput.equals("I")) {
				//Checks if use wants to look at info menu
				accessInventory();
				System.out.println("Enter your move!");
				System.out.println("You can move using 'w/W','a/A','s/S',and 'd/D'");
				System.out.println("Entering an 'M' spot opens the market");
				System.out.println("Entering an '_' spot triggers an encounter");
				System.out.println("A '&' spot is not accessible");
				System.out.println("To quit press q/Q. ");
				continue;
			} else if(userInput.equals("m") || userInput.equals("M")) {
				//shows map
				System.out.println("This is showing previous state of map. Before your last move. It will update after the next move.");
				board.printBoard();
				continue;
			}
			
			
			//validates move and updates map accordingly
			boolean  valid = playerMoves(userInput, board.boardTicTacToe);
			
			if(valid == true) {
				board.updateTiles(currentLoc, tempLoc, tempState);
			}
				
			board.printBoard();
			
			
			
			System.out.println("Enter your move!");
			System.out.println("You can move using 'w/W','a/A','s/S',and 'd/D'");
			System.out.println("Entering an 'M' spot opens the market");
			System.out.println("Entering an '_' spot triggers an encounter");
			System.out.println("A '&' spot is not accessible");
			System.out.println("To quit press q/Q. ");
		}
				
		infoMenu();
		return 0;
	
	}	
	
	
	
	// I've decided to split the run function into different methods so it is smaller to digest
	private int setHeroes() {
		//Ask how many heroes
		System.out.println("How many heroes would you like to add?\n***Note: You cannot have more than 3 heroes and you must have at least 1.***");
		
		System.out.println();
		Scanner scan = new Scanner(System.in);
		int numHeroes;
		
		
		// If user does not input Int, it stops everything
		try {
			// Initialize how many heroes the player wants
			numHeroes = scan.nextInt();
			while (numHeroes+currentNumHeroes > maxHeroes || numHeroes < minHeroes) {
				System.out.println("You currently have "+ currentNumHeroes + " heroes.");
				System.out.println("***Note: You cannot have more than 3 heroes and you must have at least 1.***");
				System.out.println("How many heroes would you like to add?");
				numHeroes = scan.nextInt();
				
				
			}
			currentNumHeroes = numHeroes;
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("Must enter a number!");
			scan.close();
			return -100;
		}
		
		//Selecting a hero from the list of paladins, sorcerers, and warriors
		try {
			System.out.println("You can now select "+ numHeroes + " heroes");
			int heroCount = 1;
			while (heroCount <= numHeroes) {
				System.out.printf("Time to choose a class for your hero #%d", heroCount);
				System.out.println("\nFor Paladins enter 1");
				System.out.println("For Sorcerers enter 2");
				System.out.println("For Warriors enter 3");
				int heroType = scan.nextInt();
				
				if(heroType == 1) {
					questInf.printPaladins();
					try {
						int heroSelect = scan.nextInt()-1;
						System.out.print("You chose --> ");
						players.addHero(heroCount, questInf.getPaladins(heroSelect));
						
						
					} catch (InputMismatchException e) {
						// TODO: handle exception
						System.out.println("Must enter a number!");
						scan.close();
						return -100;
					}
					heroCount+=1;
					
				} else if(heroType == 2) {
					questInf.printSorcerers();
					try {
						int heroSelect = scan.nextInt()-1;
						System.out.print("You chose --> ");
						players.addHero(heroCount, questInf.getSorcerer(heroSelect));
						
					} catch (InputMismatchException e) {
						// TODO: handle exception
						System.out.println("Must enter a number!");
						scan.close();
						return -100;
					}
					heroCount+=1;
					
				} else if(heroType == 3) {
					questInf.printWarriors();
					try {
						int heroSelect = scan.nextInt()-1;
						System.out.print("You chose --> ");
						players.addHero(heroCount, questInf.getWarrior(heroSelect));
						
					} catch (InputMismatchException e) {
						// TODO: handle exception
						System.out.println("Must enter a number!");
						scan.close();
						return -100;
					}
					heroCount+=1;
					
				} else {
					System.out.println("Class type does not exists");
				}
				//make it wait 3 seconds
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
			}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("Must enter a number!");
			scan.close();
			return -100;
		}
			
		return 0;
		
	}
	

	private int market() {//Run the market class to buy and sell stuff
		Scanner scan = new Scanner(System.in);
		String userInput;
		
		int validRun = 0;
		boolean keepBuying = true; 
		
		do {
			validRun = market.runMarket(questInf, players);
			if (validRun == 2) {
				infoMenu();
			} else if (validRun == 3) {
				board.printBoard();
			}
			System.out.println("\nWould like to enter the market again? Enter a y/Y or n/N");
			try {
				userInput = scan.next();
				if(userInput.equals("y") || userInput.equals("Y")) {
					keepBuying = true;
					System.out.println("OK!");
				} else if(userInput.equals("n") || userInput.equals("N")) {
					keepBuying = false;
					System.out.println("OK!");
				} else {
					System.out.println("Must enter a y/Y or n/N");
					return -100;
				}
				
				
			} catch (InputMismatchException e) {
				// TODO: handle exception
				System.out.println("Must enter a number!");
				return -100;
			}
			
		} while (keepBuying == true);
				
		
		return 0;
		
	}

	//Simply displays the inventory
	private int infoMenu() {
		
		System.out.println("INFORMATION MENU");
		System.out.println("\nHero # -->_______Name________: | Mana | Strength | Agility | Dexterity | Money | EXP | HP"); 
		System.out.println("_______________________________________________________________");
		players.printHeroList();
		System.out.println("_______________________________________________________________");
		
		System.out.println("THEIR INVENTORY");
		
		for (int i = 0; i < players.totalHeroes(); i++) {
			String[] seller = players.getHero(i);
			System.out.printf("%nHero %d --> %s.%n", i+1, Arrays.toString(seller));

			System.out.printf("This is what they are carrying:%n");

			Inventory bag = players.getBag(i);

			bag.printBagItems();
		}
		
		return 1;
	}
	
	private int accessInventory() {
		infoMenu();
		
		Scanner scan = new Scanner(System.in);
		
		int itemSelection;
		
		// Ask which hero to access
		System.out.println("Which hero would you like to access?");
		System.out.println("*Or enter 0 to exit market*");
		players.printHeroList();
		int heroIndex = scan.nextInt() - 1;

		if (heroIndex == -1) {
			return 0;
		}
		
		System.out.println("Which item type would you like to access?");
		
		String[] heroInventory = players.getHero(heroIndex);
		
		System.out.printf("This is what they are carrying:%n");

		Inventory bag = players.getBag(heroIndex);

		bag.printBagItems();

		// Name/mana/strength/agility/dexterity/starting money/starting experience
		int heroInventoryMana = Integer.parseInt(heroInventory[1]);
		int heroInventorySTR = Integer.parseInt(heroInventory[2]);
		int heroInventoryAGL = Integer.parseInt(heroInventory[3]);
		int heroInventoryDEX = Integer.parseInt(heroInventory[4]);
		int heroInventoryIncome = Integer.parseInt(heroInventory[5]);
		int heroInventoryEXP = Integer.parseInt(heroInventory[8]);
		int heroInventoryHP = Integer.parseInt(heroInventory[7]);
		
		//Select item from to sell from inventory through prompts
				System.out.println("Which item type would you like to sell?");
				System.out.println("Potions(p/P), Armor(a/A), Spells(s/S), Weapons(w/W)");
				System.out.println("Enter (e/E) to exit");
				System.out.println("To view Info press i/I.");
				System.out.println("To view Map press m/M.");
				
				scan.hasNext();
				String userInput;
				String type;
				try {
					userInput = scan.next();
				} catch (InputMismatchException e) {
					// TODO: handle exception
					System.out.println("Wrong input");
					return 0;
				}
				
				if(userInput.equals("e") || userInput.equals("E")) {
					System.out.println("OK!");
					return 0;
				} else if(userInput.equals("i") || userInput.equals("I")) {
					System.out.println("OK!");
					return 2;
				} else if(userInput.equals("m") || userInput.equals("M")) {
					return 3;
				}
				
				System.out.println("Select a number");
				scan.hasNext();
				
				String[] item;
				
				try {
					itemSelection = scan.nextInt()-1;
				} catch (InputMismatchException e) {
					// TODO: handle exception
					System.out.println("Wrong input");
					return 0;
				}
				
				//checks if hero has item to sell and gets the item to remove
				if(userInput.equals("p") || userInput.equals("P")) {
					type = "potion";
					System.out.println("OK!");
					if(players.getBag(heroIndex).potionLen() == 0 || players.getBag(heroIndex).potionLen() <= itemSelection) {
						System.out.println("Hero does not own that item.");
						return 0;
					}
					item = players.getBag(heroIndex).getPotion(itemSelection);
					//Increase stat accordingly
					if(item[0].equals("Healing_Potion")) {
						int potion = Integer.parseInt(item[3]);
						int temp = heroInventoryHP;
						heroInventoryHP += (potion);
						System.out.printf("HP increased from %d to %d", temp, heroInventoryHP);
					} else if(item[0].equals("Strength_Potion")) {
						int potion = Integer.parseInt(item[3]);
						int temp = heroInventorySTR;
						heroInventorySTR += (potion);
						System.out.printf("Strength increased from %d to %d", temp, heroInventorySTR);
					} else if(item[0].equals("Magic_Potion")) {
						int potion = Integer.parseInt(item[3]);
						int temp = heroInventoryMana; 
						heroInventoryMana += (potion);
						System.out.printf("Mana increased from %d to %d", temp, heroInventoryMana);
					} else if(item[0].equals("Luck_Elixir")) {
						int potion = Integer.parseInt(item[3]);
						int temp = heroInventoryAGL;
						heroInventoryAGL += (potion);
						System.out.printf("Agility increased from %d to %d", temp, heroInventoryAGL);
					} else if(item[0].equals("Mermaid_Tears")) {
						int potion = Integer.parseInt(item[3]);
						int temp = heroInventoryDEX;
						heroInventoryDEX += (potion);
						System.out.printf("Dextirity increased from %d to %d", temp, heroInventoryDEX);
					} else {
						int potion = Integer.parseInt(item[3]);
						int temp = heroInventoryEXP;
						heroSelect.addEXP(heroInventory, potion);
						heroSelect.levelUp(heroInventory);
						System.out.printf("Experience increased from %d to %d", temp, heroInventoryEXP);
					}
					players.remToBag(heroIndex, itemSelection, type);
				} else if(userInput.equals("a") || userInput.equals("A")) {
					type = "armor";
					System.out.println("OK!");
					if (players.getBag(heroIndex).armorLen() == 0 || players.getBag(heroIndex).armorLen() <= itemSelection) {
						System.out.println("Hero does not own that item.");
						return 0;
					}
					item = players.getBag(heroIndex).getArmor(itemSelection);
					players.getBag(heroIndex).equipArmor(itemSelection);
					System.out.printf("You have equipped %s.", Arrays.toString(item));
				} else if(userInput.equals("s") || userInput.equals("S")) {
					type = "spell";
					System.out.println("OK!");
					if (players.getBag(heroIndex).spellLen() == 0 || players.getBag(heroIndex).spellLen() <= itemSelection) {
						System.out.println("Hero does not own that item.");
						return 0;
					}
					item = players.getBag(heroIndex).getSpell(itemSelection);
					System.out.println("Can only be used as an attack not consumable");
				} else if(userInput.equals("w") || userInput.equals("W")) {
					type = "weapon";
					System.out.println("OK!");
					if (players.getBag(heroIndex).weaponLen() == 0 || players.getBag(heroIndex).weaponLen() <= itemSelection) {
						System.out.println("Hero does not own that item.");
						return 0;
					}
					item = players.getBag(heroIndex).getWeapon(itemSelection);
					System.out.printf("You have equipped %s.", Arrays.toString(item));
					players.getBag(heroIndex).equipWeapon(itemSelection);
				} else {
					System.out.println("Hero does not own that item.");
					return 0;
				}
				
				//Set new value
				String newMana = "" + heroInventoryMana;
				heroInventory[1] = newMana;
				
				String newSTR = "" + heroInventorySTR;
				heroInventory[2] = newSTR;
				
				String newAGL = "" + heroInventoryAGL;
				heroInventory[3] = newAGL;
				
				String newDEX = "" + heroInventoryDEX;
				heroInventory[4] = newDEX;
				
				String newIncome = "" + heroInventoryIncome;
				heroInventory[5] = newIncome;
				
				String newEXP = "" + heroInventoryEXP;
				heroInventory[6] = newEXP;
				
				String newHP = "" + heroInventoryHP;
				heroInventory[7] = newHP;
		
		return 1;
	}
	
	private int beginBattle() {
		fight = new fightSequence(players, questInf);
		
		boolean isEnemyAlive = true;
		boolean isHeroAlive = true;
		do {
			fight.printEnemy();
			fight.printAllies();
			int res = fight.roundFight();
			if(res == 100) {
				accessInventory();
				System.out.println("Next Round!");
			} else if(res == -100) {
				System.out.println("Try Again");
				continue;
			} else {
				System.out.println("Next Round!");
			}
			isEnemyAlive = !fight.allEnemyDead();
			isHeroAlive = !fight.allAllyDead();
			
		} while (isHeroAlive == true || isEnemyAlive == true);
		return 0;
	}
}
