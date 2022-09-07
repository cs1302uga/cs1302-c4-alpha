package cs1302.game;

import java.util.Scanner;
import cs1302.gameutil.Token;

/**
 * A command-line program for {@link cs1302.game.ConnectFour}.
 *
 * <p>
 * <strong>NOTE:</strong> If you are implementing this class, then you should not manually
 * create {@link java.util.Scanner} objects for {@link java.lang.System#in} to get user input.
 * Instead, you should use the {@link #getInputLine()} to get user input one line at a time. If
 * more than piece of information is contained in the string returned by {@code getInputLine()},
 * then you should create a {@code Scanner} object for that string specifically
 * (not {@code System.in}) as illustrated in the example below:
 *
 * <pre>
 * String line = ConnectFourDriver.getInputLine(); // get line of user input
 * Scanner lineScanner = new Scanner(line);        // create scanner for that line
 * int row = lineScanner.nextInt();                // get first piece of information
 * int col = lineScanner.nextInt();                // get second piece of information
 * if (lineScanner.hasNext()) {                    // detect additional input on the line
 *     System.out.println("the line has more input!");
 * } // if
 * </pre>
 */
public class ConnectFourDriver {

    /**
     * <strong>DO NOT MODIFY:</strong>
     * The {@link java.util.Scanner} object for standard input.
     *
     * <p>
     * <strong>NOTE:</strong> This constant should not be modified! The {@link #getInputLine()}
     * method depends on the value of this static constant being set when the class is loaded
     * by Java.
     */
    public static final Scanner INPUT_SCANNER = new Scanner(System.in);

    /**
     * <strong>DO NOT MODIFY:</strong>
     * Return the next line available from standard input. This method is used by the program
     * whenever input is needed from a user. If standard input is redirected, then this method
     * will return immediately. If standard input is not redirected, then this method will
     * wait for the user to type a line of text, then return the line after the user presses
     * the return key.
     *
     * <p>
     * <strong>NOTE:</strong> This method should not be modified!
     *
     * @return the next line available from standard input
     * @throws java.util.NoSuchElementException if no line was found on standard input. This might
     *   happen if standard input is redirected to a file and all the lines in the file have already
     *   read.
     * @throws IllegalStateException if {@link #INPUT_SCANNER} is closed
     */
    public static String getInputLine() {
        return INPUT_SCANNER.nextLine().trim();
    } // getInputLine

    /**
     * Entry point to the {@link cs1302.game.ConnectFourDriver} program. This program supports
     * command-line arguments.
     *
     * <p>
     * For now, you should use this method to help you test your implementation of the
     * {@link cs1302.game.ConnectFour} class. You may be asked to modify this method
     * with something more specif at a later date. Some example test code is provided
     * in the project description.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        //
        // replace the entire contents of this method with your test code and/or
        // calls to other methods that help you test your code
        //
        throw new UnsupportedOperationException("ConnectFourDriver.main: not yet implemented");
    } // main

} // ConnectFourDriver
