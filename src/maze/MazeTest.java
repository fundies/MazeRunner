/**
 *
 */
package maze;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.junit.Test;

/**
 * @author Greg Williamson
 * @version 0.1
 *
 */
public class MazeTest {

    /**
     * Test the mazes.
     *
     * @throws FileNotFoundException
     * @throws URISyntaxException
     */
    @Test
    public final void test() throws FileNotFoundException, URISyntaxException {
        Maze maze;
        maze = new Maze(new File("maze1.txt"));
        assertEquals(maze.search(), true);

        String solution = "";

        Scanner scan = new Scanner(new File("maze1_solution.txt"));
        scan.useDelimiter(" ");
        while (scan.hasNext()) {
            solution += scan.next() + " ";
        }
        solution = solution.substring(0, solution.length() - 1);
        scan.close();

        assertEquals(maze.toString().trim(), solution);

        maze = new Maze(new File("maze2.txt"));
        assertEquals(maze.search(), false);

        maze = new Maze(new File("maze3.txt"));
        assertEquals(maze.search(), true);

    }

    /**
     * Test bad file.
     *
     * @throws FileNotFoundException
     */
    @Test(expected = FileNotFoundException.class)
    public final void testBadFile() throws FileNotFoundException {
        new Maze(new File(""));
        fail("expected exception");
    }
}
