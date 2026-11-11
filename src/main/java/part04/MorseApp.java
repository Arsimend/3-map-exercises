
package part04;

import java.util.Scanner;

/**
 * This is an extra class, which is not included in the grading of the
 * assignment. Feel free to complete this class or skip it entirely.
 *
 * See the MorseCode class for more information.
 */
public class MorseApp {

    public static void main(String... args) {
        MorseCode morseCode = new MorseCode();

        // TODO: implement this method as you see fit.
        // You can either translate from text to morse code or vice versa, or both.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Morse Code Translator");
        System.out.println("1. Text to Morse");
        System.out.println("2. Morse to Text");
        System.out.print("Choose 1 or 2: ");

        String choice = scanner.nextLine();

        if (choice.equals("1")) {

            System.out.print("Enter text: ");
            String text = scanner.nextLine();

            String result = morseCode.textToMorse(text);

            System.out.println("Morse code: " + result);

        } else if (choice.equals("2")) {

            System.out.print("Enter Morse code: ");
            String morse = scanner.nextLine();

            String result = morseCode.morseToText(morse);

            System.out.println("Text: " + result);

        } else {

            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
