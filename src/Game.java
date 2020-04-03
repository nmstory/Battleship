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

    Scanner sc = new Scanner(System.in);
    String playerOneName;
    String playerTwoName;

    public Game() {

        //creating + setting up players
        System.out.println("WELCOME TO BATTLESHIP\n");
        System.out.println("What is your name?");
        playerOneName = sc.nextLine();

        Player playerOne = new Player(playerOneName);
        System.out.println(printGrid(playerOne)); //test line

        System.out.println("What is the name of the second player?");
        Scanner sc2 = new Scanner(System.in);
        playerTwoName = sc2.nextLine();

        Player playerTwo = new Player(playerTwoName);
        System.out.println(printGrid(playerTwo)); //test line



    }


    public void play() {


    }

    public String printGrid(Object player){
        return player.toString();
    }

}
