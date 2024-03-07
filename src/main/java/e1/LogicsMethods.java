package e1;

public class LogicsMethods implements LogicsImplInterface {

	private Pair<Integer,Integer> knight;
	private final int size;

    public LogicsMethods (int size, Pair<Integer, Integer> knight){
        this.size = size;
        this.knight = knight;
    }
    
    //Are knight Move a legal move?
	public Pair<Integer,Integer> knightMoves(int row, int col){
		int x = row-this.knight.getX();
		int y = col-this.knight.getY();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3)
			return this.knight = new Pair<>(row,col);
		else return this.knight; 
	}

}
