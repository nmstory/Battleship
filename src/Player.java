/**
 * Class for representing a Player, including their Grid and the one that the enemies attacks.
 *
 * @author Nathan Story
 * @version 1.0
 * @since 17-06-2020
 */

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Player {

    // Defining constants
    private static int MAX_SIZE = 8;
    private static int CARRIER_SHIP_SIZE = 5;
    private static int BATTLESHIP_SHIP_SIZE = 4;
    private static int CRUISER_SHIP_SIZE = 3;
    private static int SUBMARINE_SHIP_SIZE = 3;
    private static int PATROL_SHIP_SIZE = 2;

    // Creating variables for Player
    private String playerName;
    private Grid personalBattleshipGrid = new Grid();
    private Grid enemiesBattleshipGrid = new Grid();
    private boolean clearSpots = true;
    private Scanner sc = new Scanner(System.in);

    int row;
    int column;
    boolean rotation;

    /**
     * Default constructor for the class Player
     * <p>
     * This assigns the name of the Player, creates its 5 ships using the setShips method and hides the grid that the
     * opponent will see
     *
     * @param name - Name of this Player
     */
    public Player(String name) throws InterruptedException {
        this.playerName = name;

        setShips(CARRIER_SHIP_SIZE, "Carrier");
        setShips(BATTLESHIP_SHIP_SIZE, "Battleship");
        setShips(CRUISER_SHIP_SIZE, "Cruiser");
        setShips(SUBMARINE_SHIP_SIZE, "Submarine");
        setShips(PATROL_SHIP_SIZE, "Patrol");

        enemiesBattleshipGrid.setAllHidden();
    }

    /**
     * @return - Name of the player
     */
    public String getName() {
        return playerName;
    }

    /**
     * Method for understanding where the Player wishes to place each ship, then handling that request
     *
     * @param shipSize - Size of the ship being placed
     * @param shipName - Name of the ship being placed
     * @throws InterruptedException - If a problem arises with the Thread.sleep()
     */
    public void setShips(int shipSize, String shipName) throws InterruptedException{
        clearSpots = true;

        while (clearSpots) {
            System.out.print("\033[H\033[2J");
            /* Displaying current grid */
            System.out.println("Your current grid:\n" + personalBattleshipGrid.toString());

            /* Requesting the location of the carrier ship on the 8x8 grid */
            System.out.println("\n" + playerName + ", please state the row of the " + shipSize + " width " + shipName + " ship (1-8)");
            //int row = sc.nextInt();
            try{row = sc.nextInt();}
            catch(InputMismatchException e) {
                System.out.println("Invalid Input");
                sc.next();
                Thread.sleep(3000);
                continue;
            }

            System.out.println("\n" + playerName + ", please state the column of the " + shipSize + " width " + shipName + " ship (1-8)");
            try{column = sc.nextInt();}
            catch(InputMismatchException e) {
                System.out.print("Invalid Input");
                sc.next();
                Thread.sleep(3000);
                continue;
            }

            System.out.println("\nRotation of the ship on the grid? (true = vertical, false = horizontal)");
            try{rotation = sc.nextBoolean();}
            catch(InputMismatchException e){
                System.out.print("Invalid Input");
                sc.next();
                Thread.sleep(3000);
                continue;
            }

            /*
             * Checking that the ship will fit within the grid.
             * If it doesn't, then the user is asked for a new location.
             */
            try {
                personalBattleshipGrid.checkSpots(row, column, shipSize, rotation);
            } catch (NoSuchElementException e) {
                System.out.println("Unfortunately, at least one of the gridSpots is out of the box, please try again");
                clearSpots = true;
            }

            /*
             * Checking that there are no other ships currently on those grid spots.
             * If there are, then the user is asked for a new location.
             */
            if (!personalBattleshipGrid.checkSpots(row, column, shipSize, rotation)) {
                clearSpots = false;
                personalBattleshipGrid.occupySpots(row, column, shipSize, rotation);
                enemiesBattleshipGrid.occupySpots(row, column, shipSize, rotation);
            } else {
                System.out.println("Unfortunately, at least one of the gridSpots is already occupied by another ship, please choose again");
            }
        }
    }

    /**
     * Method for hitting a spot on the Players Grid
     *
     * @param row    - row of the selected hit
     * @param column - column of the selected hit
     */
    public void hitSpot(int row, int column) {
        personalBattleshipGrid.hitSpot(row, column);
    }

    /**
     * Method for revealing a hidden spot after a player has hit the gridSpot
     *
     * @param row    - row of the gridSpot to be revealed
     * @param column - column of the gridSpot to be revealed
     */
    public void unhideSpot(int row, int column) {
        enemiesBattleshipGrid.setHideSpot(column, row, false);
    }

    /**
     * Checking if any spots on the grid remain occupied but still not hit. This is used for determining whether a
     * Player has won the game
     *
     * @return - true/false whether the player has won or not yet
     */
    public boolean checkForOccupiedSpots() {
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (personalBattleshipGrid.isOccupied(i, j)) {
                    return true;
                }
            }
        } return false;
    }

    /**
     * Method for checking whether a GridSpot can be hit. This is used for checking whether a spot has already been hit.
     *
     * @param row    - row of the desired hit
     * @param column - column of the desired hit
     * @return - true/false whether the player can hit the selected spot.
     */
    public boolean canBeHit(int row, int column) {
        return !personalBattleshipGrid.checkHit(row, column);
    }

    /**
     * @return - The current Grids condensed into a String
     */
    public String playersGridToString() {
        return personalBattleshipGrid.toString();
    }

    public String hiddenGridToString() {
        return enemiesBattleshipGrid.toString();
    }
}
