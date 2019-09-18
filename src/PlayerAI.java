import java.util.concurrent.ThreadLocalRandom;

public class PlayerAI{

    Grid BattleshipGridAI = new Grid();

    //MAKE VARIABLES THAT CANT BE CHANGED

    int max=4;

    public static final int MIN = 0;
    public static final int CARRIEr;

    /**
     * if rotation is true /false - adjust/set max accordingly to save boxing in the ships
     *
     * +need checks to ensure there is a ship there currently
     * @param name
     */




    public void setShipsAI(String name){
        //Carrier
        int carrierRow = ThreadLocalRandom.current().nextInt(min,max+1);
        int carrierColumn = ThreadLocalRandom.current().nextInt(min,max+1);
        boolean rotation = ThreadLocalRandom.current().nextBoolean();
        BattleshipGridAI.occupySpot(carrierRow,carrierColumn,5, rotation);

        //battleship
        carrierRow = ThreadLocalRandom.current().nextInt(min,max+1);
        carrierColumn = ThreadLocalRandom.current().nextInt(min,max+1);
        rotation = ThreadLocalRandom.current().nextBoolean();
        BattleshipGridAI.occupySpot(carrierRow,carrierColumn,4, rotation);

        //cruiser
        carrierRow = ThreadLocalRandom.current().nextInt(min,max+1);
        carrierColumn = ThreadLocalRandom.current().nextInt(min,max+1);
        rotation = ThreadLocalRandom.current().nextBoolean();
        BattleshipGridAI.occupySpot(carrierRow,carrierColumn,3, rotation);

        //submarine
        carrierRow = ThreadLocalRandom.current().nextInt(min,max+1);
        carrierColumn = ThreadLocalRandom.current().nextInt(min,max+1);
        rotation = ThreadLocalRandom.current().nextBoolean();
        BattleshipGridAI.occupySpot(carrierRow,carrierColumn,3, rotation);

        //patrol
        carrierRow = ThreadLocalRandom.current().nextInt(min,max+1);
        carrierColumn = ThreadLocalRandom.current().nextInt(min,max+1);
        rotation = ThreadLocalRandom.current().nextBoolean();
        BattleshipGridAI.occupySpot(carrierRow,carrierColumn,2, rotation);
    }
}
