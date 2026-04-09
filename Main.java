
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

        // Boilerplate scanner code
        Scanner scanner;
        try {
            scanner = new Scanner(System.in);
        } catch (Exception e) {
            System.out.println("An error occurred while initializing the scanner: " + e.getMessage());
            return;
        }

        // Flavor text to explain the program to the user
        System.out.println("Thank you for applying for student housing!");
        System.out.println("This program will ask you various questions to determine your eligibility for housing.");
        System.out.println("Please answer each question honestly. (Type 'yes' to continue or 'no' to quit.)");

        String input = scanner.nextLine();
        if (!Checker.checkConfirmation(input)) {
            scanner.close();
            return;
        }

        // User confirmed, start asking questions and calculating points
        int points = 0;
        System.out.println("Are you a full-time or part-time student? (full/part)");
        input = scanner.nextLine();
        points += Checker.checkStudentStatus(input);

        System.out.println("Are you an in-state, out-of-state, or international student? (in/out/international)");
        input = scanner.nextLine();
        points += Checker.checkLocationStatus(input);

        System.out.println("Have you lived in dorms before? (yes/no)");
        input = scanner.nextLine();
        points += Checker.checkDormStatus(input);

        System.out.println("What year are you in? (freshman/sophomore/junior/senior)");
        input = scanner.nextLine();
        points += Checker.checkYearStatus(input);

        // This question has same points as dorm status, so will reuse that method
        System.out.println("Do you receive financial aid? (yes/no)");
        input = scanner.nextLine();
        points += Checker.checkDormStatus(input);

        // The following checks are here since they need interaction with the scanner object.
        System.out.println("Last Question");
        System.out.println("Have you ever been on any sort of probation? (yes/no)");
        input = scanner.nextLine();
        if (Checker.checkProbationStatus(input)) {
            System.out.println("Are you still on probation? (yes/no)");
            input = scanner.nextLine();
            if (Checker.checkProbationStatus(input)) {
                System.out.println("Do have accommodations to address your probation? (yes/no)");
                input = scanner.nextLine();
                if (Checker.checkProbationStatus(input)) {
                    points += 1;
                }
            } else {
                points += 1;
            }
        }

        System.out.println("Your total score: " + points);
        scanner.close();
    }

    /**
     * This class contains all the static methods used for checking user input
     * and returning points.
     */
    private class Checker {

        // Checks that user confirmed they want to continue.
        private static boolean checkConfirmation(String input) {
            if (input.equalsIgnoreCase("no")) {
                System.out.println("Thank you for your time. Goodbye!");
                return false;
            }
            return true;
        }

        // Checks that what type of student the user is.
        private static int checkStudentStatus(String input) {
            if (input.equalsIgnoreCase("full")) {
                return 2;
            } else if (input.equalsIgnoreCase("part")) {
                return 1;
            } else {
                System.out.println("Invalid input. No points awarded.");
                return 0;
            }
        }

        // Checks where the student is coming from.
        private static int checkLocationStatus(String input) {
            if (input.equalsIgnoreCase("international")) {
                return 2;
            } else if (input.equalsIgnoreCase("out")) {
                return 1;
            } else {
                return 0;
            }
        }

        // Checks if they are accustomed to dorm life.
        private static int checkDormStatus(String input) {
            if (input.equalsIgnoreCase("yes")) {
                return 1;
            } else {
                return 0;
            }
        }

        // Checks what year the student is in.
        private static int checkYearStatus(String input) {
            if (input.equalsIgnoreCase("freshman")) {
                return 1;
            } else if (input.equalsIgnoreCase("sophomore") || input.equalsIgnoreCase("junior") || input.equalsIgnoreCase("senior")) {
                return 2;
            } else {
                System.out.println("Invalid input. No points awarded.");
                return 0;
            }
        }

        // Checks if the user has been on probation before, and if so, if they are still on probation or have accommodations.
        // (Most of the checking is done in the main class.)
        private static boolean checkProbationStatus(String input) {
            return input.equalsIgnoreCase("yes");
        }
    }
}
