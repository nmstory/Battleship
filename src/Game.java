import java.util.Scanner;

public class Game /*implements IGame*/ {

    Grid playerTwoBattleshipGrid = new Grid();
    Player playerOne = new Player("Nathan");

    public Game() {


        // REQUEST NAME ON GUI
        createPlayerOne("Nathan");
        System.out.println(printGrid());
    }

    public Player createPlayerOne(String name) {

        System.out.println(name + ", please state the row of 5 width carrier");
        Scanner sc = new Scanner(System.in);
        int carrierRow = sc.nextInt();

        System.out.println(name + ", please state the column of 5 width carrier");
        int carrierColumn = sc.nextInt();


        playerOne.setCarrierLoc(carrierRow,carrierColumn);

        return playerOne;
    }

    public String printGrid(){

        return playerOne.toString();
    }
}
