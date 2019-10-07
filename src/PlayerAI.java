

import java.util.concurrent.ThreadLocalRandom;

public class PlayerAI{

    Grid BattleshipGridAI = new Grid();
    private String name;
    private boolean clearSpots = true;

    public PlayerAI(){
        name = "AI";
        setShipsAI(name);
    }

    //MAKE VARIABLES THAT CANT BE CHANGED
    public static final int MIN = 0;
    public static final int MAX = 4;

    /**
     * if rotation is true /false - adjust/set max accordingly to save boxing in the ships
     *
     * +need checks to ensure there is a ship there currently
     *
     */

    public String toString(){
        return BattleshipGridAI.toString();
    }


    public void setShipsAI(String name){
        while(clearSpots){
        //Carrier
        int carrierRow = ThreadLocalRandom.current().nextInt(MIN,MAX);
        int carrierColumn = ThreadLocalRandom.current().nextInt(MIN,MAX);
        boolean rotation = ThreadLocalRandom.current().nextBoolean();
        if(!BattleshipGridAI.checkSpot(carrierRow,carrierColumn,5, rotation)){
            BattleshipGridAI.occupySpot(carrierRow,carrierColumn,5, rotation);
            clearSpots = false;
            }
        }
        clearSpots = true;

        while(clearSpots){
            //battleship
            int battleshipRow = ThreadLocalRandom.current().nextInt(MIN,MAX+1);
            int battleshipColumn = ThreadLocalRandom.current().nextInt(MIN,MAX+1);
            boolean battleshiprotation = ThreadLocalRandom.current().nextBoolean();
            if(!BattleshipGridAI.checkSpot(battleshipRow,battleshipColumn,4, battleshiprotation)){
                BattleshipGridAI.occupySpot(battleshipRow,battleshipColumn,4, battleshiprotation);
                clearSpots = false;
            }
        }
        clearSpots = true;

        while(clearSpots){
            //cruiser
            int cruiserRow = ThreadLocalRandom.current().nextInt(MIN,MAX+2);
            int cruiserColumn = ThreadLocalRandom.current().nextInt(MIN,MAX+2);
            boolean cruiserrotation = ThreadLocalRandom.current().nextBoolean();
            if(!BattleshipGridAI.checkSpot(cruiserRow,cruiserColumn,3, cruiserrotation)){
                BattleshipGridAI.occupySpot(cruiserRow,cruiserColumn,3, cruiserrotation);
                clearSpots = false;
            }
        }
        clearSpots = true;

        while(clearSpots){
            //submarine
            int submarineRow = ThreadLocalRandom.current().nextInt(MIN,MAX+2);
            int submarineColumn = ThreadLocalRandom.current().nextInt(MIN,MAX+2);
            boolean submarinerotation = ThreadLocalRandom.current().nextBoolean();
            if(!BattleshipGridAI.checkSpot(submarineRow,submarineColumn,3, submarinerotation)){
                BattleshipGridAI.occupySpot(submarineRow,submarineColumn,3, submarinerotation);
                clearSpots = false;
            }
        }
        clearSpots = true;

        while(clearSpots){
            //patrol
            int patrolRow = ThreadLocalRandom.current().nextInt(MIN,MAX+3);
            int patrolColumn = ThreadLocalRandom.current().nextInt(MIN,MAX+3);
            boolean patrolrotation = ThreadLocalRandom.current().nextBoolean();
            if(!BattleshipGridAI.checkSpot(patrolRow,patrolColumn,2, patrolrotation)){
                BattleshipGridAI.occupySpot(patrolRow,patrolColumn,2, patrolrotation);
                clearSpots = false;
            }
        }
    }
}
