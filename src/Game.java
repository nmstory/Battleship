/**
 * Class for handling the core aspects of the battleship game.
 *
 * This includes the main turn-based functionality and checking when someone has won.
 *
 * @author Nathan Story
 * @version 1.0
 * @since 17-06-2020
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    // Defining global variables
    private String playerOneName;
    private String playerTwoName;
    private Player playerOne;
    private Player playerTwo;
    private ArrayList<Player> players = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    /**
     * Default Constructor for the Game class.
     *
     * Here, I've used the constructor as a way to create both players, and decide who goes first.
     * @throws InterruptedException - If a problem arises with the Thread.sleep() in setShips()
     */
    public Game() throws InterruptedException {

        /* Introductory Text Formatting */
        System.out.print("\033[H\033[2J");
        System.out.println("***************************");
        System.out.println("** WELCOME TO BATTLESHIP **");
        System.out.println("***************************");
        System.out.println("\nCreated by: Nathan Story");
        System.out.println("\nPlease visit: https://github.com/nmstory for licensing and more of my work");
        System.out.println("***************************");

        /* Creating Player One */
        System.out.println("\nWhat is the name of the first player?");
        playerOneName = sc.nextLine();
        playerOne = new Player(playerOneName);
        System.out.print("\033[H\033[2J");

        /* Creating Player Two */
        System.out.println("What is the name of the second player?");
        Scanner sc2 = new Scanner(System.in);
        playerTwoName = sc2.nextLine();
        playerTwo = new Player(playerTwoName);
        System.out.print("\033[H\033[2J");

        /* Randomize who plays first by selecting a random number, and adding each player
         *  to the list of players in that order */
        Random random = new Random();
        int value = random.nextInt(10);
        System.out.println("***************************");
        if (value >= 5) {
            System.out.println(playerOneName + " plays first!\n");
            players.add(playerOne);
            players.add(playerTwo);
        } else {
            System.out.println(playerTwoName + " plays first!\n");
            players.add(playerTwo);
            players.add(playerOne);
        }
        waitFor3Seconds();
    }

    /**
     * Primary method for the Game class
     * <p>
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
                    break;
                }
                waitFor3Seconds();
            }
        }
    }

    /**
     * An auxiliary function to the play method.
     *
     * Round defines the blueprint of each turn; whereby:
     * 1. Player selects a row to be hit on the enemies grid
     * 2. Player selects a column to be hit on the enemies grid
     * 3. Program determines whether the spot can be hit using the canBeHit function (checking if its already been hit)
     * 4. If canBeHit returns true, then we hit that spot on the opponents grid and proceeds to break out of the hit loop
     * 5. If canBeHit returns false, we alert the user and with hit still false, we return to step 1
     *
     * @param player - The player of who's turn it is
     */
    private void round(Player player) {
        boolean hit = false;


        String showPlayersGrid = (player.equals(playerOne)) ? playerOne.playersGridToString() : playerTwo.playersGridToString();
        System.out.println("Your current grid: \n" + showPlayersGrid + "\n");

        String showEnemiesGrid = (player.equals(playerOne)) ? playerTwo.hiddenGridToString() : playerOne.hiddenGridToString();
        System.out.println("The grid your attacking currently looks like: \n" + showEnemiesGrid + "\n");

        while (!hit) {
            System.out.println(player.getName() + ", please select the row you'd like to hit");
            int rowHit = sc.nextInt();

            System.out.println(player.getName() + ", please select the column you'd like to hit");
            int columnHit = sc.nextInt();

            if (player.equals(playerOne)) { // If the player is playerOne, then we're hitting the grid of playerTwo
                if (playerTwo.canBeHit(columnHit, rowHit)) {
                    playerTwo.hitSpot(columnHit, rowHit);
                    playerTwo.unhideSpot(rowHit, columnHit);
                    hit = true;

                } else {
                    System.out.println("NOT DO-ABLE MATEY");
                }
            } else { // Else the player is playerTwo, and we're hitting the grid of playerOne
                if (playerOne.canBeHit(columnHit, rowHit)) {
                    playerOne.hitSpot(columnHit, rowHit);
                    playerOne.unhideSpot(rowHit, columnHit);
                    hit = true;
                } else {
                    System.out.println("Unfortunately that grid spot has already been played, please try again");
                }
            }
        }
        String showEnemiesGrid2 = (player.equals(playerOne)) ? playerTwo.hiddenGridToString() : playerOne.hiddenGridToString();
        System.out.println("\nYour enemies grid now looks like: \n" + showEnemiesGrid2 + "\n");
    }

    /**
     * Auxiliary function for the play method, that determines whether the current Grid of a player means that they've
     * won the game.
     * <p>
     * For efficiency, the function returns true as soon as it finds just 1 unhit occupied GridSpot on the opponents grid.
     *
     * @param player - The player who's Grid is being checked
     * @return - true/false whether the player has won or not yet
     */
    private boolean finished(Player player) {

        if (player.equals(playerOne)) {
            if (playerTwo.checkForOccupiedSpots()) {
                return false;
            }
        }

        if (player.equals(playerTwo)) {
            if (playerOne.checkForOccupiedSpots()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Used when switching between players. An announcement is printed into the terminal, followed by a 3 second sleep,
     * then clears the terminal so the current players doesnt see the previous players grid.
     */
    public void waitFor3Seconds() {
        System.out.println("Switching Players in 3 seconds...");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); }

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
