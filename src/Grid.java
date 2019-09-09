import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Grid {

    //Constructor for creating the Battleships Grid
    public Grid() {
        List<GridRow> grid = new LinkedList<>();
        // Initial iterator states the rows, 0-7
        for(int i=0; i<8; i++){
            ListIterator<GridRow> iterator = grid.listIterator();
            iterator.add(new GridRow(i));
        }
    }
}
