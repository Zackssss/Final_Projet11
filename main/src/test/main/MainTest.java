package main;

import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
/**
*@author jbschmitt
*@author plbaillet
*/
public class MainTest {

    @Test
    public void testMain() throws Exception {
        // Setup
        final String[] args = new String[]{};

        // Run the test
        Main.main(args);

        // Verify the results
    }

    @Test(expected = IOException.class)
    public void testMain_ThrowsIOException() throws Exception {
        // Setup
        final String[] args = new String[]{};

        // Run the test
        Main.main(args);
    }

    @Test(expected = SQLException.class)
    public void testMain_ThrowsSQLException() throws Exception {
        // Setup
        final String[] args = new String[]{};

        // Run the test
        Main.main(args);
    }

    @Test(expected = InterruptedException.class)
    public void testMain_ThrowsInterruptedException() throws Exception {
        // Setup
        final String[] args = new String[]{};

        // Run the test
        Main.main(args);
    }
}
