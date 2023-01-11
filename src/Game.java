import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Game {
    static int receivingNumb() {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.print("Enter a number: ");
        number = scanner.nextInt();
        return number;
    }

    static int randomNumb() {
        Random rnd = new Random();
        return rnd.nextInt(100);
    }


    static boolean isCorrect(int number, int rnd, int right) {
        if (number == rnd) {
            System.out.print("Your guess is correct! ");
            return true;
        } else if (number > rnd) {
            if (right != 4) {
                System.out.println("Your guess is bigger than the mystery number! Try again ! ");
            }
            return false;
        } else {
            if (right != 4) {
                System.out.println("Your guess is smaller than the mystery number! Try again !");
            }
            return false;
        }
    }

    static boolean isLost(int right) {
        return right >= 5;
    }

    static boolean isValid(int number) {
        if ((number < 0) || (number > 100)) {
            System.out.println("The number you entered is not valid! ");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int right = 0;
        int rnd = randomNumb();
        int[] guessArr = new int[5];
        
        while (right < 5) {
            int number = receivingNumb();
            guessArr[right] = number;

            if (!(isValid(number))) {
                System.out.println("Please enter a number between 0-100! ");
            } else {
                if (isCorrect(number, rnd, right)) {
                    System.out.println("You won the game! ");
                    break;
                } else {
                    System.out.println("Your remaining right: " + (5 - ++right));
                }
            }
            System.out.println();
        }

        if (isLost(right)) {
            System.out.println("You lost the game ! ");
        }
        System.out.println();
        System.out.println("Your guess numbers: " + Arrays.toString(guessArr));
        System.out.println("The mystery number : " + rnd);
    }
}
