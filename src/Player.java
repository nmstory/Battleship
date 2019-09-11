public class Player {
    private String name;

    Grid BattleshipGrid = new Grid();

    public Player(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setShipLoc(int row, int column, int shipSize){
        BattleshipGrid.occupySpot(row,column, shipSize);
    }

    public String toString(){
        return BattleshipGrid.toString();
    }
}
