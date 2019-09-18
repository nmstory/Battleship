import java.util.NoSuchElementException;
import java.util.Scanner;

public class Game implements IGame {



    Player playerOne;
    Player playerTwo;
    PlayerAI AI;

    public Game() {
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO BATTLESHIP\n");
        System.out.println("What is your name?");
        String playerOneName = sc.nextLine();

        System.out.println("Is the second player an AI (answer true/false)");
        boolean isAI = sc.nextBoolean();

        //playerOne = createPlayer(playerOneName, false);
        playerOne.setShipsPlayer(playerOneName);
        System.out.println(printGrid(playerOne));

        if(!isAI){System.out.println("What is the name of the second player?");
        String playerTwoName = sc.nextLine();

        playerTwo.setShipsPlayer(playerTwoName);}
        else{AI.setShipsAI("AI");}
    }

    public String printGrid(Player player){

        return player.toString();
    }
}
