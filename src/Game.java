/**
 * private variables in all files?
 * blurb at the top of the file
 * no magic numbers
 * only importing the individual methods required
 * comment comment comment
 * catching errors ie enter number in boolean/not entering true/false
 */
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game implements IGame {

    Scanner sc = new Scanner(System.in);
    String playerOneName;
    String playerTwoName;
    Player playerOne;
    Player playerTwo;
    ArrayList<Player> players;
    boolean inPlay = true;

    public Game() {

        System.out.println("WELCOME TO BATTLESHIP\n");

        /** Creating Player One **/
        System.out.println("What is the name of the first player?");
        playerOneName = sc.nextLine();
        playerOne = new Player(playerOneName);
        System.out.println(printGrid(playerOne)); //test line

        /** Creating Player Two **/
        System.out.println("What is the name of the second player?");
        Scanner sc2 = new Scanner(System.in);
        playerTwoName = sc2.nextLine();
        playerTwo = new Player(playerTwoName);
        System.out.println(printGrid(playerTwo)); //test line


        /** randomize who plays first **/
        if(ThreadLocalRandom.current().nextInt(0,1) >= 0.5){
            System.out.println(playerOneName + " plays first!");
            players.add(playerOne);
            players.add(playerTwo); }
        else {
            System.out.println(playerTwoName + " plays first!");
            players.add(playerTwo);
            players.add(playerOne); }
    }


    public void play() {

        while(inPlay){
            //switching between players
            for(Player p: players){

            }


        }

    }

    private void round(Player player) {
        //define round
    }

    private boolean finished(Player playerOne, Player playerTwo){
        //checking if either boards are completely done
        return true;
    }

    public String printGrid(Object player){
        return player.toString();
    }

}
