public class GridSpot {

    private boolean hit;
    private int columnID;

    public GridSpot(int columnID, boolean hit) {
        this.columnID = columnID;
        this.hit = hit;
    }
    public boolean isHit(){
        return hit;
    }
}
