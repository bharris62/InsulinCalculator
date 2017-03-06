import org.junit.Test;
import static org.junit.Assert.*;

public class MealTest {
    Meal m = new Meal(1,10, 34.9, 20, 30.4, 42.4);

    @Test
    public void testConstructor(){
        Meal m = new Meal(1, 10, 34.9, 20, 30.4, 42.4);
        assertTrue(m != null);

    }
    @Test
    public void testInsulinRatioGet(){
        assertTrue(m.getInsulinRatio() == 10);
    }

    @Test
    public void testGetCarb(){
        assertTrue(m.getCarb() == 20);
    }

    @Test
    public void testGetProtein(){
        assertTrue(m.getProtein() == 30.4);
    }

    @Test
    public void testgetfat(){
        assertTrue(m.getFat() == 42.4);
    }

    @Test
    public void testGetCorrectionFactor(){
        assertTrue(m.getCorrectionFactor() == 34.9);
    }

    @Test
    public void testInsulinRatioSet(){
        m.setInsulinRatio(25);
        assertTrue(m.getInsulinRatio() == 25);
    }

    @Test
    public void testSetCarb(){
        m.setCarb(33);
        assertTrue(m.getCarb() == 33);
    }

    @Test
    public void testSetProtein(){
        m.setProtein(97.3);
        assertTrue(m.getProtein() == 97.3);
    }

    @Test
    public void testSetfat(){
        m.setFat(33.1);
        assertTrue(m.getFat() == 33.1);
    }

    @Test
    public void testSetCorrectionFactor(){
        m.setCorrectionFactor(78);
        assertTrue(m.getCorrectionFactor() == 78);
    }


}
