import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class GridRow {
    private int rowID;

    public GridRow(int rowID) {
        this.rowID = rowID;

        List<GridSpot> gridRow = new LinkedList<>();
        for(int i=0; i < 8; i++){
            ListIterator<GridSpot> iterator = gridRow.listIterator();
            iterator.add(new GridSpot(i, false));
        }
    }
}
