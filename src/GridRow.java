/**
 * Class representing a GridRow, which consists of 8 GridSpots.
 *
 * The functionality includes hitting any of the grid spots, checking whether theyre already occupied and providing a
 * visual representation as to the current state.
 *
 * @author Nathan Story
 * @version 1.0
 * @since 17-06-2020
 */

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class GridRow {

    // Defining global variables
    private List<GridSpot> gridRow = new LinkedList<>();
    private static int MAX_SIZE = 8;

    /**
     * Constructor for creating a grid row, where a row contains a list of 8 grid spots
     */
    public GridRow() {
        for(int i=0; i < MAX_SIZE; i++){
            ListIterator<GridSpot> iterator = gridRow.listIterator();
            iterator.add(new GridSpot(false, false));
        }
    }

    /**
     * Universal function to iterate through the GridRow
     *
     * @param column - amount of iterations needed to get to the selected gridSpot within the GridRow
     * @return - the ListIterator at the correct point within the GridRow
     */
    public ListIterator<GridSpot> iterator(int column){
        ListIterator<GridSpot> iterator = gridRow.listIterator();

        for(int i=0; i<column - 1; i++){
            iterator.next();
        } return iterator;
    }

    /**
     * Checking if the selected spot is currently occupied by another spot
     *
     * @param column - Column of the gridSpot to be checked if hit
     * @return - (True/false) whether the gridSpot has been hit or not
     */
    public boolean checkOccupied(int column){
        GridSpot e = iterator(column).next();
        return e.getOccupied();
    }

    /**
     * Occupying a gridSpot on the players Grid.
     *
     * @param column - column of the gridSpot to be occupied
     */
    public void setOccupied(int column){
        GridSpot e = iterator(column).next();
        e.setOccupied();
    }

    /**
     * Checking if the selected spot has been hit yet
     *
     * @param column - Column of the gridSpot to be checked
     * @return - (true/false) if the gridSpot has been hit or not
     */
    public boolean checkHit(int column){
        GridSpot e = iterator(column).next();
        return e.getHit();
    }

    /**
     * Marking a gridSpot as hit on the players Grid
     *
     * @param column - Column of the hit
     */
    public void setHit(int column){
        GridSpot e = iterator(column).next();
        e.setHit();
    }

    /**
     * Used for revealing/hiding a spot after its been hit
     *
     * @param column - column of the gridSpot to be revealed/hidden
     * @param hide - (true/false) value that the gridSpot's hidden attribute will be changed to
     */
    public void setHide(int column, boolean hide){
        GridSpot e = iterator(column).next();
        e.setHidden(hide);
    }

    /**
     * @return - String representation of this GridRow
     */
    public String toString(){
        String toReturn = "";
        ListIterator<GridSpot> iterator = gridRow.listIterator();

        while(iterator.hasNext()){
            GridSpot e = iterator.next();
            toReturn += e.toString();
        }
        return toReturn;
    }
}
