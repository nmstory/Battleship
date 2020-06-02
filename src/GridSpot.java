public class GridSpot {

    private boolean hit;
    private int columnID;
    private boolean occupied;

    public GridSpot(int columnID, boolean hit, boolean occupied) {
        this.columnID = columnID;
        this.hit = hit;
        this.occupied = occupied;
    }

    public void setOccupied(){
        this.occupied = true;
    }
    public boolean getOccupied(){return occupied;} //this.? todo for some reason, i think this. doesnt work
    public void setHit(){
        this.hit = true;
    }
    public boolean getHit(){
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
