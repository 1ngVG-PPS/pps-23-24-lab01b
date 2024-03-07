package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import e1.LogicsImplInterface;
public class LogicMethodsTest {
    
    private Pair<Integer,Integer> knight;
	private int size;
    private LogicsMethods logic;

    @BeforeEach
    public void initializeLogic(){
    this.size = 5;
    this.knight= new Pair<Integer,Integer>(0, 0);
    this.logic = new LogicsMethods(size, this.knight);
    }

    @Test
    public void testknightMoves(){
        Pair<Integer, Integer> pos = logic.knightMoves(1,3);
         assertEquals(pos,this.knight);    
    }
    
}
