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
    ArrayList<Player> players = new ArrayList<>();


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
        int value = ThreadLocalRandom.current().nextInt(0, 1);
        if (value >= 0.5) {
            System.out.println(playerOneName + " plays first!");
            players.add(playerOne);
            players.add(playerTwo);
        } else {
            System.out.println(playerTwoName + " plays first!");
            players.add(playerTwo);
            players.add(playerOne);
        }
    }


    public void play() {
        boolean inPlay = true;
        while (inPlay) {
            //switching between players
            for (Player p : players) {

                round(p);
                /** finsished could be true for player1, but itll still run through player2 before stopping**/
                /*if (finished()) {
                    inPlay = false; TODO: Complete
                }*/
            }


        }

    }

    /*private void round(Player player) {
        boolean hit = false;

        while(!hit){
            System.out.println(player.getName() + "row to hit");
            int rowToHit = sc.nextInt();

            System.out.println(player.getName() + "column to hit");
            int columnToHit = sc.nextInt();

            if(player.equals(pla))
        }
    }*/

    private void round(Player player) {
        boolean hit = false;

        while (!hit) {
            System.out.println(player.getName() + ", please select the row you'd like to hit");
            int rowHit = sc.nextInt();

            System.out.println(player.getName() + ", please select the column you'd like to hit");
            int columnHit = sc.nextInt();

            if (player.equals(playerOne)) {
                //playertwo.hit
                if (playerTwo.canBeHit(columnHit, rowHit)) {
                    playerTwo.hitShip(columnHit, rowHit);
                    hit = true;

                    /**test code**/
                    System.out.println("Enemies grid:");
                    System.out.println(playerTwo.toString());

                } else {
                    System.out.println("NOT DO-ABLE MATEY");
                }
            }


            //Player is playerTwo
            else {
                if (playerOne.canBeHit(columnHit, rowHit)) {
                    playerOne.hitShip(columnHit, rowHit);
                    hit = true;

                    /**test code**/
                    System.out.println("Enemies grid:");
                    System.out.println(playerOne.toString());
                } else {
                    System.out.println("NOT DO-ABLE MATEY");
                }
            }
        }
    }


    private boolean finished() {
        //checking if either boards are completely done
        // check playerOne / playerTwo - not taking parameters for global variable
        /** are global variables a done thing in java? **/
        return true;
    }

    public String printGrid(Object player) {
        return player.toString();
    }

}
