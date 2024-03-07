package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import e1.Logics;

public class LogicTest {

  private Pair<Integer,Integer> pawn;
  private Pair<Integer,Integer> knight;
  private int size;
  private Logics logic;

  @BeforeEach
  public void initializeLogic(){
   this.size = 5;
   this.pawn = new Pair<Integer,Integer>(1, 2);
   this.knight= new Pair<Integer,Integer>(0, 0);
   this.logic = new LogicsImpl(size, this.pawn, this.knight);
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

    boolean diff = false;
    for (int x=0; x<this.size; x++){
      for (int y=0; y<this.size; y++){
        if(this.logic.hasPawn(x, y))  this.pawn = new Pair<Integer, Integer>(x,y);
        if(this.logic.hasKnight(x,y))  this.knight = new Pair<Integer, Integer>(x,y);
       }
     }
     if (this.pawn != this.knight)  diff = true;
     assertEquals(true, diff);
    }
   @Test
   public void testKnightHitPawn(){
    boolean result = logic.hit(1, 2);
    assertEquals(true, result);
   }

}
