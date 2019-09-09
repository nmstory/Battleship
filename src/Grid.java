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

    public void setOccupancyForCarrier(Grid g, int carrierRow, int carrierColumn) {
        ListIterator<GridRow> iterator = grid.listIterator();

        for(int i=0; i<carrierRow;i++){
            iterator.next();
        }
        GridRow origin = iterator.next();
        origin.setOccupied(carrierColumn);
        origin.setOccupied(carrierColumn+1);
        origin.setOccupied(carrierColumn+2);
        origin.setOccupied(carrierColumn+3);
        origin.setOccupied(carrierColumn+4);


    }
}
