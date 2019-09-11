import java.util.Scanner;

public class Game implements IGame {

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

        Scanner sc = new Scanner(System.in);

        /**
         * carrier
         */
        System.out.println(name + ", please state the row of 5 width carrier");
        int carrierRow = sc.nextInt();

        System.out.println(name + ", please state the column of 5 width carrier");
        int carrierColumn = sc.nextInt();

        player.setShipLoc(carrierRow,carrierColumn,5);


        /**
         * battleship
         */
        System.out.println(name + ", please state the row of 4 width battleship");
        int battleshipRow = sc.nextInt();

        System.out.println(name + ", please state the column of 4 width battleship");
        int battleshipColumn = sc.nextInt();

        player.setShipLoc(battleshipRow,battleshipColumn,4);

        /**
         * cruiser
         */
        System.out.println(name + ", please state the row of 3 width cruiser");
        int cruiserRow = sc.nextInt();

        System.out.println(name + ", please state the column of 3 width cruiser");
        int cruiserColumn = sc.nextInt();

        player.setShipLoc(cruiserRow,cruiserColumn,3);


        /**
         * sub
         */
        System.out.println(name + ", please state the row of 3 width sub");
        int subRow = sc.nextInt();

        System.out.println(name + ", please state the column of 3 width sub");
        int subColumn = sc.nextInt();

        player.setShipLoc(subRow,subColumn,3);

        /**
         * patrol
         */
        System.out.println(name + ", please state the row of 2 width patrol boat");
        int patrolRow = sc.nextInt();

        System.out.println(name + ", please state the column of 2 width patrol boat");
        int patrolColumn = sc.nextInt();

        player.setShipLoc(patrolRow,patrolColumn,2);
    }

    public String printGrid(){

        return playerOne.toString();
    }
}
