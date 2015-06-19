/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Greg Williamson
 * @version 0.1
 */
public class MazeRunnerTest {
    
    /**
     * Test of main method, of class MazeRunner.
     * @throws java.lang.Exception
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        new MazeRunner();
        MazeRunner.main(args);
        boolean t = true;
        assertEquals(t, true);
    }
    
}
