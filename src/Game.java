import java.util.NoSuchElementException;
import java.util.Scanner;

public class Game implements IGame {

    private boolean clearSpots = true;

    Grid playerTwoBattleshipGrid = new Grid();
    Player playerOne = new Player("Nathan");

    public Game() {


        // REQUEST NAME ON GUI
        createPlayerOne("Nathan");
        System.out.println(printGrid());
    }

    public Player createPlayerOne(String name) {

        setShips(playerOne, name);



        return playerOne;
    }

    public void setShips(Player player, String name) {

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

            /**
             * Checking that the ship will fit within the grid.
             * If it doesn't, then the user is asked for a new location.
             */
            try{player.checkSpot(carrierRow, carrierColumn, 5);}
            catch(NoSuchElementException e){
                System.out.println("Unfortunatly, at least one of the gridSpots is out of the box, please try again");
                clearSpots = true;
                continue; // Skips this while loop iteration after this point, as we don't need to do a spot check on a ship that doesn't fit!
            }

            /**
             * Checking that there are no other ships currently on those grid spots.
             * If there are, then the user is asked for a new location.
             */
            if (!player.checkSpot(carrierRow, carrierColumn, 5)) {
                clearSpots = false;
                player.setShipLoc(carrierRow, carrierColumn, 5);
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

            /**
             * Checking that the ship will fit within the grid.
             * If it doesn't, then the user is asked for a new location.
             */
            try{player.checkSpot(battleshipRow, battleshipColumn, 4);}
            catch(NoSuchElementException e){
                System.out.println("Unfortunatly, at least one of the gridSpots is out of the box, please try again");
                clearSpots = true;
                continue; // Skips this while loop iteration after this point, as we don't need to do a spot check on a ship that doesn't fit!
            }

            /**
             * Checking that there are no other ships currently on those grid spots.
             * If there are, then the user is asked for a new location.
             */
            if (!player.checkSpot(battleshipRow, battleshipColumn, 4)) {
                clearSpots = false;
                player.setShipLoc(battleshipRow, battleshipColumn, 4);
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

            /**
             * Checking that the ship will fit within the grid.
             * If it doesn't, then the user is asked for a new location.
             */
            try{player.checkSpot(cruiserRow, cruiserColumn, 3);}
            catch(NoSuchElementException e){
                System.out.println("Unfortunatly, at least one of the gridSpots is out of the box, please try again");
                clearSpots = true;
                continue; // Skips this while loop iteration after this point, as we don't need to do a spot check on a ship that doesn't fit!
            }

            /**
             * Checking that there are no other ships currently on those grid spots.
             * If there are, then the user is asked for a new location.
             */
            if (!player.checkSpot(cruiserRow, cruiserColumn, 3)) {
                clearSpots = false;
                player.setShipLoc(cruiserRow, cruiserColumn, 3);
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

            /**
             * Checking that the ship will fit within the grid.
             * If it doesn't, then the user is asked for a new location.
             */
            try{player.checkSpot(subRow, subColumn, 3);}
            catch(NoSuchElementException e){
                System.out.println("Unfortunatly, at least one of the gridSpots is out of the box, please try again");
                clearSpots = true;
                continue; // Skips this while loop iteration after this point, as we don't need to do a spot check on a ship that doesn't fit!
            }

            /**
             * Checking that there are no other ships currently on those grid spots.
             * If there are, then the user is asked for a new location.
             */
            if (!player.checkSpot(subRow, subColumn, 3)) {
                clearSpots = false;
                player.setShipLoc(subRow, subColumn, 3);
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

            /**
             * Checking that the ship will fit within the grid.
             * If it doesn't, then the user is asked for a new location.
             */
            try{player.checkSpot(patrolRow, patrolColumn, 2);}
            catch(NoSuchElementException e){
                System.out.println("Unfortunatly, at least one of the gridSpots is out of the box, please try again");
                clearSpots = true;
                continue; // Skips this while loop iteration after this point, as we don't need to do a spot check on a ship that doesn't fit!
            }

            /**
             * Checking that there are no other ships currently on those grid spots.
             * If there are, then the user is asked for a new location.
             */
            if (!player.checkSpot(patrolRow, patrolColumn, 2)) {
                clearSpots = false;
                player.setShipLoc(patrolRow, patrolColumn, 2);
            } else {
                System.out.println("Unfortunatly, at least one of the gridSpots is already occupied by another ship, please choose again");
            }
        }
    }

    public String printGrid(){

        return playerOne.toString();
    }
}
