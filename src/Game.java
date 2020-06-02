/**
 * private variables in all files?
 * blurb at the top of the file
 * no magic numbers
 * only importing the individual methods required
 * comment comment comment
 * catching errors ie enter number in boolean/not entering true/false
 */

import javafx.print.PageLayout;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game implements IGame {

    Scanner sc = new Scanner(System.in);
    String playerOneName;
    String playerTwoName;
    Player playerOne;
    Player playerTwo;
    ArrayList<Player> players = new ArrayList<>();

    //Defining constants
    /**
     * Max size of grid - NEEDS NEW DEFINITION
     **/
    private static int MAX_SIZE = 8;

    /**
     * Default Constructor for the Game class.
     *
     * Here, I've used the constructor as a way to create both players, and decide who goes first.
     */
    public Game() {

        System.out.println("WELCOME TO BATTLESHIP\n");

        /** Creating Player One **/
        System.out.println("What is the name of the first player?");
        playerOneName = sc.nextLine();
        playerOne = new Player(playerOneName);
        System.out.println(printGrid(playerOne)); //todo test line

        /** Creating Player Two **/
        System.out.println("What is the name of the second player?");
        Scanner sc2 = new Scanner(System.in);
        playerTwoName = sc2.nextLine();
        playerTwo = new Player(playerTwoName);
        System.out.println(printGrid(playerTwo)); //todo test line


        /** Randomize who plays first by selecting a random number, and adding each player
         *  to the list of players in that order **/
        Random random = new Random();
        int value = random.nextInt(10);
        if (value >= 5) {
            System.out.println(playerOneName + " plays first!");
            players.add(playerOne);
            players.add(playerTwo);
        } else {
            System.out.println(playerTwoName + " plays first!");
            players.add(playerTwo);
            players.add(playerOne);
        }
    }

    /**
     * Primary method for the Game class
     *
     * This contains the for loop that iterates through the list of players, giving each one a turn until
     * a player has won
     */
    public void play() {
        boolean inPlay = true;

        while (inPlay) {
            for (Player p : players) {
                round(p);

                if (finished(p)) { // Calling an auxiliary function to determine whether a player has won
                    inPlay = false;
                    break; }
            }
        }
    }

    /**
     * An auxiliary function to the play method.
     *
     * Round defines the blueprint of each turn; whereby:
     *  1. Player selects a row to be hit
     *  2. Player selects a column to be hit
     *  3. Program determines whether the spot can be hit using the canBeHit function
     *  4. If it can, then hits that spot on the opponents grid and proceeds to break out of the hit loop
     *  5. If the spot can't be hit, state's that fact and loops back to point 1
     *
     * @param player - The player of who's turn it is
     */
    private void round(Player player) {
        boolean hit = false;

        while (!hit) {
            System.out.println(player.getName() + ", please select the row you'd like to hit");
            int rowHit = sc.nextInt();

            System.out.println(player.getName() + ", please select the column you'd like to hit");
            int columnHit = sc.nextInt();

            if (player.equals(playerOne)) { // If the player is playerOne, then we're hitting the grid of playerTwo
                if (playerTwo.canBeHit(columnHit, rowHit)) {
                    playerTwo.hitSpot(columnHit, rowHit);
                    hit = true;

                    /**test code**/
                    System.out.println("Enemies grid:");
                    System.out.println(playerTwo.toString());

                } else {
                    System.out.println("NOT DO-ABLE MATEY"); }
            }

            else { // Else the player is playerTwo, and we're hitting the grid of playerOne
                if (playerOne.canBeHit(columnHit, rowHit)) {
                    playerOne.hitSpot(columnHit, rowHit);
                    hit = true;

                    /**test code**/
                    System.out.println("Enemies grid:");
                    System.out.println(playerOne.toString());
                } else {
                    System.out.println("NOT DO-ABLE MATEY"); }
            }
        }
    }

    /**
     * Auxiliary function for the play method, that determines whether the current Grid of a player means that they've
     * won the game.
     *
     * For efficiency, the function returns true as soon as it finds just 1 unhit occupied GridSpot on the opponents grid.
     *
     * @param player - The player who's Grid is being checked
     * @return - true/false whether the player has won or not yet
     */
    private boolean finished(Player player) {

        if (player.equals(playerOne)) {
            if (playerTwo.checkForOccupiedSpots()) {
                return false; }
        }

        if (player.equals(playerTwo)) {
            if (playerOne.checkForOccupiedSpots()) {
                return false; }
        }
        return true;
    }

    /**
     *
     * @param player - The Grid of the Player you wish to display
     * @return - String containing the Grid of Player
     */
    public String printGrid(Player player) {
        return player.toString();
    }

}
