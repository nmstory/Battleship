/**
 * Class for initiating the Battleship Game, by creating a Game object.
 *
 * @author Nathan Story
 * @version 1.0
 * @since 17-06-2020
 */

public class Play {

    /**
     * Main method that initialises a Game object, and runs the game using its function play
     *
     * @param args - arguments passed by the command line when starting the program
     */
    public static void main(String[] args) {
        try {
            Game g = new Game();
            g.play();
        } catch(InterruptedException e){
        }

    }
}
