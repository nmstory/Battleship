import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Player{
    private String name;

    Grid BattleshipGrid = new Grid();
    private boolean clearSpots = true;

    // Scanner for obtaining the users text input
    Scanner sc = new Scanner(System.in); //declared here?



    public Player(String name) {
        this.name = name;

        //setShipsPlayer(name);

        /** Need to call setShips 5 times, for the 5 different sized ships **/
        setShips(name, 5, "carrier"); //change from imag. numbers to private constants at the start
        setShips(name, 4, "battleship");
        setShips(name, 3, "cruiser");
        setShips(name, 3, "submarine");
        setShips(name, 2, "patrol");


    }

    public String getName() {
        return name;
    }

    public void setShipLoc(int row, int column, int shipSize, boolean rotation){

        BattleshipGrid.occupySpot(row,column, shipSize, rotation);
    }

    public boolean checkShipLoc(int row, int column, int shipSize, boolean rotation){
        return BattleshipGrid.checkSpot(row,column, shipSize, rotation);
    }

    public String toString(){
        return BattleshipGrid.toString();
    }

    public void setShips(String name, int shipSize, String shipName){

        clearSpots = true;
        while (clearSpots) {
            /**
             * Requesting the location of the carrier ship on the 8x8 grid
             */
            System.out.println(name + ", please state the row of " + shipSize + " width " + shipName);
            int row = sc.nextInt();
            System.out.println(name + ", please state the column of " + shipSize + " width " + shipName);
            int column = sc.nextInt();

            System.out.println("rotate?");
            boolean rotation = sc.nextBoolean();



            /**
             * Checking that the ship will fit within the grid.
             * If it doesn't, then the user is asked for a new location.
             */
            try{checkShipLoc(row, column, shipSize, rotation);}
            catch(NoSuchElementException e){
                System.out.println("Unfortunatly, at least one of the gridSpots is out of the box, please try again");
                clearSpots = true;
                continue; // Skips this while loop iteration after this point, as we don't need to do a spot check on a ship that doesn't fit!
            }

            /**
             * Checking that there are no other ships currently on those grid spots.
             * If there are, then the user is asked for a new location.
             */
            if (!checkShipLoc(row, column, shipSize, rotation)) {
                clearSpots = false;
                setShipLoc(row, column, shipSize, rotation);
            } else {
                System.out.println("Unfortunatly, at least one of the gridSpots is already occupied by another ship, please choose again");
            }
        }
    }
}
