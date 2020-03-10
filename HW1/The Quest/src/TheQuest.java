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
	private TokenID players = new TokenID();
	private QuestInfo questInf = new QuestInfo();
	private static int maxHeroes = 3;
	private int currentNumHeroes = 0;
	private initMarket market = new initMarket();
	
	public TheQuest() {
		// TODO Auto-generated constructor stub\
		board.createTicTacToeBoard(row, column);
		
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
	public boolean playerMoves(positionTTT move, List<positionTTT> board) {
		// TODO Auto-generated method stub
		return false;
	}

	// Helper function to help validate player move if they keep inputing wrong thing
	@Override
	public positionTTT validate(int player, List<positionTTT> board) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//Run the game
	@Override
	public int run() {
		// TODO Auto-generated method stub

		//Sets up the info at the beginning
		System.out.println("Welcome to The Quest!");
		System.out.println("You can move using 'W','A','S',and 'D'");
		System.out.println("\nTo quit press Q. ");
		System.out.println("***Note: You cannot quit while in a fight or in the market.***\n");
	
		//Let's player select heroes.
		Scanner scan = new Scanner(System.in);
		String userInput;
		setHeroes();
		market();
				
		
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
		
		boolean validBuy = false;
		boolean keepBuying = true; 
		
		do {
			validBuy = market.runMarket(questInf, players);
			System.out.println("\nWould like to make another purchase? Enter a y/Y or n/N");
			userInput = scan.next();
			try {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
