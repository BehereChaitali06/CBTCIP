import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 10;
        int score = 0;
        int rounds = 3;

        System.out.println("Welcome to Guess the Number Game!");

        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Round " + round + ":");
            System.out.println("I have selected a number between 1 and 100. Try to guess it!");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += (maxAttempts - attempts + 1); // More points for fewer attempts
                    hasGuessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("The number is higher than your guess.");
                } else {
                    System.out.println("The number is lower than your guess.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The number was " + numberToGuess);
            }

            System.out.println("Your score after round " + round + " is: " + score);
        }

        System.out.println("Game Over! Your final score is: " + score);
        scanner.close();
    }
}
