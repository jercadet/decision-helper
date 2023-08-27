import model.ConsT;
import model.ITally;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the methods in the {@code model.ConsT} class
 */
public class ConsTTest {

    ITally testCon;

    // Initialize a test example of a model.ConsT
    private void initData() {
        testCon = new ConsT("This is a test", 1);
    }

    // Tests if creating a null description returns an error
    @Test(expected = IllegalArgumentException.class)
    public void testDescNull() {
        ITally testNull = new ConsT(null, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDescNullQuote() {
        ITally testEmpty = new ConsT("", 3);
    }

    // Tests if creating a empty description (like " ") returns an error
    @Test(expected = IllegalArgumentException.class)
    public void testDescEmpty() {
        ITally testEmpty = new ConsT(" ", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDescEmptyTwoSpaces() {
        ITally testEmpty = new ConsT("  ", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDescEmptyMoreSpaces() {
        ITally testEmpty = new ConsT("         ", 3);
    }

    // Tests if getDesc method returns a String correctly
    @Test
    public void testGetDesc() {
        this.initData();
        String test = testCon.getDesc();
        assertEquals("This is a test", test);
    }

    // Tests if a Weight is not 1, 2, or 3
    @Test(expected = IllegalArgumentException.class)
    public void testWeightZero() {
        ITally testEmpty = new ConsT("Testing", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWeightNegative() {
        ITally testEmpty = new ConsT("Testing", -2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWeightMoreThanThree() {
        ITally testEmpty = new ConsT("Testing", 4);
    }

    // Tests if getWeight method returns a weight correctly as an integer
    @Test
    public void testGetWeight() {
        this.initData();
        int test = testCon.getWeight();
        assertEquals(1, test);
    }
}
