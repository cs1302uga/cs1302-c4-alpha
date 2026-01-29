package cs1302.game;

import cs1302.gameutil.Token;
import cs1302.gameutil.GamePhase;

/**
 * A program to test the {@link cs1302.game.ConnectFour} implementation against
 * the specification that is mainly described through Javadoc comments.
 */
public class ConnectFourTester {

    /**
     * Entry point to the {@link cs1302.game.ConnectFourTester} program.
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {

        /* TODO: Students should add additional test methods to test individual
         * functions they implemented in ConnectFour class and call those test
         * methods from here.
         */

        /* Example test cases to test the constructor. You can uncomment the two
         * lines below and run these tests once you have completed the
         * constructor for the ConnectFour class.
         */

        // testConstructor01();
        // testConstructor02();
        // ...

        /* Example test cases to test gameplay cases. You can uncomment the two
         * lines below and run these tests once you have completed the
         * ConnectFour class.
         */

        // testGamePlayCase01();
        // testGamePlayCase02();
        // ...

        /* TODO: Students should add additional test methods to test different
         * gameplay cases and call those test methods from here. Be sure to
         * include methods to check various win scenarios from different
         * locations on the board.
         */

        // replaceWithYourTestMethod()
        // replaceWithYourTestMethod()
        // ...

        /* TODO: Identify duplicate code in test code and move them into
         * separate functions and reuse them to minimize redundancy.
         */

        /* NOTE: If the main method gets too long, refactor the code by grouping
         * the calls to your test methods into new methods with good names and
         * call those new methods instead. For example, you might create a
         * method called testGamePlay that calls all of your individual
         * testGamePlayNN methods, then simply call testGamePlay in main. A
         * siilar
         */

    } // main


    //----------------------------------------------------------------------------------------------
    // CONSTRUCTOR TESTS
    //----------------------------------------------------------------------------------------------

    /**
     * Make sure the constructor initializes the instance variables to their
     * expected values when a new {@link cs1302.game.ConnectFour} object is
     * created. The initial values for a 6-by-7 game should match up with what
     * is shown in the project description for the {@code GamePhase.NEW} game
     * phase. This test must is not setup to automatically fail, so be sure to
     * carefully check its output when run to determine whether it passes.
     *
     * @see <a href="https://cs1302book.com/projects/cs1302-c4-alpha/cs1302-c4-alpha-index.html#gamephase-new">
     *     Project Description: {@code GamePhase.NEW}
     * </a>
     * @see cs1302.gameutil.GamePhase#NEW
     */
    public static void testConstructor01() {

        System.out.println("[testConstructor01] [DISPLAY ONLY: MANUALLY CHECK TEST OUTPUT]");

        final int ROWS = 6;
        final int COLS = 7;

        System.out.printf("expect: this.rows = %d\n", ROWS);
        System.out.printf("expect: this.cols = %d\n", COLS);
        System.out.printf("expect: this.grid = %d-by-%d (2D) with null elements\n", ROWS, COLS);
        System.out.printf("expect: this.player = 1-by-%d (1D) with null elements\n", 2);
        System.out.printf("expect: this.numDropped = %d\n", 0);
        System.out.printf("expect: this.lastDropRow = %d\n", -1);
        System.out.printf("expect: this.lastDropCol = %d\n", -1);

         // Create a new game, then use the debug method provided in the starter
         // code to spot check it.
        ConnectFour game = new ConnectFour(ROWS, COLS);
        game.debug();

    } // testConstructor01

    /**
     * Make sure the constructor initializes the instance variables to their
     * expected values when a new {@link cs1302.game.ConnectFour} object is
     * created. The initial values for a 6-by-7 game should match up with what
     * is shown in the project description for the {@code GamePhase.NEW} game
     * phase. Unlike the first constructor test case, this one is setup to to
     * automatically fail fast on the first encounter of an unexpected value.
     * This test only work correctly if each getter method that is uses is also
     * implemented correctly.
     *
     * @see <a href="https://cs1302book.com/projects/cs1302-c4-alpha/cs1302-c4-alpha-index.html#gamephase-new">
     *     Project Description: {@code GamePhase.NEW}
     * </a>
     * @see cs1302.gameutil.GamePhase#NEW
     */
    public static void testConstructor02() {

        System.out.println("[testConstructor02]");

        final int ROWS = 6;
        final int COLS = 7;

        ConnectFour game = new ConnectFour(ROWS, COLS);

        // The helper methods that called below are declared near the end of this file.
        // TIP: In Emacs, use C-s to search for the method instead of manually scrolling down.

        checkGetRowsNoThrow(game, ROWS);
        checkGetColsNoThrow(game, COLS);

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                checkIsInBoundsNoThrow(game, row, col, true);
                checkGetTokenAtNoThrow(game, row, col, null);
            } // for
        } // for

        checkGetPlayerTokenThrowIllegalState(game);
        checkGetNumDroppedThrowIllegalState(game);
        checkGetLastDropRowThrowIllegalState(game);
        checkGetLastDropColThrowIllegalState(game);

        checkGetPhaseNoThrow(game, GamePhase.NEW);

        System.out.print("Pass: ");
        System.out.print("The constructor and getter methods look good!\n");

    } // testConstructor02

    //
    // ADDITIONAL CONSTRUCTOR TESTS CAN GO HERE
    //

    //----------------------------------------------------------------------------------------------
    // GAME PLAY TESTS
    //----------------------------------------------------------------------------------------------

    /**
     * When a player makes a connect four from their last dropped token,
     * isLastDropConnectFour should return true.
     */
    public static void testGamePlayCase01() {

        System.out.println("[testGamePlayCase01]");

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
        if (!game.isLastDropConnectFour()) {
            String message = "Fail: isLastDropConnectFour should return true"
                + " since player 0 made c4 in last drop.";
            throw new AssertionError(message);
        } // if

        if (game.getPhase() != GamePhase.OVER) {
            String message = "Fail: isLastDropConnectFour should set the game"
                + " phase to OVER.";
            throw new AssertionError(message);
        } // if

        System.out.print("Pass: ");
        System.out.print("isLastDropConnectFour returned true and ");
        System.out.print("game phase is set to OVER since player 0 made c4 in the last drop.\n");

    } // testGamePlayCase01

    /**
     * When a player makes a connect four from their last dropped token,
     * isLastDropConnectFour should return true.
     */
    public static void testGamePlayCase02() {

        System.out.println("[testGamePlayCase02]");

        ConnectFour game = new ConnectFour(6, 7);
        game.setPlayerTokens(Token.RED, Token.BLUE);
        game.dropToken(0, 0); // player 0 drops at col 0.
        game.dropToken(1, 1); // player 1 drops at col 1.
        game.dropToken(0, 1); // player 0 drops at col 1.
        game.dropToken(1, 2); // player 1 drops at col 2.
        game.dropToken(0, 2); // player 0 drops at col 2.
        game.dropToken(1, 3); // player 1 drops at col 3.
        game.dropToken(0, 2); // player 0 drops at col 2.
        game.dropToken(1, 3); // player 1 drops at col 3.
        game.dropToken(0, 3); // player 0 drops at col 3.
        game.dropToken(1, 6); // player 1 drops at col 6.
        game.dropToken(0, 3); // player 0 drops at col 3.

        // Player 0 made a connect four with the last drop.
        if (!game.isLastDropConnectFour()) {
            String message = "Fail: isLastDropConnectFour should return true"
                + " since player 0 made c4 in last drop.";
            throw new AssertionError(message);
        } // if

        if (game.getPhase() != GamePhase.OVER) {
            String message = "Fail: isLastDropConnectFour should set the game"
                + " phase to OVER.";
            throw new AssertionError(message);
        } // if

        System.out.print("Pass: ");
        System.out.print("isLastDropConnectFour returned true and ");
        System.out.print("game phase is set to OVER since player 0 made c4 in the last drop.\n");

    } // testGamePlayCase02

    //
    // ADDITIONAL GAME PLAY TESTS CAN GO HERE
    //

    //----------------------------------------------------------------------------------------------
    // OTHER TESTS
    //----------------------------------------------------------------------------------------------

    //
    // ADDITIONAL TESTS CAN GO HERE
    //

    //----------------------------------------------------------------------------------------------
    // HELPER METHODS FOR TESTS
    //----------------------------------------------------------------------------------------------

    /* NOTE: You may notice that there is a lot of repetitive code among the
     * various helper methods for tests that are included in the starter
     * code. Most of that repetitive code can be refactored using interfaces, a
     * topic that we will cover later, so that only two or three of these
     * methods are actually needed.
     */

    /**
     * Assert that {@code game.getRows()} returns the {@code expected} value.
     *
     * @param game The game to call the {@code getRows()} method on.
     * @param expected The expected return value of {@code getRows()}.
     */
    private static void checkGetRowsNoThrow(ConnectFour game, int expected) {

        try {

            int actual = game.getRows();

            if (actual != expected) {
                String assertionMessage = String.format(
                    "Fail: getRows() = %d, but %d expected",
                    actual,
                    expected
                );
                throw new AssertionError(assertionMessage);
            } else {
                System.out.printf("Pass: getRows() correctly returned %d\n", expected);
            } // if

        } catch (AssertionError assertionCause) {

            // Comunicate that one of our assertions about getRows() failed.
            throw assertionCause; // re-throw so we see it

        } catch (UnsupportedOperationException unsupportedCause) {

            // Remember, we typically throw UnsupportedOperationException to communicate that
            // a method is not yet implemented.
            String message = "Fail: getRows(): looks like it is not yet implemented";
            throw new AssertionError(message, unsupportedCause);

        } catch (Exception cause) {

            // This check assumes getRows() does not throw an exception.
            String message = String.format("Fail: getRows(): threw %s unexpectedly\n", cause);
            throw new AssertionError(message, cause);

        } // try

    } // checkGetRowsNoThrow

    /**
     * Assert that {@code game.getCols()} returns the {@code expected} value.
     *
     * @param game The game to call the {@code getCols()} method on.
     * @param expected The expected return value of {@code getCols()}.
     */
    private static void checkGetColsNoThrow(ConnectFour game, int expected) {

        try {

            int actual = game.getCols();

            if (actual != expected) {
                String assertionMessage = String.format(
                    "Fail: getCols() = %d, but %d expected",
                    actual,
                    expected
                );
                throw new AssertionError(assertionMessage);
            } else {
                System.out.printf("Pass: getCols() correctly returned %d\n", expected);
            } // if

        } catch (AssertionError assertionCause) {

            // Comunicate that one of our assertions about getCols() failed.
            throw assertionCause; // re-throw so we see it

        } catch (UnsupportedOperationException unsupportedCause) {

            // Remember, we typically throw UnsupportedOperationException to communicate that
            // a method is not yet implemented.
            String message = "Fail: getCols(): looks like it is not yet implemented";
            throw new AssertionError(message, unsupportedCause);

        } catch (Exception cause) {

            // This check assumes getCols() does not throw an exception.
            String message = String.format("Fail: getCols(): threw %s unexpectedly\n", cause);
            throw new AssertionError(message, cause);

        } // try

    } // checkGetColsNoThrow

    /**
     * Assert that {@code game.isInBounds(row, col)} returns the {@code expected} value.
     *
     * @param game The game to call the {@code isInBounds()} method on.
     * @param row The row to check.
     * @param col The column to check.
     * @param expected The expected return value of {@code isInBounds()}.
     */
    private static void checkIsInBoundsNoThrow(
        ConnectFour game, int row, int col, boolean expected
    ) {

        try {

            boolean actual = game.isInBounds(row, col);

            if (actual != expected) {
                String assertionMessage = String.format(
                    "Fail: isInBounds(%d, %d) = %s, but %s expected",
                    row,
                    col,
                    actual,
                    expected
                );
                throw new AssertionError(assertionMessage);
            } else {
                System.out.printf(
                    "Pass: isInBounds(%d, %d) correctly returned %s\n",
                    row,
                    col,
                    expected
                );
            } // if

        } catch (AssertionError assertionCause) {

            // Comunicate that one of our assertions about isInBounds() failed.
            throw assertionCause; // re-throw so we see it

        } catch (UnsupportedOperationException unsupportedCause) {

            // Remember, we typically throw UnsupportedOperationException to communicate that
            // a method is not yet implemented.
            String message = String.format(
                "Fail: isInBounds(%d, %d): looks like it is not yet implemented",
                row,
                col
            );
            throw new AssertionError(message, unsupportedCause);

        } catch (Exception cause) {

            // This check assumes isInBounds() does not throw an exception.
            String message = String.format(
                "Fail: isInBounds(%d, %d): threw %s unexpectedly\n",
                cause
            );
            throw new AssertionError(message, cause);

        } // try

    } // checkIsInBoundsNoThrow

    /**
     * Assert that {@code game.getTokenAt(row, col)} returns the {@code expected} value.
     *
     * @param game The game to call the {@code getTokenAt()} method on.
     * @param row The row to check.
     * @param col The column to check.
     * @param expected The expected return value of {@code getTokenAt()}.
     */
    private static void checkGetTokenAtNoThrow(ConnectFour game, int row, int col, Token expected) {

        try {

            Token actual = game.getTokenAt(row, col);

            if (actual != expected) {
                String assertionMessage = String.format(
                    "Fail: getTokenAt(%d, %d) = %s, but %s expected",
                    row,
                    col,
                    actual,
                    expected
                );
                throw new AssertionError(assertionMessage);
            } else {
                System.out.printf(
                    "Pass: getTokenAt(%d, %d) correctly returned %s\n",
                    row,
                    col,
                    expected
                );
            } // if

        } catch (AssertionError assertionCause) {

            // Comunicate that one of our assertions about getTokenAt() failed.
            throw assertionCause; // re-throw so we see it

        } catch (UnsupportedOperationException unsupportedCause) {

            // Remember, we typically throw UnsupportedOperationException to communicate that
            // a method is not yet implemented.
            String message = String.format(
                "Fail: getTokenAt(): looks like it is not yet implemented",
                row,
                col
            );
            throw new AssertionError(message, unsupportedCause);

        } catch (Exception cause) {

            // This check assumes getTokenAt() does not throw an exception.
            String message = String.format(
                "Fail: getTokenAt(%d, %d): threw %s unexpectedly\n",
                row,
                col,
                cause
            );
            throw new AssertionError(message, cause);

        } // try

    } // checkGetTokenAtNoThrow

    /**
     * Assert that calling both {@code game.getPlayerToken(0)} and {@code
     * game.getPlaterToken(1)} correctly throw an {@link IllegalStateException}.
     *
     * @param game The game to check.
     */
    private static void checkGetPlayerTokenThrowIllegalState(ConnectFour game) {

    } // checkGetPlayerTokenThrowIllegalState

    /**
     * Assert that {@code game.getNumDropped()} returns the {@code expected} value.
     *
     * @param game The game to call the {@code getNumDropped()} method on.
     * @param expected The expected return value of {@code getNumDropped()}.
     */
    private static void checkGetNumDroppedNoThrow(ConnectFour game, int expected) {

        try {

            int actual = game.getNumDropped();

            if (actual != expected) {
                String assertionMessage = String.format(
                    "Fail: getNumDropped() = %d, but %d expected",
                    actual,
                    expected
                );
                throw new AssertionError(assertionMessage);
            } else {
                System.out.printf("Pass: getNumDropped() correctly returned %d\n", expected);
            } // if

        } catch (AssertionError assertionCause) {

            // Comunicate that one of our assertions about getNumDropped() failed.
            throw assertionCause; // re-throw so we see it

        } catch (UnsupportedOperationException unsupportedCause) {

            // Remember, we typically throw UnsupportedOperationException to communicate that
            // a method is not yet implemented.
            String message = "Fail: getNumDropped(): looks like it is not yet implemented";
            throw new AssertionError(message, unsupportedCause);

        } catch (Exception cause) {

            // This check assumes getNumDropped() does not throw an exception.
            String message = String.format("Fail: getNumDropped(): threw %s unexpectedly\n", cause);
            throw new AssertionError(message, cause);

        } // try

    } // checkGetNumDroppedNoThrow

    /**
     * Assert that calling {@code game.getNumDropped()} throws an {@link
     * IllegalStateException}.
     *
     * @param game The game to check.
     */
    private static void checkGetNumDroppedThrowIllegalState(ConnectFour game) {

        try {

            int actual = game.getNumDropped();

            String message = String.format(
                "Fail: getNumDropped(): did not throw %s as expected.",
                "IllegalStateException"
            );
            throw new AssertionError(message);

        } catch (AssertionError assertionCause) {

            // Communicate that one of our assertions about getNumDropped() failed.
            throw assertionCause; // re-throw so we see it

        } catch (IllegalStateException illegalStateCause) {

            // Communicate that getNumDropped() threw the expected exception.
            System.out.print("Pass: getNumDropped(): ");
            System.out.print("correctly threw IllegalStateException\n");

        } catch (Exception otherCause) {

            // Communicate that getNumDropped() threw an unexpected exception.
            String message = String.format(
                "Fail: getNumDropped(): threw %s but %s expected.",
                otherCause,
                "IllegalStateException"
            );
            throw new AssertionError(message, otherCause);

        } // try

    } // checkGetNumDroppedThrowIllegalState

    /**
     * Assert that {@code game.getLastDropRow()} returns the {@code expected} value.
     *
     * @param game The game to call the {@code getLastDropRow()} method on.
     * @param expected The expected return value of {@code getLastDropRow()}.
     */
    private static void checkGetLastDropRowNoThrow(ConnectFour game, int expected) {

        try {

            int actual = game.getLastDropRow();

            if (actual != expected) {
                String assertionMessage = String.format(
                    "Fail: getLastDropRow() = %d, but %d expected",
                    actual,
                    expected
                );
                throw new AssertionError(assertionMessage);
            } else {
                System.out.printf("Pass: getLastDropRow() correctly returned %d\n", expected);
            } // if

        } catch (AssertionError assertionCause) {

            // Comunicate that one of our assertions about getLastDropRow() failed.
            throw assertionCause; // re-throw so we see it

        } catch (UnsupportedOperationException unsupportedCause) {

            // Remember, we typically throw UnsupportedOperationException to communicate that
            // a method is not yet implemented.
            String message = "Fail: getLastDropRow(): looks like it is not yet implemented";
            throw new AssertionError(message, unsupportedCause);

        } catch (Exception cause) {

            // This check assumes getLastDropRow() does not throw an exception.
            String message = String.format(
                "Fail: getLastDropRow(): threw %s unexpectedly\n",
                cause
            );
            throw new AssertionError(message, cause);

        } // try

    } // checkGetLastDropRowNoThrow

    /**
     * Assert that calling {@code game.getLastDropRow()} throws an {@link
     * IllegalStateException}.
     *
     * @param game The game to check.
     */
    private static void checkGetLastDropRowThrowIllegalState(ConnectFour game) {

        try {

            int actual = game.getLastDropRow();

            String message = String.format(
                "Fail: getLastDropRow(): did not throw %s as expected.",
                "IllegalStateException"
            );
            throw new AssertionError(message);

        } catch (AssertionError assertionCause) {

            // Communicate that one of our assertions about getLastDropRow() failed.
            throw assertionCause; // re-throw so we see it

        } catch (IllegalStateException illegalStateCause) {

            // Communicate that getLastDropRow() threw the expected exception.
            System.out.print("Pass: getLastDropRow(): ");
            System.out.print("correctly threw IllegalStateException\n");

        } catch (Exception otherCause) {

            // Communicate that getLastDropRow() threw an unexpected exception.
            String message = String.format(
                "Fail: getLastDropRow(): threw %s but %s expected.",
                otherCause,
                "IllegalStateException"
            );
            throw new AssertionError(message, otherCause);

        } // try

    } // checkGetLastDropRowThrowIllegalState

    /**
     * Assert that {@code game.getLastDropCol()} returns the {@code expected} value.
     *
     * @param game The game to call the {@code getLastDropCol()} method on.
     * @param expected The expected return value of {@code getLastDropCol()}.
     */
    private static void checkGetLastDropColNoThrow(ConnectFour game, int expected) {

        try {

            int actual = game.getLastDropCol();

            if (actual != expected) {
                String assertionMessage = String.format(
                    "Fail: getLastDropCol() = %d, but %d expected",
                    actual,
                    expected
                );
                throw new AssertionError(assertionMessage);
            } else {
                System.out.printf("Pass: getLastDropCol() correctly returned %d\n", expected);
            } // if

        } catch (AssertionError assertionCause) {

            // Comunicate that one of our assertions about getLastDropCol() failed.
            throw assertionCause; // re-throw so we see it

        } catch (UnsupportedOperationException unsupportedCause) {

            // Remember, we typically throw UnsupportedOperationException to communicate that
            // a method is not yet implemented.
            String message = "Fail: getLastDropCol(): looks like it is not yet implemented";
            throw new AssertionError(message, unsupportedCause);

        } catch (Exception cause) {

            // This check assumes getLastDropCol() does not throw an exception.
            String message = String.format(
                "Fail: getLastDropCol(): threw %s unexpectedly\n",
                cause
            );
            throw new AssertionError(message, cause);

        } // try

    } // checkGetLastDropColNoThrow

    /**
     * Assert that calling {@code game.getLastDropCol()} throws an {@link
     * IllegalStateException}.
     *
     * @param game The game to check.
     */
    private static void checkGetLastDropColThrowIllegalState(ConnectFour game) {

        try {

            int actual = game.getLastDropCol();

            String message = String.format(
                "Fail: getLastDropCol(): did not throw %s as expected.",
                "IllegalStateException"
            );
            throw new AssertionError(message);

        } catch (AssertionError assertionCause) {

            // Communicate that one of our assertions about getLastDropCol() failed.
            throw assertionCause; // re-throw so we see it

        } catch (IllegalStateException illegalStateCause) {

            // Communicate that getLastDropCol() threw the expected exception.
            System.out.print("Pass: getLastDropCol(): ");
            System.out.print("correctly threw IllegalStateException\n");

        } catch (Exception otherCause) {

            // Communicate that getLastDropCol() threw an unexpected exception.
            String message = String.format(
                "Fail: getLastDropCol(): threw %s but %s expected.",
                otherCause,
                "IllegalStateException"
            );
            throw new AssertionError(message, otherCause);

        } // try

    } // checkGetLastDropColThrowIllegalState

    /**
     * Assert that {@code game.getPhase()} returns the {@code expected} value.
     *
     * @param game The game to call the {@code getPhase()} method on.
     * @param expected The expected return value of {@code getPhase()}.
     */
    private static void checkGetPhaseNoThrow(ConnectFour game, GamePhase expected) {

        try {

            GamePhase actual = game.getPhase();

            if (actual != expected) {
                String assertionMessage = String.format(
                    "Fail: getPhase() = %s, but %s expected",
                    actual,
                    expected
                );
                throw new AssertionError(assertionMessage);
            } else {
                System.out.printf("Pass: getPhase() correctly returned %s\n", expected);
            } // if

        } catch (AssertionError assertionCause) {

            // Comunicate that one of our assertions about getPhase() failed.
            throw assertionCause; // re-throw so we see it

        } catch (UnsupportedOperationException unsupportedCause) {

            // Remember, we typically throw UnsupportedOperationException to communicate that
            // a method is not yet implemented.
            String message = "Fail: getPhase(): looks like it is not yet implemented";
            throw new AssertionError(message, unsupportedCause);

        } catch (Exception cause) {

            // This check assumes getPhase() does not throw an exception.
            String message = String.format("Fail: getPhase(): threw %s unexpectedly\n", cause);
            throw new AssertionError(message, cause);

        } // try

    } // checkGetPhaseNoThrow

    //
    // ADDITIONAL HELPER METHODS FOR TESTS CAN GO HERE
    //

} // ConnectFourTester
