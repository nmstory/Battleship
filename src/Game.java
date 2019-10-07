/**
 * private variables in all files?
 * blurb at the top of the file
 * no magic numbers
 * only importing the individual methods required
 * comment comment comment
 * catching errors ie enter number in boolean/not entering true/false
 */
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Game implements IGame {


    public Game() {
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO BATTLESHIP\n");
        System.out.println("What is your name?");
        String playerOneName = sc.nextLine();

        System.out.println("Is the second player an AI (answer true/false)");
        boolean isAI = sc.nextBoolean();

        /*
        //playerOne = createPlayer(playerOneName, false);
        Player playerOne = new Player(playerOneName);
        System.out.println(printGrid(playerOne));*/

        if(!isAI){System.out.println("What is the name of the second player?");
        String playerTwoName = sc.nextLine();
        Player playerTwo = new Player(playerTwoName);}

        else{/*AI.setShipsAI("AI");*/}PlayerAI playerAI = new PlayerAI();
        System.out.println(printGridAI(playerAI));
    }

    /**
     * CONDENSE!!!
     */
    public String printGrid(Player player){

        return player.toString();
    }

    public String printGridAI(PlayerAI playerAI){
        return playerAI.toString();
    }
}
