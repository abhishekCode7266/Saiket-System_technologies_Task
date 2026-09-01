import java.util.Random;
import java.util.Scanner;

public class Numberguessinggame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int number = random.nextInt(100) + 1;
        int attempts = 0;
        int guess = 0;

        System.out.println("===== NUMBER GUESSING GAME =====");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("Try to guess the number!");

        while (guess != number) {

            System.out.print("Enter your guess: ");

            try {
                guess = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            if (guess < 1 || guess > 100) {
                System.out.println("Please enter a number between 1 and 100.");
                continue;
            }

            attempts++;

            if (guess < number) {
                System.out.println("Too low! Try again.");
            } 
            else if (guess > number) {
                System.out.println("Too high! Try again.");
            } 
            else {
                System.out.println("\nCongratulations!");
                System.out.println("You guessed the correct number.");
                System.out.println("Number: " + number);
                System.out.println("Attempts: " + attempts);
            }
        }

        sc.close();
    }
}