package cs1302.game;

import cs1302.gameutil.Token;
import cs1302.gameutil.GamePhase;

/**
 * A program to test the ConnectFour implementation against the specification
 * that is mainly described through JavaDoc comments.
 */
public class ConnectFourTester {

    /**
     * Calls test cases that test the functionality of the {@code ConnectFour} constructor.
     */
    private void runConstructorTests() {
        // Provided example test cases:
        testSupportedConstructorCallGridSize6x7();
        testUnsupportedConstructorCallGridSize5x7();

        // TODO: Students will add more test methods to ensure that other board
        // sizes work as expected and call those methods from here.

    } // runConstructorTests

    /**
     * Calls test cases that test the functionality of the {@code getRows} method of
     * {@code ConnectFour}.
     */
    private void runGetRowsTests() {
        // Provided example test case:
        testGetRowsForGridSize7x7();

        // TODO: Students will add more test methods to ensure that other board sizes
        // work as expected and call those methods from here.

    } // runGetRowsTests

    private void runIsInBoundsTests() {
        // Provided example test case:
        testIsInBoundsRowNeg1Col8WhenGridSize6x9();

        // TODO: Students will add more test methods to test that the isInBounds method
        // returns the proper value under various board sizes and row/col inputs.

    } // runIsInBoundsTests

    public static void main(String[] args) {
        // Note: The guidelines provided in this tester code does not contain all cases
        // you should cover during testing. It is your responsibility to think about
        // other cases and test them to make sure that your program work as expected.

        runConstructorTests();

        runGetRowsTests();

        // TODO: Students will add a method to test the getCols method and call various
        // test methods from within that method.
        // runGetColsTests(); // -- This method must be implemented by students.

        runIsInBoundsTests();

        // TODO: Students will add a method to test the setPlayerTokens method.
        // Add test case functions to test setPlayerTokens when
        //   different token parameters are provided. Include test cases to
        //   test providing valid tokens, null tokens, tokens with equal value.
        //   In each case verify the game phase after the call to
        //   setPlayerTokens.
        // runSetPlayerTokensTests(); // -- This method must be implemented by students.

        // Test cases to test getPlayerToken method.
        // Todo: Add test case functions to test getPlayerToken for
        //   different player numbers. Test both valid and invalid player numbers.
        //   Do the tests before and after calling setPlayerTokens method.

        // Test cases to test getNumDropped method.
        testGetNumDroppedWhenGamePhaseIsNew();
        testGetNumDroppedWhenGamePhaseIsReady();
        // Todo: Add more test case functions to test getNumDropped after dropping
        //    different counts of tokens.

        // Test cases to test getLastDropRow method.
        // Todo:  Add test case functions to test getLastDropRow function
        //   for different game phases. Also, drop tokens at different positions
        //   and test if the function returns the correct value.

        // Test cases to test getLastDropCol method.
        // Todo:  Add test case functions to test getLastDropCol function
        //   for different game phases. Also, drop tokens at different positions
        //   and test if the function returns the correct value.

        // Test cases to test dropToken method.
        testDropTokenOutOfBoundsColNeg1();
        // Todo: Add more test case functions to test dropToken function
        //   for different valid and invalid columns, valid and invalid
        //   player ids, valid and invalid game states, columns that are
        //   full and not full. Also, test if dropping a token for the first
        //   time changes the game phase to PLAYABLE.

        // Test cases to test isLastDropConnectFour method.
        testLastDropConnectFourCase01();
        // Todo: Add more test case functions to test isLastDropConnectFour function
        //   by simulating different game plays. Also, test if isLastDropConnectFour
        //   change the game phase to OVER if the last drop makes the grid full or
        //   if the last drop makes a connect four.

        // Todo: Identify duplicate code in test code and move them into
        // separate functions and reuse them to minimize redundancy.
    }

    /**
     * Test if the ConnectFour constructor succeed without throwing an IllegalArgumentException exception
     * when the constructor arguments are within the bounds.
     */
    public static void testSupportedConstructorCallGridSize6x7() {
        try {
            ConnectFour game = new ConnectFour(6, 7);
            // If the program reaches here, that means the object initialization
            //   was successful.
            System.out.println("Pass: Constructing a ConnectFour object with grid size 6x7.");
        } catch (IllegalArgumentException ex) {
            throw new AssertionError("Exception is not expected.");
        } // try
    }

    /**
     * Tests if ConnectFour constructor throws an IllegalArgumentException when the
     * constructor arguments are not within the bounds.
     */
    public static void testUnsupportedConstructorCallGridSize5x7() {
        try {
            ConnectFour game = new ConnectFour(5, 7);
            // If the program reaches here, that means the constructor
            //   did not throw and exception.
            throw new AssertionError("Fail: IllegalArgumentException is expected but not thrown.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Pass: Constructor threw IllegalArgumentException for unsupported grid size 5x7.");
        } // try
    }

    /**
     * Test if getRows method returns the correct number of rows.
     */
    public static void testGetRowsForGridSize7x7() {
        ConnectFour game = new ConnectFour(7, 7);
        if (game.getRows() == 7) {
            System.out.println("Pass: getRows returned 7 when the grid size is 7x7.");
        } else {
            throw new AssertionError("Fail: getRows should return 7 when the grid size is 7x7.");
        }
    }

    /**
     * Tests if isInBounds returns false when the row and the column
     * provided as parameters is out of bounds.
     */
    public static void testIsInBoundsRowNeg1Col8WhenGridSize6x9() {
        ConnectFour game = new ConnectFour(6, 9);
        if (game.isInBounds(-1, 8) == false) {
            System.out.println("Pass: isInBounds returned false when for (-1, 8) when grid size is 6x9.");
        } else {
            throw new AssertionError("Fail: isInBounds should return false for (-1, 8) when grid size is 6x9");
        }
    }

    /**
     * Test if getNumDropped throws IllegalStateException when the game
     * phase is not valid.
     */
    public static void testGetNumDroppedWhenGamePhaseIsNew() {
        ConnectFour game = new ConnectFour(6, 7);
        try {
            int num = game.getNumDropped();
            throw new AssertionError("Fail: getNumDropped should throw IllegalStateException if phase is NEW.");
        } catch (IllegalStateException ex ) {
            System.out.println("Pass: getNumDropped threw IllegalStateException when phase is NEW.");
        }
    }

    /**
     * Test if getNumDropped throws IllegalStateException when the game
     * phase is not valid.
     */
    public static void testGetNumDroppedWhenGamePhaseIsReady() {
        ConnectFour game = new ConnectFour(6, 7);
        game.setPlayerTokens(Token.RED, Token.BLUE);
        try {
            int num = game.getNumDropped();
            throw new AssertionError("Fail: getNumDropped should throw IllegalStateException if phase is READY.");
        } catch (IllegalStateException ex ) {
            System.out.println("Pass: getNumDropped threw IllegalStateException when phase is READY.");
        }
    }

    /**
     * Test if dropping a token at an invalid column throws an IndexOutOfBoundsException.
     */
    public static void testDropTokenOutOfBoundsColNeg1() {
        ConnectFour game = new ConnectFour(6, 7);
        game.setPlayerTokens(Token.RED, Token.BLUE);
        try {
            game.dropToken(0, -1);
            throw new AssertionError("Fail: dropToken should throw IndexOutOfBoundsException when the column is invalid.");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Pass: dropToken threw and IndexOutOfBoundsException.");
        }
    }

    /**
     * When a player makes a connect four from their last dropped token, isLastDropConnectFour
     * should return true;
     */
    public static void testLastDropConnectFourCase01() {
        ConnectFour game = new ConnectFour(6, 7);
        game.setPlayerTokens(Token.RED, Token.BLUE);
        game.dropToken(0, 0); // player 0 drops at col 0.
        game.dropToken(1, 1); // player 1 drops at col 1.
        game.dropToken(0, 0); // player 0 drops at col 0.
        game.dropToken(1, 1); // player 1 drops at col 1.
        game.dropToken(0, 0); // player 0 drops at col 0.
        game.dropToken(1, 1); // player 1 drops at col 1.
        game.dropToken(0, 0); // player 0 drops at col 0.
        // Player 0 made a connect four with the last drop.
        if (game.isLastDropConnectFour()) {
            System.out.println("Pass: isLastDropConnectFour returned true since player 0 made c4 in last drop.");
        } else {
            throw new AssertionError("Fail: isLastDropConnectFour should return true since player 0 made c4 in last drop.");
        }
    }

} // ConnectFourTester
