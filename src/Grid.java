/**
 * Class representing a Grid, which consists of 8 GridRow's.
 *
 * This includes the functionality to place ships of any size (with checks that nothing
 * already exists in those spots), being able to hit enemy ships and handling the grid that's revealed to an enemy.
 *
 * @author Nathan Story
 * @version 1.0
 * @since 17-06-2020
 */

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Grid {

    // Defining global variables
    private List<GridRow> grid = new LinkedList<>();
    private static final int MAX_SIZE = 8;

    /**
     * Constructor for creating the Battleships Grid, where a grid contains a list of 8 grid rows
     */
    public Grid() {
        for (int i = 0; i < MAX_SIZE; i++) {
            ListIterator<GridRow> iterator = grid.listIterator();
            iterator.add(new GridRow());
        }
    }

    /**
     * Used for checking if any of the spots selected are already occupied
     * <p>
     * This is used when initially choosing the position of the players five ships
     *
     * @param gridRow    - row of primary spot of ship
     * @param gridColumn - column of primary spot of ship
     * @param shipSize   - size of the ship to be placed
     * @param rotation   - (true/false) whether the ship will be vertical/horizontal
     * @return - true/false whether all the ship can be placed
     */
    public boolean checkSpots(int gridRow, int gridColumn, int shipSize, boolean rotation) {
        ListIterator<GridRow> iterator = grid.listIterator();

        /* If rotation = true, then the ship will be placed vertically on the grid.
         * Therefore when checking each spot that the ship would be placed in for occupancy, we'll iterate through
         shipSize amount of columns with gridColumn as the number of places the ship will be in from the left */
        if (rotation) {
            // Jump to the initial column
            for (int i = 0; i < gridRow - 1; i++) {
                iterator.next();
            }

            for (int i = 0; i < shipSize; i++) {
                GridRow currentRow = iterator.next();
                if (currentRow.checkOccupied(gridColumn)) {
                    return true;
                }
            }
        }

        /* Else rotation = false, so that the ship will be placed horizontally on the grid
         * Therefore when checking if any of the spots are already occupied, we'll focus on one column */
        else {
            // Jump to the initial column
            for (int i = 0; i < gridRow - 1; i++) {
                iterator.next();
            }
            GridRow origin = iterator.next();

            for (int i = 0; i < shipSize; i++) {
                if (origin.checkOccupied(gridColumn + i)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Reach this function if all the grid spots are clear for the ship to be placed
     * <p>
     * This is used when placing the position of the players five ships on the grid
     *
     * @param gridRow    - row of primary spot of ship
     * @param gridColumn - column of primary spot of ship
     * @param shipSize   - size of the ship to be placed
     * @param rotation   - (true/false) whether the ship will be vertical/horizontal
     */
    public void occupySpots(int gridRow, int gridColumn, int shipSize, boolean rotation) {
        ListIterator<GridRow> iterator = grid.listIterator();

        /* If rotation = true, then the ship will be placed vertically on the grid.
         * Therefore when placing the ship we'll iterate through shipSize amount of columns with gridColumn as the
         * number of places the ship will be in from the left */
        if (rotation) {
            // Jump to the initial column
            for (int i = 0; i < gridRow - 1; i++) {
                iterator.next();
            }

            for (int i = 0; i < shipSize; i++) {
                GridRow currentRow = iterator.next();
                currentRow.setOccupied(gridColumn);
            }
        }

        /* If rotation = false, then the ship will be placed horizontally on the grid.
         * Therefore when placing ships on the grid we're only focusing on one column */
        else {
            // Jump to the initial column
            for (int i = 0; i < gridRow - 1; i++) {
                iterator.next();
            }
            GridRow origin = iterator.next();

            for (int i = 0; i < shipSize; i++) {
                origin.setOccupied(gridColumn + i);
            }
        }
    }

    /**
     * Universal function to iterate through the Grid
     *
     * @param row - amount of iterations needed to get to the selected GridRow within the Grid
     * @return - the ListIterator at the correct point within the Grid
     */
    public ListIterator<GridRow> iterator(int row) {
        ListIterator<GridRow> iterator = grid.listIterator();

        // Iterating through to the row to be hit
        for (int i = 0; i < row - 1; i++) {
            iterator.next();
        } return iterator;
    }

    /**
     * Marks a certain spot as hit on the players grid
     *
     * @param column - column of the gridSpot to be hit
     * @param row    - row of the gridSpot to be hit
     */
    public void hitSpot(int column, int row) {
        GridRow rowToBeHit = iterator(row).next();
        rowToBeHit.setHit(column);
    }

    /**
     * Checking if the selected spot has been hit yet
     *
     * @param column - column of the gridSpot to be checked
     * @param row    - row of the gridSpot to be checked
     * @return - (true/false) if the gridSpot has been hit or not
     */
    public boolean checkHit(int column, int row) {
        GridRow rowToCheck = iterator(row).next();
        return rowToCheck.checkHit(column);
    }

    /**
     * Checking if the selected spot is currently occupied by another spot
     *
     * @param column - Column of the gridSpot to be checked if hit
     * @param row    - Row of the gridSpot to be checked if hit
     * @return - (True/false) whether its been hit or not
     */
    public boolean isOccupied(int column, int row) {
        GridRow rowToBeChecked = iterator(row).next();
        return rowToBeChecked.checkOccupied(column);
    }

    /**
     * Used for revealing/hiding a spot after its been hit
     *
     * @param column - column of the gridSpot to be revealed/hidden
     * @param row - row of the gridSpot to be revealed/hidden
     * @param hide - (true/false) value that the gridSpot's hidden attribute will be changed to
     */
    public void setHideSpot(int column, int row, boolean hide) {
        GridRow rowRequired = iterator(row).next();
        rowRequired.setHide(column, hide);
    }

    /**
     * Used for hiding the grid that the enemy will see, whereby each gridSpot is displayed as '?'
     */
    public void setAllHidden() {
        ListIterator<GridRow> iterator = grid.listIterator();

        // Iterating through to the row to be hit
        for (int i = 0; i < MAX_SIZE; i++) {
            GridRow row = iterator.next();

            for (int j = 0; j < MAX_SIZE + 1; j++) {
                row.setHide(j, true);
            }
        }
    }

    /**
     * @return - String representation of the players grid
     */
    public String toString() {
        String toReturn = "";
        ListIterator<GridRow> iterator = grid.listIterator();

        while (iterator.hasNext()) {
            GridRow e = iterator.next();
            toReturn += e.toString() + "\n";
        }
        return toReturn;
    }
}
