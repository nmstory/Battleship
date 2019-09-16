public class Player extends Grid{
    private String name;

    Grid BattleshipGrid = new Grid();

    public Player(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setShipLoc(int row, int column, int shipSize, boolean rotation){

        BattleshipGrid.occupySpot(row,column, shipSize, rotation);
    }

    public boolean checkShipLoc(int row, int column, int shipSize, boolean rotation){
        return BattleshipGrid.checkSpot(row,column, shipSize, rotation);
    }

    public String toString(){
        return BattleshipGrid.toString();
    }
}
