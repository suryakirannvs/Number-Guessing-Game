import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

public class NumberGuessingGame {
		public static void main(String[] args) {

		// declare and initialize the required variables
		final int MAX_NUMBER = 10;
		int guessed = 0;
		int choice = 1;
		int hint = 0;
		// These calculate and display the execution time
		long start, end, duration;

		// Creating a Random Object
		Random rand = new Random();
		JOptionPane.showMessageDialog(null, "Choose a number between 1 - 10");

		// outer loop to check if you want to continue the game(YES/NO)
		do {
				int guess = rand.nextInt(MAX_NUMBER) + 1;
				int count = 0;
				start = System.currentTimeMillis();
				int high = MAX_NUMBER;
				int low = 1;
				guessed = JOptionPane.showConfirmDialog(null, "Is this your intended number \"" + guess + "\" ?", "Confirmation", JOptionPane.YES_NO_OPTION);
				// inner loop prompt you if your guess is higher, lower or correct
				while (guessed != JOptionPane.YES_OPTION) {
					count++;
					hint = JOptionPane.showConfirmDialog(null, "Is your number higher or lower ? \n (Please select 'Yes' for higher and 'No' for lower) ", "Confirmation", JOptionPane.YES_NO_OPTION);
						if (hint != JOptionPane.YES_OPTION) {
							high = guess;	
						}
						else {
							low = guess;
						}
						try {
							guess = rand.nextInt(high - low) + low;							
						}
						catch (IllegalArgumentException ex) {
							System.out.println("Illegal number of Attempts" + ex.getMessage());
							JOptionPane.showMessageDialog(null, "Illegal number of Attempts : Please play again");
							System.exit(0);
							}
						guessed = JOptionPane.showConfirmDialog(null, "Is this your intended number \"" + guess + "\" ?", "Confirmation", JOptionPane.YES_NO_OPTION);
				}		

				end = System.currentTimeMillis();
				duration = end - start;
				JOptionPane.showMessageDialog(null, "I guessed it correctly. \nThe correct number was \"" + guess +  "\".\nI tried " + count + " times, and " + (duration / 1000d) + " seconds.");
				choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Confirmation", JOptionPane.YES_NO_OPTION);
			} while (choice != JOptionPane.NO_OPTION);
		JOptionPane.showMessageDialog(null, "Thanks for playing");		
		}
}
	