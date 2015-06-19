package maze;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Greg Williamson
 * @version 0.1
 */
public class MazeRunner {
    /**
     * Main Function.
     * @param args args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        Maze maze = new Maze(new File("maze1.txt"));
        System.out.println(maze);
        maze.search();
        System.out.println(maze);
    }
}
