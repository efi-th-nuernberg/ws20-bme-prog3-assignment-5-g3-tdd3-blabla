import org.junit.Test;
import static org.junit.Assert.*;

public class LifeTest {
    
    @Test
    public void createNewCell() {
        
        // Arrange: drei lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);

        // Act: Berechnung der Folgegeneration
        ILife nextGener = l.nextGeneration();

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben


        assertTrue(nextGener.isAlive(1, 1));
    }

/*
    @Test
    public void destroyLonelyCell() {
      Life l = new Life();
        l.setAlive(0, 0);
        

          ILife nextGen = l.nextGeneration();
         //assertTrue(nextGen.isDead(1, 1));
       
    }


    @Test
    public void keepAliveCell() {
      Life l = new Life();
        l.setAlive(0, 0);
       // l.setAlive(0, 1);

        // ILife nextGen = l.nextGeneration();
         //assertTrue(nextGen.isAlive(1, 1));
    }


    @Test
    public void destroyCrowdedCell() {
      Life l = new Life();
      l.setAlive(0, 0);
      l.setAlive(0, 1);
      l.setAlive(0, 2);
      l.setAlive(1, 0);

      // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        //assertTrue(nextGen.isDead(1, 1));
    }

*/
}
