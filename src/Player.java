import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Player{

    // Creating variables for Player
    private String playerName;
    Grid BattleshipGrid = new Grid();
    private boolean clearSpots = true;
    Scanner sc = new Scanner(System.in);

    // Defining constants
    private static int MAX_SIZE = 8;
    private static int CARRIER_SHIP_SIZE = 5;
    private static int BATTLESHIP_SHIP_SIZE = 4;
    private static int CRUISER_SHIP_SIZE = 3;
    private static int SUBMARINE_SHIP_SIZE = 3;
    private static int PATROL_SHIP_SIZE = 2;

    /**
     * Default constructor for the class Player
     *
     * This assigns the name of the Player, and creates its 5 ships using the setShips method
     *
     * @param name - Name of this Player
     */
    public Player(String name) {
        this.playerName = name;

        setShips(CARRIER_SHIP_SIZE, "carrier");
        setShips(BATTLESHIP_SHIP_SIZE, "battleship");
        setShips(CRUISER_SHIP_SIZE, "cruiser");
        setShips(SUBMARINE_SHIP_SIZE, "submarine");
        setShips(PATROL_SHIP_SIZE, "patrol");
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
     * @param shipName - Name of the ship todo IS THIS REQUIRED IN THE GRAPHICS VERSION?
     */
    public void setShips(int shipSize, String shipName){
        clearSpots = true;

        while (clearSpots) {
            /* Requesting the location of the carrier ship on the 8x8 grid */
            System.out.println(playerName + ", please state the row of " + shipSize + " width " + shipName);
            int row = sc.nextInt();
            System.out.println(playerName + ", please state the column of " + shipSize + " width " + shipName);
            int column = sc.nextInt();

            System.out.println("rotate?");
            boolean rotation = sc.nextBoolean();

            /*
             * Checking that the ship will fit within the grid.
             * If it doesn't, then the user is asked for a new location.
             */
            try{BattleshipGrid.checkSpots(row,column, shipSize, rotation);}
            catch(NoSuchElementException e){
                System.out.println("Unfortunatly, at least one of the gridSpots is out of the box, please try again");
                clearSpots = true;
                continue; // Skips this while loop iteration after this point, as we don't need to do a spot check on a ship that doesn't fit!
                            //todo need this comment^???
            }

            /*
             * Checking that there are no other ships currently on those grid spots.
             * If there are, then the user is asked for a new location.
             */
            if (!BattleshipGrid.checkSpots(row,column, shipSize, rotation)) {
                clearSpots = false;
                BattleshipGrid.occupySpots(row,column, shipSize, rotation);
            } else {
                System.out.println("Unfortunatly, at least one of the gridSpots is already occupied by another ship, please choose again");
            }
        }
    }

    /**
     * Method for hitting a spot on the Players Grid
     *
     * @param row - row of the selected hit
     * @param column - column of the selected hit
     */
    public void hitSpot(int row, int column){
        BattleshipGrid.hitSpot(row, column);
    }

    /**
     * Checking if any spots on the grid remain occupied but still not hit. This is used for determining whether a
     * Player has won the game
     *
     * @return - true/false whether the player has won or not yet
     */
    public boolean checkForOccupiedSpots(){
        for(int i = 0; i < MAX_SIZE; i++){
            for(int j = 0; j < MAX_SIZE; j++){
                if(BattleshipGrid.displaysOccupied(i,j)){
                    return true; }
            }
        } return false;
    }

    /**
     * Method for checking whether a GridSpot can be hit. This is used for checking whether a spot has already been hit.
     *
     * @param row - row of the desired hit
     * @param column - column of the desired hit
     * @return - true/false whether the player can hit the selected spot.
     */
    public boolean canBeHit(int row, int column){
        return !BattleshipGrid.checkHit(row, column);
    }

    /**
     * @return - The current Grid condensed into a String
     */
    public String toString(){
        return BattleshipGrid.toString();
    }
}
