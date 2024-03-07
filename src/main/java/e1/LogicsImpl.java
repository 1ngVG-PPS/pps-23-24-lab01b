package e1;

import java.util.*;
import e1.LogicsImplInterface;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final Random random = new Random();
	private final int size;

	private LogicsImplInterface motionLogic;
	 
	//Constructor
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();	
		this.motionLogic= new LogicsMethods(size, this.knight); //Così collego interfaccie e classe
    }
	//Constructor for the test
	public LogicsImpl(int size, Pair<Integer, Integer> pawn ,Pair<Integer, Integer> knight){
    	this.size = size;
        this.pawn = pawn;
        this.knight = knight;	
		this.motionLogic= new LogicsMethods(size, this.knight); //Così collego interfaccie e classe
    }

	//Initializer for pawn
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    //knight hit the pawn?
	@Override
	public boolean hit(int row, int col) {
		checkPosition(row, col);
		motionLogic.knightMoves(row, col);
		return this.pawn.equals(this.knight);
	}
	//Are pieces inside the field
	private void checkPosition(int row, int col){
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}
}


