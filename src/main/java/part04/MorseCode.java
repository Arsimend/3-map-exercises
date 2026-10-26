package part04;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This is an extra class, which is not included in the grading of the
 * assignment. Feel free to complete this class or skip it entirely. If you
 * decide to complete it, you can use the MorseCodeTest class to test your
 * implementation. You can also create complete the MorseApp class, which uses
 * this class to translate between morse code and text.
 *
 * Based on Wikipedia, "Morse code is a method used in telecommunication to
 * encode text characters as standardized sequences of two different signal
 * durations, called dots and dashes, or dits and dahs"
 * (https://en.wikipedia.org/wiki/Morse_code).
 *
 * In this class, the morse code is represented as a string of dots (.) and
 * dashes (-). Characters are separated by a single space and words are
 * separated by three spaces.
 *
 * Your task is to implement the methods morseToText and textToMorse, which
 * translate between "normal" text and morse code. In the textToMorse method,
 * the input text can contain any characters, including special characters. You
 * only need to implement translation for the upper and lower case letters a-z
 * and the numbers 0-9.
 *
 * The mapping between characters and morse code can be found online, and is not
 * included in this assignment. You can use a Map to store the morse codes and
 * their corresponding characters.
 */
public class MorseCode {

    private final String codeChart = """
            A .-
            B -...
            C -.-.
            D -..
            E .
            F ..-.
            G --.
            H ....
            I ..
            J .---
            K -.-
            L .-..
            M --
            N -.
            O ---
            P .--.
            Q --.-
            R .-.
            S ...
            T -
            U ..-
            V ...-
            W .--
            X -..-
            Y -.--
            Z --..
            0 -----
            1 .----
            2 ..---
            3 ...--
            4 ....-
            5 .....
            6 -....
            7 --...
            8 ---..
            9 ----.
            """;

    // KAKSI MAPPIA, JOISSA KUKIN MERKKI PYSTYTAAN KAANTAMAAN
    // MORSESTA CLEAR TEKSTIKSI JA TOISINPAIN
    private final Map<String, String> morseToChar = null; //morseToText(codeChart);
    private final Map<String, String> charToMorse = null; //textToMorse(morseToChar);

    /**
     * Translates a string of morse code to text. The morse code is represented as
     * dots (.) and dashes (-). Characters are separated by a single space and words
     * are separated by three spaces. Characters a-z and 0-9 are supported.
     *
     * For example, ".... . .-.. .-.. --- .-- --- .-. .-.. -.." translates to
     * "hello world".
     *
     * @param morse the morse code to translate
     * @return the translated text (in lower case)
     */
    public String morseToText(String morse) {
        String[] words = morse.split("   ");
        List<String> translatedWords = new ArrayList<>();
        for(String w : words) {
            String[] morseCodes = w.split(" ");
            String word = "";
            for (String code : morseCodes) {
                word += morseToChar.getOrDefault(code, "?");
            }
            translatedWords.add(word);

        }
        return String.join(" ", translatedWords).toLowerCase();
    }

    public String textToMorse(String text) {

        return null;
    }



    /**
     * Translates a string of text to morse code. The morse code is represented as
     * dots (.) and dashes (-). Characters are separated by a single space and words
     * are separated by three spaces.
     *
     * Upper and lower case letters a-z and numbers 0-9 are supported. Other
     * characters are ignored.
     *
     * For example, "Hello World" translates to
     * ".... . .-.. .-.. --- .-- --- .-. .-.. -..".
     *
     * @param text the text to translate
     * @return the translated morse code as a single string
     */

}
