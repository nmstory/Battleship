public class GridSpot {

    private boolean hit;
    private int columnID;
    private boolean occupied;

    public GridSpot(int columnID, boolean hit, boolean occupied) {
        this.columnID = columnID;
        this.hit = hit;
        this.occupied = occupied;
    }

    public void setOccupied(boolean occupied){
        this.occupied = occupied;
    }
    public boolean getOccupied(){
        return this.occupied;
    }
    public boolean isHit(){
        return hit;
    }

    public String toString() {
        if(occupied){
            return "X";
        }
        else{return "0";}
    }
}
