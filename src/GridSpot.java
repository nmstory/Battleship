/**
 * Class for representing a spot on the grid.
 *
 * A grid spot contains 3 key attributes:
 * 1. hit - (true/false) has the spot been hit
 * 2. occupied - (true/false) is the spot currently occupied
 * 3. hidden - (default false) should this spot be hidden on the grid
 *
 * @author Nathan Story
 * @version 1.0
 * @since 17-06-2020
 */

public class GridSpot {

    // Defining global variables
    private boolean hit;
    private boolean occupied;
    private boolean hidden = false;

    /**
     * Constructor for creating a grid spot
     */
    public GridSpot(boolean hit, boolean occupied) {
        this.hit = hit;
        this.occupied = occupied;
    }

    /**
     * Getters and Setters for the various attributes as required
     */
    public void setOccupied(){
        this.occupied = true;
    }
    public boolean getOccupied(){return occupied;}
    public void setHidden(boolean hide){this.hidden = hide;}
    public void setHit(){
        this.hit = true;
        this.occupied = false;
    }
    public boolean getHit(){
        return hit;
    }

    /**
     * When displaying the grid, a spot can be represented in 4 ways; whether its hidden, been hit, currently occupied
     * or none of the above.
     *
     * @return - Current state of the Spot in String format
     */
    public String toString() {
        if(hidden){ return "?"; }
        if(hit){ return "!"; }
        if(occupied){ return "X"; }
        else{return "0";}
    }
}
