import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by BHarris on 3/3/17.
 */
public class CalculatorTest {
    Meal m = new Meal(1, 10, 34.9, 20, 30.4, 42.4);
    Calculator c = new Calculator(m);

    @Test
    public void testCorrectionFactorPercent(){
        assertTrue(c.correctionFactorPercent() == 0.02865329512893983);
    }

    @Test
    public void testCarbUnit(){
        assertTrue(c.carbUnit() == 2);
    }

    @Test
    public void testFatProteinUnit(){
        assertTrue(c.fatProteinUnit() == 5.031999999999999);
    }

    @Test
    public void testHalfPieceCarbUnit(){
        assertTrue(c.halfPieceCarbUnit() == 2);
    }

    @Test
    public void halfPieceFatProteinUnit(){
        assertTrue(c.halfPieceFatProteinUnit() == 5);
    }


}
