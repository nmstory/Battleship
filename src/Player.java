public class Player {
    private String name;
    private int carrierRow;
    private int carrierColumn;

    Grid BattleshipGrid = new Grid();

    public Player(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }
    public void setCarrierLoc(int carrierRow, int carrierColumn){
        BattleshipGrid.setOccupancyForCarrier(BattleshipGrid,carrierRow,carrierColumn);
    }
}
