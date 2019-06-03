package model;

import org.junit.Before;
import org.junit.Test;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * The TestClass ModelTest
 *
 * @author Team11
 */

public class ModelTest {

    /** modelUndertest */

    private Model modelUnderTest;

    /**
     * This method runs before each test.
     *
     * @throws SQLException
     *                  the SQlException
     */

    @Before
    public void setUp() throws SQLException {
        modelUnderTest = new Model();
    }

    /**
     * Checks if the result of GetInfos is 10 as expected.
     *
     * @throws Exception
     *              the Exception
     */

    @Test
    public void testGetInfos() throws Exception {
        /* Setup */
        final int expectedResult = 10;

        /* Run the test */
        final int result = modelUnderTest.getInfos();

        /* Verify the results */
        assertEquals(expectedResult, result);
    }

    /**
     * Test if getSize runs correctly.
     *
     * @throws Exception
     *          the Exception
     */

    @Test(expected = SQLException.class)
    public void testGetSize_ThrowsSQLException() throws Exception {
        /* Setup */

        /* Run the test */
        modelUnderTest.getSize();
    }

    /**
     * Test if the setMap runs correctly.
     *
     * @throws Exception
     *              the Exception
     */
    @Test
    public void testSetMap() throws Exception {
        // Setup
        final int ID = 0;

        // Run the test
        modelUnderTest.setMap(ID);

        // Verify the results
    }

    /**
     *  Test if isFalling runs correctly.
     *
     */

    @Test
    public void testIsFalling() {
        // Setup

        // Run the test
        modelUnderTest.isFalling();

        // Verify the results
    }

    /**
     * Test if monsterOrder runs correctly.
     *
     */

    @Test
    public void testMonsterOrder() {
        // Setup

        // Run the test
        modelUnderTest.monsterOrder();

        // Verify the results
    }

    /**
     * Test if slip runs correctly.
     *
     */

    @Test
    public void testSlip() {
        // Setup

        // Run the test
        modelUnderTest.slip();

        // Verify the results
    }

    /**
     * Test if death runs correctly.
     *
     * @throws Exception
     *              the Exception
     */

    @Test
    public void testDeath() throws Exception {
        // Setup

        // Run the test
        modelUnderTest.death();

        // Verify the results
    }

    /**
     * Test if death runs correctly.
     *
     * @throws Exception
     *              the Exception
     */

    @Test
    public void testWin() throws Exception {
        // Setup

        // Run the test
        modelUnderTest.win();

        // Verify the results
    }

}
