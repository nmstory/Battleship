public class GridSpot {

    private boolean hit;
    private int columnID;
    private boolean occupied;

    public GridSpot(int columnID, boolean hit, boolean occupied) {
        this.columnID = columnID;
        this.hit = hit;
        this.occupied = occupied;
    }
    public boolean checkOccupied(){return occupied;}
    public void occupy(){
        this.occupied = true;
    }
    public void hit(){
        this.hit = true;
    }
    public boolean isOccupied(){
        return this.occupied;
    } //function needed?
    public boolean isHit(){
        return hit;
    }

    public String toString() {
        if(hit){
            return "!";
        }
        if(occupied){
            return "X";
        }
        else{return "0";}
    }
}
