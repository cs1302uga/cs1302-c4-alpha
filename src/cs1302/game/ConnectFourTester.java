package cs1302.game;

import java.util.Scanner;
import cs1302.gameutil.Token;
import cs1302.gameutil.GamePhase;

/**
 * A command-line program for testing {@link cs1302.game.ConnectFour}. Students should refer to
 * the <a href="https://github.com/cs1302uga/cs1302-c4-alpha">project description</a> for more
 * details about what should be included in this class.
 */
public class ConnectFourTester {

    private static int CONSTRUCTOR_POINTS = 2;
    private static int GETROWS_POINTS = 2;
    private static int GETCOLS_POINTS = 2;
    private static int OTHER_POINTS = 2;

    // These variables are used in some of the test methods to store what
    // the values of each variable should be when returned from a valid
    // game object. In other words, they hold the "right answer". What you
    // see here are default values. They are modified, as needed, throughout
    // this tester.
    private static int numDropped =    0;
    private static int lastDropCol =  -1;
    private static int lastDropRow =  -1;
    private static boolean isWon = false;

    // The total points earned by the student.
    private static int totalPoints = 0;

    /**
     * Print a nice header with the supplied {@code title}.
     *
     * @param title the title to include in the header
     */
    private static void header(String title) {
        System.out.printf("%s\n%s\n%s\n", "-".repeat(80), title, "-".repeat(80));
    } // header

    /**
     * Entry point to the {@link cs1302.game.ConnectFourTester} program. This program is not
     * expected to support command-line arguments.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        // To see information about the test methods that are run below, refer
        // to the documentation comments.
        testConstructor();
        testGetRows();
        testGetCols();
        testIsInBounds();
        testGamePlay();
        testFullBoard();
        testNoStatic();
        System.out.println("Total Points Earned: " + totalPoints);
    } // main

    //----------------------------------------------------------------------------------------------
    // TEST METHODS - Each provided test is separated with a heading like this one.
    // Each test requires multiple, separate methods. Pay close attention to these dependencies.
    // You should add more methods to test your code under different scenarios.
    //----------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------
    // TEST CONSTRUCTOR
    //----------------------------------------------------------------------------------------------

    /**
     * Test the constructor. This runs several test cases.
     */
    public static void testConstructor() {
        header("testConstructor");
        testConstructor1();
        testConstructor2();
        testConstructor3();
    } // testConstructor

    /**
     * Constructor test: the constructor should not throw an
     * {@link java.lang.IllegalArgumentException} when {@code rows} and {@code cols} are supported.
     */
    public static void testConstructor1() {
        System.out.print("testConstructor1: ");
        try {
            ConnectFour game = new ConnectFour(6, 7);
            pass("testConstructor1", CONSTRUCTOR_POINTS);
        } catch (IllegalArgumentException iae) {
            exceptionNotExpected(iae);
        } // try
    } // testConstructor1

    /**
     * Constructor test: the constructor should throw an
     * {@link java.lang.IllegalArgumentException} when {@code rows} is too small.
     */
    public static void testConstructor2() {
        System.out.print("testConstructor2: ");
        try {
            ConnectFour game = new ConnectFour(5, 7);
            System.out.println("FAIL");
            System.out.println("- an IllegalArgumentException was expected but not thrown");
        } catch (IllegalArgumentException iae) {
            pass("testConstructor2", CONSTRUCTOR_POINTS);
        } // try
    } // testConstructor2

    /**
     * Constructor test: the constructor should throw an
     * {@link java.lang.IllegalArgumentException} when {@code rows} is too big.
     */
    public static void testConstructor3() {
        System.out.print("testConstructor3: ");
        try {
            ConnectFour game = new ConnectFour(10, 7);
            System.out.println("FAIL");
            System.out.println("- an IllegalArgumentException was expected but not thrown");
        } catch (IllegalArgumentException iae) {
            pass("testConstructor3", CONSTRUCTOR_POINTS);
        } // try
    } // testConstructor3

    // Recommendation to students: Add a textConstructor4 and testConstructor5 method that makes
    // sure the constructor throws an IllegalArgumentException when cols is too small and too
    // big, respectively.

    //----------------------------------------------------------------------------------------------
    // TEST getRows
    //----------------------------------------------------------------------------------------------

    /**
     * Test the {@code getRows} method.
     */
    public static void testGetRows() {
        header("testGetRows");
        testGetRows(7);
        testGetRows(8);
        testGetRows(9);
    } // testGetRows

    /**
     * GetRows test: the {@code getRows} method should return the proper row value
     * after a game is constructed. Tests on a square board with dimensions:
     * {@code size} x {@code size}.
     *
     * @param size the size of the game used in the test.
     */
    public static void testGetRows(int size) {
        System.out.print("testGetRows: ");
        ConnectFour game = newValidGame(size, size);
        if (game != null) {
            if (game.getRows() == size) {
                pass("testGetRows", GETROWS_POINTS);
            } else {
                String message =
                    String.format("getRows returned %d on a board " +
                                  "of size %dx%d", game.getRows(), size, size);
                fail(message);
            } // if
        } // if
    } // testGetRows

    //----------------------------------------------------------------------------------------------
    // TEST getCols
    //----------------------------------------------------------------------------------------------

    /**
     * Test the {@code getCols} method.
     */
    public static void testGetCols() {
        header("testGetCols");
        testGetCols(7);
        testGetCols(8);
        testGetCols(9);
    } // testGetCols

    /**
     * GetCols test: the {@code getCols} method should return the proper row value
     * after a game is constructed.
     *
     * @param size the size of the board.
     */
    public static void testGetCols(int size) {
        System.out.print("testGetCols: ");
        ConnectFour game = newValidGame(size, size);
        if (game != null) {
            if (game.getCols() == size) {
                pass("testGetCols", GETCOLS_POINTS);
            } else {
                String message = String.format("getCols returned %d on a board " +
                                               "of size %dx%d", game.getCols(), size, size);
                fail(message);
            } // if
        } // if
    } // testGetCols

    //----------------------------------------------------------------------------------------------
    // TEST isInBounds
    //----------------------------------------------------------------------------------------------

    /**
     * Test the {@code getIsInBounds} method.
     */
    public static void testIsInBounds() {
        header("testIsInBounds");
        testIsInBounds1(6, 9);
        testIsInBounds1(7, 8);
        testIsInBounds1(8, 8);
        testIsInBounds1(8, 7);
        testIsInBounds2(6, 9);
        testIsInBounds2(7, 8);
        testIsInBounds2(8, 8);
        testIsInBounds2(8, 7);
    } // testIsInBounds

    /**
     * isInBounds Test: The method tests negative values for the row and column
     * number. Fails if either {@code rows} or {@code cols} are invalid.
     *
     * @param rows the number of rows in the game board.
     * @param cols the number of columns in the game board.
     */
    public static void testIsInBounds1(int rows, int cols) {
        ConnectFour game = newValidGame(rows, cols);
        if (game != null) {
            if (game.isInBounds(-1, cols - 1)) {
                String message = String.format("isInBounds returned true for a row " +
                                               "input of -1 on an %dx%d board", rows, cols);
                fail(message);
            } else {
                pass("testIsInBounds1", OTHER_POINTS);
            } // if
            if (game.isInBounds(rows - 1, -1)) {
                String message = String.format("isInBounds returned true for a col " +
                                               "input of -1 on an %dx%d board", rows, cols);
                fail(message);
            } else {
                pass("testIsInBounds1", OTHER_POINTS);
            } // if
        } // if
    } // testIsInBounds1

    /**
     * isInBounds Test 2: The method tests to see if the game correctly handles
     * values that fall out of bounds by exactly 1 index. For example, if the
     * game has 6 rows, the method will ensure that 6 is considered out of bounds.
     *
     * @param rows the number of rows in the game board.
     * @param cols the number of columns in the game board.
     */
    public static void testIsInBounds2(int rows, int cols) {
        ConnectFour game = newValidGame(rows, cols);
        if (game != null) {
            if (game.isInBounds(rows - 1, cols)) {
                String message = String.format("isInBounds returned true for a col " +
                                               "input of %d on an %dx%d board", cols, rows, cols);
                fail(message);
            } else {
                pass("testIsInBounds2", OTHER_POINTS);
            } // if
            if (game.isInBounds(rows, cols - 1)) {
                String message = String.format("isInBounds returned true for a row " +
                                               "input of %d on an %dx%d board", rows, rows, cols);
                fail(message);
            } else {
                pass("testIsInBounds2", OTHER_POINTS);
            } // if
        } // if
    } // testIsInBounds2

    //----------------------------------------------------------------------------------------------
    // TEST GAMEPLAY
    //----------------------------------------------------------------------------------------------

    /**
     * Test the overall game play on a 7x9 board. Students should write similar
     * methods to test other board sizes. This method runs through a
     * full game from object construction to a winning game.
     * If an issue arises, the method prints a descriptive message and returns.
     */
    public static void testGamePlay() {
        final int rowCount = 7;
        final int colCount = 9;

        header("testGamePlay");
        ConnectFour game = newValidGame(rowCount, colCount);

        boolean newGameTest = testNewGame(game);
        if (!newGameTest) {
            // new game test failed
            return;
        } // if

        // Recommendation to students: Add a call to drop token before player tokens
        // are set. Think about the expected behavior and properly test this scenario.

        boolean readyGameTest = testReadyGame(game);
        if (!readyGameTest) {
            // ready game test failed
            return;
        } // if

        // Recommendation to students: Test invalid drops here. Try passing an illegal
        // player number and try dropping a token in a column that is out of bounds.

        // These three variables hold the answers. They will be used to compare the
        // values returned from the game object in the testDrop method.
        lastDropCol = 0;
        numDropped = 1;
        isWon = false;

        int player = 0;
        lastDropRow = rowCount - 1;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                // With this drop pattern, takes 28 drops to win.
                if (numDropped == 28) {
                    isWon = true;
                } // if

                // game should throw an exception if we drop a token after game over.
                if (numDropped == 29) {
                    testGameOver(game);
                    return;
                } // if

                lastDropCol = j;

                if (!testDrop(game, player, j)) {
                    return;
                } // if
                player = (player + 1) % 2;
                numDropped++;
            } // for
            // Goes up by one after each row is full
            lastDropRow--;
        } // for

    } // testSetPlayerTokens

    /**
     * Checks that the specified {@code game} is properly set to
     * {@link cs1302.gameutil.GamePhase#OVER}. This method expects a game
     * that either contains a connect four or is full without a winner. If given
     * a proper game, it checks to make sure the phase is set properly and
     * that additional tokens cannot be dropped.
     *
     * @param game the game to check.
     */
    private static void testGameOver(ConnectFour game) {
        if (game.getPhase() != GamePhase.OVER) {
            fail("testGameOver: game phase should be set to OVER when the game is over.");
        } else {
            pass("testGameOver: game properly set to OVER when the game ended.",
                 OTHER_POINTS);
        } // if

        try {
            game.dropToken(0, 0);
            fail("testGameOver: game should not allow a token to drop after the game is over");
        } catch (IllegalStateException ise) {
            pass("testGameOver: throws IllegalStateException when token dropped after game over.",
                  OTHER_POINTS);
        } // try
    } // testGameOver

    /**
     * Attempts to call methods on a new game to ensure that the proper exceptions are
     * thrown. Specifically, tests {@code getLastDropRow}, {@code getLastDropCol}, and
     * {@code getNumDropped}.
     *
     * @param game the Connect Four game to test.
     * @return {@code true} if the tests pass and {@code false} otherwise.
     */
    private static boolean testNewGame(ConnectFour game) {
        try {
            game.getLastDropRow();
            fail("getLastDropRow should throw an IllegalStateException " +
                 "if called on a game in the NEW phase");
            return false;
        } catch (IllegalStateException iae) {
            pass("getLastDropRow properly threw an IllegalStateException " +
                 "when called on a game in the NEW phase", OTHER_POINTS);
        } // try

        try {
            game.getLastDropCol();
            fail("getLastDropCol should throw an IllegalStateException " +
                 "if called on a game in the NEW phase");
            return false;
        } catch (IllegalStateException iae) {
            pass("getLastDropCol properly threw an IllegalStateException " +
                 "when called on a game in the NEW phase", OTHER_POINTS);
        } // try

        try {
            game.getNumDropped();
            fail("getNumDropped should throw an IllegalStateException " +
                 "if called on a game in the NEW phase");
            return false;
        } catch (IllegalStateException iae) {
            pass("getNumDropped properly threw an IllegalStateException " +
                 "when called on a game in the NEW phase", OTHER_POINTS);
        } // try
        return true;
    } // testNewGame

    /**
     * Attempts to call methods on a ready game to ensure that the proper exceptions are
     * thrown. Specifically, tests {@code getLastDropRow}, {@code getLastDropCol}, and
     * {@code getNumDropped}. The method sets the player tokens of the {@code game} to
     * red and blue. This test fails if the provided {@code game} is not in
     * the {@link cs1302.gameutil.GamePhase#NEW} phase.
     *
     * @param game the Connect Four game to test.
     * @return {@code true} if the tests pass and {@code false} otherwise.
     */
    public static boolean testReadyGame(ConnectFour game) {
        if (game.getPhase() != GamePhase.NEW) {
            return false;
        } // if
        game.setPlayerTokens(Token.RED, Token.BLUE);

        if (game.getPhase() == GamePhase.READY) {
            pass("GamePhase set to ready after tokens set.", OTHER_POINTS);
        } else {
            fail("GamePhase should be set to " +
                 " ready after call to setPlayerTokens");
            return false;
        } // if

        try {
            game.getLastDropRow();
            fail("getLastDropRow should throw an IllegalStateException " +
                 "if called on a game in the READY phase");
            return false;
        } catch (IllegalStateException iae) {
            pass("getLastDropRow properly threw an IllegalStateException " +
                 "when called on a game in the READY phase", OTHER_POINTS);
        } // try

        try {
            game.getLastDropCol();
            fail("getLastDropCol should throw an IllegalStateException " +
                 "if called on a game in the READY phase");
            return false;
        } catch (IllegalStateException iae) {
            pass("getLastDropCol properly threw an IllegalStateException " +
                 "when called on a game in the READY phase");
        } // try

        try {
            game.getNumDropped();
            fail("getNumDropped should throw an IllegalStateException " +
                 "if called on a game in the READY phase");
            return false;
        } catch (IllegalStateException iae) {
            pass("getNumDropped properly threw an IllegalStateException " +
                 "when called on a game in the READY phase", OTHER_POINTS);
        } // try
        return true;
    } // testReadyGame

    /**
     * Drops a token in the given {@code game} in the specified {@code dropCol}. This
     * method tests various aspects of the game after the token is dropped. Specifically,
     * it checks that lastDropRow, lastDropCol, and numDropped are set correctly and
     * whether or not the dropped token led to a win for the player.
     *
     * @return {@code true} if all tests pass and {@code false} otherwise.
     * @param game a reference to the Connect Four game.
     * @param player the player dropping the token.
     * @param dropCol the column where the token will be dropped.
     */
    private static boolean testDrop(ConnectFour game, int player, int dropCol) {
        // drop player token in the specified column.
        try {
            game.dropToken(player, dropCol);
        } catch (Throwable t) {
            String message = String.format("dropToken threw an exception when " +
                                           "a token was dropped into valid column %d\n",
                                           dropCol);
            fail(message, game);
            t.printStackTrace();
            return false;
        } // try

        // Check the game state after calling dropToken
        boolean variableCheck = checkVariables(game);
        if (!variableCheck) {
            return false;
        } // if

        Token lastToken = game.getTokenAt(game.getLastDropRow(), game.getLastDropCol());
        if (lastToken == game.getPlayerToken(player)) {
            pass("getTokenAt correctly returned the last dropped token");
        } else {
            String message = String.format("FAIL: getTokenAt incorrectly returned %s after " +
                                           "token dropped in column %d", lastToken,
                                           lastDropCol);

            System.out.println(message);
            return false;
        } // if

        if (game.isLastDropConnectFour() == isWon) {
            if (!isWon) {
                pass("isLastDropConnectFour correctly says game is " +
                     "not yet won.", OTHER_POINTS);
            } else {
                pass("isLastDropConnectFour correctly says game is won.", OTHER_POINTS);
            } // if
        } else {
            fail("isLastDropConnectFour gave the wrong answer.", game);
            return false;
        } // if
        return true;
    } // testDrop

    /**
     * Checks the game state after a call to {@code dropToken}. Specifically,
     * tests {@code gamePhase}, {@code getLastDropRow}, {@code getLastDropCol},
     * and {@code getNumDropped}. This test fails if the provided {@code game} is not in
     * the {@link cs1302.gameutil.GamePhase#PLAYABLE} phase.
     *
     * @param game the Connect Four game to test.
     * @return {@code true} if the tests pass and {@code false} otherwise.
     */
    private static boolean checkVariables(ConnectFour game) {
        // Check game phase
        if (game.getPhase() != GamePhase.PLAYABLE) {
            fail("game phase should be PLAYABLE after a token is dropped.");
            return false;
        } else {
            pass("game phase is PLAYABLE after a token is dropped.", OTHER_POINTS);
        } // if

        // test drop row and drop col
        if (lastDropRow == game.getLastDropRow()) {
            String message = String.format("last drop row correctly set to %d after " +
                                           "token dropped in column %d", lastDropRow,
                                           lastDropCol);
            pass(message, OTHER_POINTS);
        } else {
            String message = String.format("last drop row incorrectly set to %d after " +
                                           "token dropped in column %d", game.getLastDropRow()
                                           , lastDropCol);
            fail(message, game);
            return false;

        } // if
        if (lastDropCol == game.getLastDropCol()) {
            String message = String.format("last drop col correctly set to %d after " +
                                           "token dropped in column %d", lastDropCol,
                                           lastDropCol);
            pass(message, OTHER_POINTS);
        } else {
            String message = String.format("last drop col incorrectly set to %d after " +
                                           "token dropped in column %d", game.getLastDropCol()
                                           , lastDropCol);
            fail(message, game);
            return false;
        } // if

        // test getNumDropped
        if (numDropped == game.getNumDropped()) {
            String message = String.format("numDropped correctly set to %d after " +
                                           "token dropped in column %d", numDropped,
                                           lastDropCol);
            pass(message, OTHER_POINTS);
        } else {
            String message = String.format("numDropped incorrectly set to %d after " +
                                           "token dropped in column %d", game.getNumDropped(),
                                           lastDropCol);
            fail(message, game);
            return false;
        } // if
        return true;
    } // checkVariables

    //----------------------------------------------------------------------------------------------
    // TEST NO STATIC
    //----------------------------------------------------------------------------------------------
    /**
     * Verifies that the instance variables of the class are not static. Does this by creating
     * two games, modifying one, and making sure the change didn't impact the second game.
     */
    public static void testNoStatic() {
        header("test for static");
        ConnectFour game1 = newValidGame(6, 7);
        ConnectFour game2 = newValidGame(6, 7);

        game1.setPlayerTokens(Token.RED, Token.BLUE);
        game2.setPlayerTokens(Token.RED, Token.BLUE);

        // Drops a token in column 0. It's location will be (5, 0).
        game1.dropToken(0, 0);

        // Get the token at (5,0) from both boards. They should not be equal.
        Token g1Token = game1.getTokenAt(5, 0);
        Token g2Token = game2.getTokenAt(5, 0);

        if (g1Token == g2Token) {
            fail("testNoStatic: values in the boards should not be equal.");
        } else {
            pass("testNoStatic: values in the boards are different.", OTHER_POINTS);
        } // if

    } // testNoStatic

    //----------------------------------------------------------------------------------------------
    // TEST FULL BOARD
    //----------------------------------------------------------------------------------------------
    /**
     * Creates a new game and fills it with tokens such that no winner is present. This
     * tests that the game properly ends when the board fills with no winner.
     *
     */
    public static void testFullBoard() {
        int player = 0;
        int rows = 6;
        int cols = 8;
        ConnectFour game = newValidGame(rows, cols);

        game.setPlayerTokens(Token.RED, Token.BLUE);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                game.dropToken(player, j);
                if (!game.isLastDropConnectFour()) {
                    pass("testFullBoard: isLastDropConnectFour correctly says game is " +
                         "not yet won.", OTHER_POINTS);
                } else {
                    fail("testFullBoard: isLastDropConnectFour incorrectly says game is won", game);
                    return;
                } // if
                player = (player + 1) % 2;
            } // for
            if ((i + 1) % 3 == 0) {
                player = (player + 1) % 2;
            } // if
        } // for

        if (!game.isLastDropConnectFour()) {
            pass("testFullBoard: isLastDropConnectFour correctly says game is " +
                 "not yet won.", OTHER_POINTS);
        } else {
            fail("testFullBoard: isLastDropConnectFour incorrectly says game is won", game);
            return;
        } // if

        // At this point, the board should be full with no winner present.
        testGameOver(game);

    } // testFullBoard

    /**
     * Returns a new {@code ConnectFour} object if {@code rows} and {@code cols} are valid.
     * Otherwise, the method returns {@code null}.
     *
     * @param rows the number of rows in the new game.
     * @param cols the number of columns in the new game.
     * @return a new {@code ConnectFour} object if {@code rows} and {@code cols} are valid
     * and {@code null} otherwise.
     */
    private static ConnectFour newValidGame(int rows, int cols) {
        ConnectFour game = null;
        try {
            game = new ConnectFour(rows, cols);
            return game;
        } catch (IllegalArgumentException iae) {
            exceptionNotExpected(iae);
        } catch (Throwable t) {
            exceptionNotExpected(t);
        } // try
        return game;
    } // newGame

    /**
     * Prints a message to indicate that an exception was thrown but not expected.
     *
     * @param t a reference to exception object generated.
     */
    private static void exceptionNotExpected(Throwable t) {
        fail("an Exception was thrown but not expected");
        System.out.println("  " + t);
        t.printStackTrace();
    } // exceptionNotExpected

    /**
     * Prints a message to indicate that a test was passed. The method prints
     * "PASS" followed by the provided message.
     *
     * @param message the message to print.
     */
    private static void pass(String message) {
        System.out.println("PASS: " + message);
    } // pass

    /**
     * Prints a message to indicate that a test was passed. The method prints
     * "PASS" followed by the provided message along with the points earned for
     * passing the test.
     *
     * @param message the message to print.
     * @param points the points earned for this test.
     */
    private static void pass(String message, int points) {
        System.out.println("PASS: " + message);
        System.out.println("Points earned: " + points);
        totalPoints += points;
    } // pass

    /**
     * Prints a message to indicate that a test was failed. The method prints
     * "FAIL" followed by the provided message, then aborts any remaining
     * tests. If {@code game} is not {@code null}, then this method attempts
     * to print the game grid.
     *
     * @param message the message to print.
     * @param game a {@code ConnectFour} game object.
     */
    private static void fail(String message, ConnectFour game) {
        System.out.println("FAIL");
        System.out.println("- " + message);
        if (game != null) {
            System.out.println();
            game.printGrid();
        } // if
        System.out.println();
        System.out.println("ABORTING REMAINING TESTS: You should fix this test failure");
        System.out.println("to see any remaining test cases.");
        System.exit(1);
    } // fail

    /**
     * Prints a message to indicate that a test was failed. The method prints
     * "FAIL" followed by the provided message, then aborts any remaing tests.
     *
     * @param message the message to print.
     */
    private static void fail(String message) {
        fail(message, null);
    } // fail

} // ConnectFourTester
