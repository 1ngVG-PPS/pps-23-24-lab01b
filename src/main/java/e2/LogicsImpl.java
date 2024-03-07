package e2;

import java.util.Random;

public class LogicsImpl implements Logics {

    private final int size = 20;
    private final int nBomb = 10;
    private Pair<Integer, Integer> bomb[];
    private final Random random = new Random();

    public LogicsImpl(int size) {
        for(int i = 0; i < nBomb; i++){
            this.bomb[i] = setBombPosition();
        } 
    }

    @Override
    public Pair<Integer, Integer> setBombPosition() {
        //Set a different Random Position for every bomb
        int i = 0;
        Pair<Integer,Integer> pos;
        do{
            pos =  randomPosition();
            i++;
        }while(pos == this.bomb[i] || i<nBomb);
        return pos;
    }

    private final Pair<Integer,Integer> randomPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	return pos;
    }


   

}
