public class Player extends Grid{
    private String name;

    Grid BattleshipGrid = new Grid();

    public Player(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }
    /* Now extended Grid, so doing player.occupySpot
    public void setShipLoc(int row, int column, int shipSize){
        BattleshipGrid.occupySpot(row,column, shipSize);
    }*/

    public String toString(){
        return BattleshipGrid.toString();
    }
}
