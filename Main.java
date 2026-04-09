import java.util.Scanner;
/**
 * @author Christian E. Anderson
 * @version 1.0
 * @since 2024-06-01
 * 
 * This program demonstrates how a simple student housing point system works.
 * 
 * It first informs the user how this program works,
 * then prompts the user to answer various questions. 
 * 
 * After each question is answered, the program will keep track of points.
 * After completing all questions, the program will output the total score.
 * 
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Thank you for applying for student housing!");
        System.out.println("This program will ask you various questions to determine your eligibility for housing.");
        System.out.println("Please answer each question honestly. (Type 'yes' to continue or 'no' to quit.)");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("no")) {
            System.out.println("Thank you for your time. Goodbye!");
            scanner.close();
            return;
        }
        System.out.println("You entered: " + input);
        scanner.close();
    }
}