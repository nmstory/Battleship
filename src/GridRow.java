import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class GridRow {
    private int rowID;

    List<GridSpot> gridRow = new LinkedList<>();

    public GridRow(int rowID) {
        this.rowID = rowID;
        for(int i=0; i < 8; i++){
            ListIterator<GridSpot> iterator = gridRow.listIterator();
            iterator.add(new GridSpot(i, false, false));
        }
    }

    public void setOccupied(int carrierColumn){
        ListIterator<GridSpot> iterator = gridRow.listIterator();
        for(int i=0; i<carrierColumn; i++){
            iterator.next();
        }
        GridSpot e = iterator.next();
        e.setOccupied(true);
    }
}
