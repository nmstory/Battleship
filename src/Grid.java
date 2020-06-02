import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Grid {

    // each player creates a grid, and each grid is actually a linkedlist
    List<GridRow> grid = new LinkedList<>();
    private static int MAX_SIZE = 8; //please define me

    //Constructor for creating the Battleships Grid
    public Grid() {

        // Initial iterator states the rows, 0-7
        for(int i=0; i<MAX_SIZE; i++){
            ListIterator<GridRow> iterator = grid.listIterator();
            iterator.add(new GridRow(i));
        }
    }

    //used for checking spots when wanting to place a ship of shipSize size?
    public boolean checkSpots(int gridRow, int gridColumn, int shipSize, boolean rotation){
        ListIterator<GridRow> iterator = grid.listIterator();

        if(rotation) { // True - Vertical
            //Jump to column
            for (int i = 0; i < gridRow - 1; i++) {
                iterator.next();
            }

            for(int i=0; i<shipSize; i++){
                GridRow currentRow = iterator.next();
                if(currentRow.checkOccupied(gridColumn)){
                    return true;
                }
            }return false;
        }

        else { // false - horizontal
            // Minus 1 from the count because a LinkedList starts from 0, but the count of the GUI starts from 1
            for (int i = 0; i < gridRow - 1; i++) {
                iterator.next();
            }
            GridRow origin = iterator.next();

            for (int i = 0; i < shipSize; i++) {
                if (origin.checkOccupied(gridColumn + i)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void occupySpots(int gridRow, int gridColumn, int shipSize, boolean rotation) {
        ListIterator<GridRow> iterator = grid.listIterator();

        if(rotation) { // True - vertical
            //Jump to column
            for (int i = 0; i < gridRow - 1; i++) {
                iterator.next();
            }

            for(int i=0; i<shipSize; i++){
                GridRow currentRow = iterator.next();
                currentRow.setOccupied(gridColumn);
            }
        }

        else { // false - horizontal
            // Minus 1 from the count because a LinkedList starts from 0, but the count of the GUI starts from 1
            for (int i = 0; i < gridRow - 1; i++) {
                iterator.next();
            }
            GridRow origin = iterator.next();

            for (int i = 0; i < shipSize; i++) {
                origin.setOccupied(gridColumn + i);
            }
        }

    }

    public void hitSpot(int column, int row){
        ListIterator<GridRow> iterator = grid.listIterator();

        //Get to place
        for (int i = 0; i < row - 1; i++) {
            iterator.next();
        }

        GridRow rowToBeHit = iterator.next();

        rowToBeHit.setHit(column);
    }

    //rename to check hit?
    public boolean checkHit(int column, int row){
        ListIterator<GridRow> iterator = grid.listIterator();

        //Get to place
        for (int i = 0; i < row - 1; i++) {
            iterator.next();
        }

        GridRow rowToBeHit = iterator.next();

        return rowToBeHit.getHit(column);
    }



    public boolean isOccupied(int column, int row){
        ListIterator<GridRow> iterator = grid.listIterator();

        //Get to place
        for (int i = 0; i < row - 1; i++) {
            iterator.next();
        }

        GridRow rowToBeHit = iterator.next();

        return rowToBeHit.checkOccupied(column);
    }

    public boolean displaysOccupied(int column, int row){
        ListIterator<GridRow> iterator = grid.listIterator();

        //Get to place
        for (int i = 0; i < row - 1; i++) {
            iterator.next();
        }

        GridRow rowToBeHit = iterator.next();

        return rowToBeHit.checkDisplaysOccupied(column);
    }



    public String toString() {
        String toReturn = "";
        ListIterator<GridRow> iterator = grid.listIterator();

        while(iterator.hasNext()){
            GridRow e = iterator.next();
            toReturn += e.toString() + "\n";
        }
        return toReturn;
    }
}
