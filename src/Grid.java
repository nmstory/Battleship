import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Grid {

    // each player creates a grid, and each grid is actually a linkedlist
    List<GridRow> grid = new LinkedList<>();

    //Constructor for creating the Battleships Grid
    public Grid() {

        // Initial iterator states the rows, 0-7
        for(int i=0; i<8; i++){
            ListIterator<GridRow> iterator = grid.listIterator();
            iterator.add(new GridRow(i));
        }
    }

    public boolean checkSpot(int gridRow, int gridColumn, int shipSize){
        ListIterator<GridRow> iterator = grid.listIterator();

        // Minus 1 from the count because a LinkedList starts from 0, but the count of the GUI starts from 1
        for(int i=0; i<gridRow -1;i++){
            iterator.next();
        }
        GridRow origin = iterator.next();

        for(int i=0;i<shipSize;i++){
            if(origin.checkOccupied(gridColumn + i)){
                return true;
            }
        }
        return false;

    }

    public void occupySpot(int gridRow, int gridColumn, int shipSize/*, boolean vertical*/) {
        ListIterator<GridRow> iterator = grid.listIterator();

        // Minus 1 from the count because a LinkedList starts from 0, but the count of the GUI starts from 1
        for(int i=0; i<gridRow -1;i++){
            iterator.next();
        }
        GridRow origin = iterator.next();

        for(int i=0;i<shipSize;i++){
            origin.setOccupied(gridColumn + i);
        }/*here*/
        System.out.println("here1");
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
