package cs1302.game;

import cs1302.gameutil.GamePhase;
import cs1302.gameutil.Token;
import cs1302.gameutil.TokenGrid;

/**
 * {@code ConnectFour} represents a two-player connection game involving a two-dimensional grid of
 * {@linkplain cs1302.gameutil.Token tokens}. When a {@code ConnectFour} game object is
 * constructed, several instance variables representing the game's state are initialized and
 * subsequently accessible, either directly or indirectly, via "getter" methods. Over time, the
 * values assigned to these instance variables should change so that they always reflect the
 * latest information about the state of the game. Most of these changes are described in the
 * project's <a href="https://github.com/cs1302uga/cs1302-c4-alpha#functional-requirements">
 * functional requirements</a>.
 */
public class ConnectFour {

    //----------------------------------------------------------------------------------------------
    // INSTANCE VARIABLES: You should NOT modify the instance variable declarations below.
    // You should also NOT add any additional instance variables. Static variables should
    // also NOT be added.
    //----------------------------------------------------------------------------------------------

    private int rows;        // number of grid rows
    private int cols;        // number of grid columns
    private Token[][] grid;  // 2D array of tokens in the grid
    private Token[] player;  // 1D array of player tokens (length 2)
    private int numDropped;  // number of tokens dropped so far
    private int lastDropRow; // row index of the most recent drop
    private int lastDropCol; // column index of the most recent drop
    private GamePhase phase; // current game phase

    //----------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------------------------------------------------------

    /**
     * Constructs a {@link cs1302.game.ConnectFour} game with a grid that has {@code rows}-many
     * rows and {@code cols}-many columns. All of the game's instance variables are expected to
     * be initialized by this constructor as described in the project's
     * <a href="https://github.com/cs1302uga/cs1302-c4-alpha#functional-requirements">functional
     * requirements</a>.
     *
     * @param rows the number of grid rows
     * @param cols the number of grid columns
     * @throws IllegalArgumentException if the value supplied for {@code rows} or {@code cols} is
     *     not supported. The following values are supported: {@code 6 <= rows <= 9} and
     *     {@code 7 <= cols <= 9}.
     */
    public ConnectFour(int rows, int cols)  {
        //
        // replace the entire contents of this constructor with your implementation
        //
        //throw new UnsupportedOperationException("constructor: not yet implemented.");
    } // ConnectFour

    //----------------------------------------------------------------------------------------------
    // INSTANCE METHODS
    //----------------------------------------------------------------------------------------------

    /**
     * Return the number of rows in the game's grid.
     *
     * @return the number of rows
     */
    public int getRows() {
        //
        // replace the entire contents of this method with your implementation
        //
        throw new UnsupportedOperationException("getRows: not yet implemented.");
    } // getRows

    /**
     * Return the number of columns in the game's grid.
     *
     * @return the number of columns
     */
    public int getCols() {
        //
        // replace the entire contents of this method with your implementation
        //
        throw new UnsupportedOperationException("getCols: not yet implemented.");
    } // getCols

    /**
     * Return whether {@code row} and {@code col} specify a location inside this game's grid.
     *
     * @param row the position's row index
     * @param col the position's column index
     * @return {@code true} if {@code row} and {@code col} specify a location inside this game's
     *     grid and {@code false} otherwise
     */
    public boolean isInBounds(int row, int col) {
        //
        // replace the entire contents of this method with your implementation
        //
        throw new UnsupportedOperationException("isInBounds: not yet implemented.");
    } // isInBounds

    /**
     * Return the grid {@linkplain cs1302.gameutil.Token token} located at the specified position
     * or {@code null} if no token has been dropped into that position.
     *
     * @param row the token's row index
     * @param col the token's column index
     * @return the grid token located in row {@code row} and column {@code col}, if it exists;
     *     otherwise, the value {@code null}
     * @throws IndexOutOfBoundsException if {@code row} and {@code col} specify a position that is
     *     not inside this game's grid.
     */
    public Token getTokenAt(int row, int col) {
        //
        // replace the entire contents of this method with your implementation
        //
        throw new UnsupportedOperationException("getTokenAt: not yet implemented.");
    } // getTokenAt

    /**
     * Set the first player token and second player token to {@code token0} and {@code token1},
     * respectively. If the current game phase is {@link cs1302.gameutil.GamePhase#NEW}, then
     * this method changes the game phase to {@link cs1302.gameutil.GamePhase#READY}, but only
     * if no exceptions are thrown.
     *.
     * @param token0 token for first player
     * @param token1 token for second player
     * @throws NullPointerException if {@code token0} or {@code token1} is {@code null}.
     * @throws IllegalArgumentException if {@code token0 == token1}.
     * @throws IllegalStateException if {@link #getPhase getPhase()} returns
     *     {@link cs1302.gameutil.GamePhase#PLAYABLE} or {@link cs1302.gameutil.GamePhase#OVER}.
     */
    public void setPlayerTokens(Token token0, Token token1) {
        //
        // replace the entire contents of this method with your implementation
        //
        throw new UnsupportedOperationException("setPlayerTokens: not yet implemented.");
    } // setPlayerTokens

    /**
     * Return a player's token.
     *
     * @param player the player ({@code 0} for first player and {@code 1} for second player)
     * @return the token for the specified player
     * @throws IllegalArgumentException if {@code player} is neither {@code 0} nor {@code 1}
     * @throws IllegalStateException if {@link #getPhase getPhase()} returns
     *     {@link cs1302.gameutil.GamePhase#NEW}.
     */
    public Token getPlayerToken(int player) {
        //
        // replace the entire contents of this method with your implementation
        //
        throw new UnsupportedOperationException("getPlayerToken: not yet implemented.");
    } // getPlayerToken

    /**
     * Return the number of tokens that have been dropped into this game's grid so far.
     *
     * @return the number of dropped tokens
     * @throws IllegalStateException if {@link #getPhase getPhase()} returns
     *     {@link cs1302.gameutil.GamePhase#NEW} or {@link cs1302.gameutil.GamePhase#READY}.
     */
    public int getNumDropped() {
        //
        // replace the entire contents of this method with your implementation
        //
        throw new UnsupportedOperationException("getNumDropped: not yet implemented.");
    } // getNumDropped

    /**
     * Return the row index of the last (i.e., the most recent) token dropped into this
     * game's grid.
     *
     * @return the row index of the last drop
     * @throws IllegalStateException if {@link #getPhase getPhase()} returns
     *     {@link cs1302.gameutil.GamePhase#NEW} or {@link cs1302.gameutil.GamePhase#READY}.
     */
    public int getLastDropRow() {
        //
        // replace the entire contents of this method with your implementation
        //
        throw new UnsupportedOperationException("getLastDropRow: not yet implemented.");
    } // getLastDropRow

    /**
     * Return the col index of the last (i.e., the most recent) token dropped into this
     * game's grid.
     *
     * @return the column index of the last drop
     * @throws IllegalStateException if {@link #getPhase getPhase()} returns
     *     {@link cs1302.gameutil.GamePhase#NEW} or {@link cs1302.gameutil.GamePhase#READY}.
     */
    public int getLastDropCol() {
        //
        // replace the entire contents of this method with your implementation
        //
        throw new UnsupportedOperationException("getLastDropCol: not yet implemented.");
    } // getLastDropCol

    /**
     * Return the current game phase.
     *
     * @return current game phase
     */
    public GamePhase getPhase() {
        //
        // replace the entire contents of this method with your implementation
        //
        throw new UnsupportedOperationException("getPhase: not yet implemented.");
    } // getPhase

    /**
     * Drop a player's token into a specific column in the grid. This method should not enforce turn
     * order -- that is the players' responsibility should they desire an polite and honest game.
     *
     * @param player the player ({@code 0} for first player and {@code 1} for second player)
     * @param col the grid column where the token will be dropped
     * @throws IndexOutOfBoundsException if {@code col} is not a valid column index
     * @throws IllegalArgumentException if {@code player} is neither {@code 0} nor {@code 1}
     * @throws IllegalStateException if {@link #getPhase getPhase()} does not return
     *    {@link cs1302.gameutil.GamePhase#READY} or {@link cs1302.gameutil.GamePhase#PLAYABLE}
     * @throws IllegalStateException if the specified column in the grid is full
     */
    public void dropToken(int player, int col) {
        //
        // replace the entire contents of this method with your implementation
        //
        throw new UnsupportedOperationException("dropToken: not yet implemented.");
    } // dropToken

    /**
     * Return true if the specified player has won the game.
     *
     * @param player the player
     * @return {@code true} is the player has won the game, else {@code false}
     * @throws IllegalArgumentException if {@code player} is neither {@code 0} nor {@code 1}
     */
    public boolean isWinner(int player) {
        //
        // replace the entire contents of this method with your implementation
        //
        throw new UnsupportedOperationException("isWinner: not yet implemented.");
    } // isWinner

    //----------------------------------------------------------------------------------------------
    // ADDITIONAL METHODS: If you create any additional methods, then they should be placed in the
    // space provided below.
    //----------------------------------------------------------------------------------------------




    //----------------------------------------------------------------------------------------------
    // DO NOT MODIFY THE METHODS BELOW!
    //----------------------------------------------------------------------------------------------

    /**
     * <strong>DO NOT MODIFY:</strong>
     * Print the game grid to standard output. This method assumes that the constructor
     * is implemented correctly.
     *
     * <p>
     * <strong>NOTE:</strong> This method should not be modified!
     */
    public void printGrid() {
        TokenGrid.println(this.grid);
    } // printGrid

    /**
     * <strong>DO NOT MODIFY:</strong>
     * Construct a {@link cs1302.game.ConnectFour} game object from the description provided in the
     * the specified file. This method assumes the following about the contents of the file:
     *
     * 1) the first two entries in the file denote the {@code rows} and {@code cols} that should be
     *    passed into the {@link cs1302.game.ConnectFour} constructor;
     * 2) the next two entries denote the token names for the first and second player;
     * 3) if present, the next {@code (rows * cols + 2)}-many entries specify the contents of the
     *    grid and the location of the last drop -- of these, the first {@code (rows * cols)}-many
     *    entries denote the grid and the last two entries denote the row and column index of the
     *    last drop.
     *
     * The descriptions are assumed to be always be valid. If the game is won, then it must due to
     * the last drop.
     *
     * <p> Here is an example of what the contents of a valid file might look like for a game with a
     * 6-by-7 grid:
     *
     * <pre>
     * 6 7 RED BLUE
     * 3 3 3 3 3 3 3
     * 3 3 3 3 3 3 3
     * 3 3 0 3 3 3 3
     * 3 3 0 3 3 3 3
     * 1 3 0 3 3 3 3
     * 0 1 0 1 1 3 3
     * 2 2
     * </pre>
     *
     * <p>
     * <strong>NOTE:</strong> This method should not be modified!
     *
     * @param filename path to a file describing a game
     * @return game object constructed from the file
     * @throws java.io.FileNotFoundException if the specified file cannot be found
     */
    public static ConnectFour fromFile(String filename) throws java.io.FileNotFoundException {
        java.io.File file = new java.io.File(filename);
        java.util.Scanner fileScanner = new java.util.Scanner(file);
        // first two entries in file specify the grid size
        int rows = fileScanner.nextInt();
        int cols = fileScanner.nextInt();
        // next two entries are the player's token names
        Token token0 = Token.valueOf(fileScanner.next());
        Token token1 = Token.valueOf(fileScanner.next());
        // construct the game object and set the player tokens
        ConnectFour game = new ConnectFour(rows, cols);
        game.setPlayerTokens(token0, token1);
        if (fileScanner.hasNext()) {
            // next (rows * cols)-many entries denote the grid
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = 0; col < cols; col++) {
                    int player = fileScanner.nextInt();
                    if (player != 3) {
                        game.dropToken(player, col);
                    } // if
                } // for
            } // for
            // last two entries denote the position of the latest drop
            game.lastDropRow = fileScanner.nextInt();
            game.lastDropCol = fileScanner.nextInt();
            // trigger phase change if game is won or full
            game.isWinner(0);
            game.isWinner(1);
        } // if
        return game;
    } // fromFile

} // ConnectFour
