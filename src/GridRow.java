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
        // Minus 1 from the count because a LinkedList starts from 0, but the count of the GUI starts from 1
        for(int i=0; i<carrierColumn - 1; i++){
            iterator.next();
        }
        GridSpot e = iterator.next();
        e.setOccupied(true);
    }

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
