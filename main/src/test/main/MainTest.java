package main;

import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The TestClass of Maintest
 *
 * @author Team11
 */

public class MainTest {

    /**
     * Test if the main builds.
     *
     * @throws Exception
     *              the Exception
     */

    @Test
    public void testMain() throws Exception {
        /** Setup */
        final String[] args = new String[]{};

        /** Run the test */
        Main.main(args);

        /** Verify the results */
    }

    /**
     * Test if the IOExceptions are thrown correctly
     *
     * @throws Exception
     */

    @Test(expected = IOException.class)
    public void testMain_ThrowsIOException() throws Exception {

        /** Setup */
        final String[] args = new String[]{};

        /** Run the test */
        Main.main(args);
    }

    /**
     * Test if the SQLExceptions are thrown correctly
     *
     * @throws Exception
     */

    @Test(expected = SQLException.class)
    public void testMain_ThrowsSQLException() throws Exception {
        /** Setup */
        final String[] args = new String[]{};

        /** Run the test */
        Main.main(args);
    }

    /**
     * Test if the InterruptedExceptions are thrown correctly
     *
     * @throws Exception
     */

    @Test(expected = InterruptedException.class)
    public void testMain_ThrowsInterruptedException() throws Exception {
        /** Setup */
        final String[] args = new String[]{};

        /** Run the test */
        Main.main(args);
    }
}
