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
		if(valid == true)
		{
			int temp = this.board.getStateOfPositionFromBoard(spot, row);
			 
			if (temp == 0) {
				System.out.println("Prepare for battle!");
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
		setHeroes();
		
		//Set board, starting position for player and print it.
		board.setTileStates();
		
		//Name/mana/strength/agility/dexterity/starting money/starting experience

		System.out.println("\nHero # -->_______Name________: | Mana | Strength | Agility | Dexterity | Money | EXP ");
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
		while((userInput = scan.next())!=null) {
			System.out.println("Your team:");
			System.out.println("_______________________________________________________________");
			players.printHeroList();
			System.out.println("_______________________________________________________________");
			if(userInput.equals("q") || userInput.equals("Q")) {
				break;
			} else if(userInput.equals("i") || userInput.equals("I")) {
				infoMenu();
				System.out.println("Enter your move!");
				System.out.println("You can move using 'w/W','a/A','s/S',and 'd/D'");
				System.out.println("Entering an 'M' spot opens the market");
				System.out.println("Entering an '_' spot triggers an encounter");
				System.out.println("A '&' spot is not accessible");
				System.out.println("To quit press q/Q. ");
				continue;
			}
			
			positionTTT tempLoc = currentLoc;
			int tempState = previousState;
			
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
		System.out.println("How many heroes would you like to add? ***Note: You cannot have more than 3 heroes.***");
		
		System.out.println();
		Scanner scan = new Scanner(System.in);
		int numHeroes;
		
		
		// If user does not input Int, it stops everything
		try {
			// Initialize how many heroes the player wants
			numHeroes = scan.nextInt();
			
			while (numHeroes+currentNumHeroes > maxHeroes) {
				System.out.println("You currently have "+ currentNumHeroes + " heroes.");
				System.out.println("***Note: You cannot have more than 3 heroes.***");
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
	
	private int market() {
		Scanner scan = new Scanner(System.in);
		String userInput;
		
		int validRun = 0;
		boolean keepBuying = true; 
		
		do {
			validRun = market.runMarket(questInf, players);
			if (validRun == 2) {
				infoMenu();
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

	private int infoMenu() {
		
		System.out.println("Your team:");
		System.out.println("_______________________________________________________________");
		players.printHeroList();
		System.out.println("_______________________________________________________________");
		
		for (int i = 0; i < players.totalHeroes(); i++) {
			String[] seller = players.getHero(i);
			System.out.printf("%nHero %d --> %s.%n", i+1, Arrays.toString(seller));

			System.out.printf("This is what they are carrying:%n");

			Inventory bag = players.getBag(i);

			bag.printBagItems();
		}
		
		
		
		
		return 0;
	}

}
