
import java.util.Scanner;

/**
 * @author Christian E. Anderson
 * @version 1.0
 * @since 2024-06-01
 *
 * This program demonstrates how a simple student housing point system works.
 *
 * It first informs the user how this program works, then prompts the user to
 * answer various questions.
 *
 * After each question is answered, the program will keep track of points. After
 * completing all questions, the program will output the total score.
 *
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Thank you for applying for student housing!");
        System.out.println("This program will ask you various questions to determine your eligibility for housing.");
        System.out.println("Please answer each question honestly. (Type 'yes' to continue or 'no' to quit.)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("no")) {
            System.out.println("Thank you for your time. Goodbye!");
            scanner.close();
            return;
        }
        int points = 0;
        System.out.println("Are you a full-time or part-time student? (full/part)");
        input = scanner.nextLine();
        points += Checker.checkStudentStatus(input, points);

        System.out.println("Your current points: " + points);
        scanner.close();
    }

    private class Checker {

        public static int checkStudentStatus(String input, int points) {
            if (input.equalsIgnoreCase("full")) {
                return 2;
            } else if (input.equalsIgnoreCase("part")) {
                return 1;
            } else {
                System.out.println("Invalid input. No points awarded.");
                return 0;
            }
        }
    }
}
