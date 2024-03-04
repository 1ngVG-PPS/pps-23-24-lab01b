package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import e1.Logics;

public class LogicTest {

  private Pair<Integer,Integer> pawn;
  private Pair<Integer,Integer> knight;
  private int size;
  private LogicsImpl logic;

  @BeforeEach
  public void initializeLogic(){
   this.size = 5;
   this.pawn = new Pair<Integer,Integer>(1, 2);
   this.knight= new Pair<Integer,Integer>(0, 0);
   this.logic = new LogicsImpl(size);
  }

  @Test
  public void testPawnAndKnightAreIN(){

    boolean pawnIsIN = false;
    boolean knightIsIN = false;

    for (int x=0; x<this.size; x++){
       for (int y=0; y<this.size; y++){
          pawnIsIN |= this.logic.hasPawn(x, y);
          knightIsIN |= this.logic.hasKnight(x,y);
        }
      }
    final boolean pIN = pawnIsIN;
    final boolean kIN = knightIsIN;
    assertAll(
      () -> assertEquals(true, pIN),
      () -> assertEquals(true, kIN));

  }

  @Test
  public void testPawnAndKnightMovesAreOut(){
    assertThrows(IndexOutOfBoundsException.class, () -> logic.hit(-1, 0));
  }

  @Test
  public void testPawnAndKnightPosAreDifferent(){
    Pair<Integer, Integer> pawnPos;
    Pair<Integer, Integer> knightPos;
    for (int x=0; x<this.size; x++){
      for (int y=0; y<this.size; y++){
        if(this.logic.hasPawn(x, y))  pawnPos = new Pair<Integer, Integer>(x,y);
        if(this.logic.hasKnight(x,y))  knightPos = new Pair<Integer, Integer>(x,y);
       }
     }
     boolean diff;
     if (pawnPos.getX() != knightPos.getX())  diff = true;

  }

}
