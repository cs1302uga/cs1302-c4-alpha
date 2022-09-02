package cs1302.game;

import java.util.Scanner;
import cs1302.gameutil.Token;

/**
 * A command-line program for testing {@link cs1302.game.ConnectFour}. Students should refer to
 * the <a href="https://github.com/cs1302uga/cs1302-c4-alpha">project description</a> for more
 * details about should be included in this class.
 */
public class ConnectFourDriver {

    /**
     * Entry point to the {@link cs1302.game.ConnectFourDriver} program. This program is not
     * expected to support command-line arguments.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        //
        // replace the entire contents of this method with your test code and/or
        // calls to other methods that help you test your code
        //
        throw new UnsupportedOperationException("main: not yet implemented");
    } // main

    //----------------------------------------------------------------------------------------------
    // TEST METHODS - You should add more methods to test your code under different scenarios.
    //----------------------------------------------------------------------------------------------

    /**
     * Test the constructor.
     */
    public static void testConstructor() {
        System.out.printf("%s\n%s\n%s\n", "-".repeat(80), "testConstructor", "-".repeat(80));
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
            System.out.println("PASS");
        } catch (IllegalArgumentException iae) {
            System.out.println("FAIL");
            System.out.println("- an IllegalArgumentException was thrown but not expected");
            System.out.println("  " + iae);
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
            System.out.println("PASS");
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
            System.out.println("PASS");
        } // try
    } // testConstructor3

} // ConnectFourDriver
