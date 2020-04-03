import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Player{
    private String name;

    Grid BattleshipGrid = new Grid();
    private boolean clearSpots = true;

    public Player(String name) {
        this.name = name;
        setShipsPlayer(name);

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

    public void setShipsPlayer(String name) {

        // Scanner for obtaining the users text input
        Scanner sc = new Scanner(System.in);

        /**
         * carrier
         */
        while (clearSpots) {
            /**
             * Requesting the location of the carrier ship on the 8x8 grid
             */
            System.out.println(name + ", please state the row of 5 width carrier");
            int carrierRow = sc.nextInt();
            System.out.println(name + ", please state the column of 5 width carrier");
            int carrierColumn = sc.nextInt();

            System.out.println("rotate?");
            boolean rotation = sc.nextBoolean();



            /**
             * Checking that the ship will fit within the grid.
             * If it doesn't, then the user is asked for a new location.
             */
            try{checkShipLoc(carrierRow, carrierColumn, 5, rotation);}
            catch(NoSuchElementException e){
                System.out.println("Unfortunatly, at least one of the gridSpots is out of the box, please try again");
                clearSpots = true;
                continue; // Skips this while loop iteration after this point, as we don't need to do a spot check on a ship that doesn't fit!
            }

            /**
             * Checking that there are no other ships currently on those grid spots.
             * If there are, then the user is asked for a new location.
             */
            if (!checkShipLoc(carrierRow, carrierColumn, 5, rotation)) {
                clearSpots = false;
                setShipLoc(carrierRow, carrierColumn, 5, rotation);
            } else {
                System.out.println("Unfortunatly, at least one of the gridSpots is already occupied by another ship, please choose again");
            }
        }


        /**
         * battleship
         */
        clearSpots = true;
        while (clearSpots) {
            /**
             * Requesting the location of the carrier ship on the 8x8 grid
             */
            System.out.println(name + ", please state the row of 4 width battleship");
            int battleshipRow = sc.nextInt();
            System.out.println(name + ", please state the column of 4 width battleship");
            int battleshipColumn = sc.nextInt();

            System.out.println("rotate?");
            boolean rotation = sc.nextBoolean();


            /**
             * Checking that the ship will fit within the grid.
             * If it doesn't, then the user is asked for a new location.
             */
            try{checkShipLoc(battleshipRow, battleshipColumn, 4, rotation);}
            catch(NoSuchElementException e){
                System.out.println("Unfortunatly, at least one of the gridSpots is out of the box, please try again");
                clearSpots = true;
                continue; // Skips this while loop iteration after this point, as we don't need to do a spot check on a ship that doesn't fit!
            }

            /**
             * Checking that there are no other ships currently on those grid spots.
             * If there are, then the user is asked for a new location.
             */
            if (!checkShipLoc(battleshipRow, battleshipColumn, 4, rotation)) {
                clearSpots = false;
                setShipLoc(battleshipRow, battleshipColumn, 4,rotation);
            } else {
                System.out.println("Unfortunatly, at least one of the gridSpots is already occupied by another ship, please choose again");
            }
        }


        /**
         * cruiser
         */
        clearSpots = true;
        while (clearSpots) {
            /**
             * Requesting the location of the carrier ship on the 8x8 grid
             */
            System.out.println(name + ", please state the row of 3 width cruiser");
            int cruiserRow = sc.nextInt();
            System.out.println(name + ", please state the column of 3 width cruiser");
            int cruiserColumn = sc.nextInt();


            System.out.println("rotate?");
            boolean rotation = sc.nextBoolean();

            /**
             * Checking that the ship will fit within the grid.
             * If it doesn't, then the user is asked for a new location.
             */
            try{checkShipLoc(cruiserRow, cruiserColumn, 3, rotation);}
            catch(NoSuchElementException e){
                System.out.println("Unfortunatly, at least one of the gridSpots is out of the box, please try again");
                clearSpots = true;
                continue; // Skips this while loop iteration after this point, as we don't need to do a spot check on a ship that doesn't fit!
            }

            /**
             * Checking that there are no other ships currently on those grid spots.
             * If there are, then the user is asked for a new location.
             */
            if (!checkShipLoc(cruiserRow, cruiserColumn, 3, rotation)) {
                clearSpots = false;
                setShipLoc(cruiserRow, cruiserColumn, 3,rotation);
            } else {
                System.out.println("Unfortunatly, at least one of the gridSpots is already occupied by another ship, please choose again");
            }
        }


        /**
         * sub
         */
        clearSpots = true;
        while (clearSpots) {
            /**
             * Requesting the location of the carrier ship on the 8x8 grid
             */
            System.out.println(name + ", please state the row of 3 width sub");
            int subRow = sc.nextInt();
            System.out.println(name + ", please state the column of 3 width sub");
            int subColumn = sc.nextInt();

            System.out.println("rotate?");
            boolean rotation = sc.nextBoolean();

            /**
             * Checking that the ship will fit within the grid.
             * If it doesn't, then the user is asked for a new location.
             */
            try{checkShipLoc(subRow, subColumn, 3, rotation);}
            catch(NoSuchElementException e){
                System.out.println("Unfortunatly, at least one of the gridSpots is out of the box, please try again");
                clearSpots = true;
                continue; // Skips this while loop iteration after this point, as we don't need to do a spot check on a ship that doesn't fit!
            }

            /**
             * Checking that there are no other ships currently on those grid spots.
             * If there are, then the user is asked for a new location.
             */
            if (!checkShipLoc(subRow, subColumn, 3, rotation)) {
                clearSpots = false;
                setShipLoc(subRow, subColumn, 3,rotation);
            } else {
                System.out.println("Unfortunatly, at least one of the gridSpots is already occupied by another ship, please choose again");
            }
        }

        /**
         * patrol
         */
        clearSpots = true;
        while (clearSpots) {
            /**
             * Requesting the location of the carrier ship on the 8x8 grid
             */
            System.out.println(name + ", please state the row of 2 width patrol boat");
            int patrolRow = sc.nextInt();
            System.out.println(name + ", please state the column of 2 width patrol boat");
            int patrolColumn = sc.nextInt();

            System.out.println("rotate?");
            boolean rotation = sc.nextBoolean();

            /**
             * Checking that the ship will fit within the grid.
             * If it doesn't, then the user is asked for a new location.
             */
            try{checkShipLoc(patrolRow, patrolColumn, 2, rotation);}
            catch(NoSuchElementException e){
                System.out.println("Unfortunatly, at least one of the gridSpots is out of the box, please try again");
                clearSpots = true;
                continue; // Skips this while loop iteration after this point, as we don't need to do a spot check on a ship that doesn't fit!
            }

            /**
             * Checking that there are no other ships currently on those grid spots.
             * If there are, then the user is asked for a new location.
             */
            if (!checkShipLoc(patrolRow, patrolColumn, 2, rotation)) {
                clearSpots = false;
                setShipLoc(patrolRow, patrolColumn, 2,rotation);
            } else {
                System.out.println("Unfortunatly, at least one of the gridSpots is already occupied by another ship, please choose again");
            }
        }

    }
}
