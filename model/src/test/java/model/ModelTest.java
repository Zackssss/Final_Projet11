package model;

import org.junit.Before;
import org.junit.Test;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ModelTest {

    private Model modelUnderTest;

    @Before
    public void setUp() throws SQLException {
        modelUnderTest = new Model();
    }

    @Test
    public void testGetInfos() throws Exception {
        // Setup
        final int expectedResult = 10;

        // Run the test
        final int result = modelUnderTest.getInfos();

        // Verify the results
        assertEquals(expectedResult, result);
    }



    @Test(expected = SQLException.class)
    public void testGetSize_ThrowsSQLException() throws Exception {
        // Setup

        // Run the test
        modelUnderTest.getSize();
    }

    @Test
    public void testSetMap() throws Exception {
        // Setup
        final int ID = 0;

        // Run the test
        modelUnderTest.setMap(ID);

        // Verify the results
    }




    @Test
    public void testIsFalling() {
        // Setup

        // Run the test
        modelUnderTest.isFalling();

        // Verify the results
    }

    @Test
    public void testMonsterOrder() {
        // Setup

        // Run the test
        modelUnderTest.monsterOrder();

        // Verify the results
    }

    @Test
    public void testSlip() {
        // Setup

        // Run the test
        modelUnderTest.slip();

        // Verify the results
    }

    @Test
    public void testDeath() throws Exception {
        // Setup

        // Run the test
        modelUnderTest.death();

        // Verify the results
    }


    @Test
    public void testWin() throws Exception {
        // Setup

        // Run the test
        modelUnderTest.win();

        // Verify the results
    }

}
