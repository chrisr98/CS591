import java.util.InputMismatchException;
import java.util.Scanner;

public class RunGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// run game loop
		Scanner scan = new Scanner(System.in);
		boolean playAgain = true;
		int x = 0;
		int y = 0;
		int z = 0;

		System.out.println("Would you like to play Tic-Tac-Toe or Order and Chaos");
		System.out.println("Enter '1' for Tic-Tac-Toe or '2' Order and Chaos");
		int gameChoice;
		String answer;
		
		try {
			
			//Has player choose a game, wrong input end program
			gameChoice = scan.nextInt();
			scan.nextLine();
			if (gameChoice == 1) {
				System.out.println("You have chosen Tic-Tac-Toe \n");
				do {

					TicTacToe startGame = new TicTacToe();
					int result = startGame.run();
					// Tally score ----> make this into a method
					if (result == 1) {
						x += 1;
					} else if (result == 2) {
						y += 1;
					} else if (result == -100) {
						System.out.println("You didn't follow the format properly!");
						System.out.println("Start the program over!");
						break;
					} else {
						z += 1;
					}

					// Ask to run another game
					System.out.println("Would you like to play another game?");
					System.out.println("Enter y/Y or n/N");
					answer = scan.nextLine();
					if (answer.equals("N") || answer.equals("n")) {
						playAgain = false;
						System.out.println("Thank you for playing!");
						System.out.println("Here are your scores! ");
						System.out.printf("\n Player 1 won %d time(s) ", (x));
						System.out.printf("\n Player 2 won %d time(s) ", (y));
						System.out.printf("\n I won (the game ended in a tie) %d time(s) %n", (z));
						break;
					} else if (answer.equals("Y") || answer.equals("y")) {
						System.out.println("Great let's go again! \n");
						continue;
					} else {
						System.out.println("I'll take that as a no.");
						System.out.println("Thank you for playing!");
						System.out.println("Here are your scores! ");
						System.out.printf("\n Player 1 won %d times ", (x));
						System.out.printf("\n Player 2 won %d times ", (y));
						System.out.printf("\n I won (the game ended in a tie) %d times %n", (z));
						break;
					}

				} while (playAgain == true);
			} else if (gameChoice == 2) {
				System.out.println("You have chosen Order and Chaos \n");
				do {

					OrderAndChaos startGame = new OrderAndChaos();
					int result = startGame.run();
					// Tally score ----> make this into a method
					if (result == 1) {
						x += 1;
					} else if (result == 2) {
						y += 1;
					} else if (result == -100) {
						System.out.println("You didn't follow the format properly!");
						System.out.println("Start the program over!");
						break;
					} else {
						z += 1;
					}

					// Ask to run another game
					System.out.println("Would you like to play another game?");
					System.out.println("Enter y/Y or n/N");
					answer = scan.nextLine();
					if (answer.equals("N") || answer.equals("n")) {
						playAgain = false;
						System.out.println("Thank you for playing!");
						System.out.println("Here are your scores! ");
						System.out.printf("\n Player 1 won %d time(s) ", (x));
						System.out.printf("\n Player 2 won %d time(s) %n", (y));
						break;
					} else if (answer.equals("Y") || answer.equals("y")) {
						System.out.println("Great let's go again! \n");
						continue;
					} else {
						System.out.println("I'll take that as a no.");
						System.out.println("Thank you for playing!");
						System.out.println("Here are your scores! ");
						System.out.printf("\n Player 1 won %d times ", (x));
						System.out.printf("\n Player 2 won %d times %n", (y));
						break;
					}

				} while (playAgain == true);
			} else {
				System.out.println("Please write input as instructed.");
			}

		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("Please write input as instructed.");
			System.out.println("Start the program over!");

		}

		scan.close();
	}

}
