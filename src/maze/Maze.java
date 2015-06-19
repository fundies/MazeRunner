/**
 *
 */
package maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Greg Williamson
 * @version 0.1
 *
 */
public class Maze {

    private final String[][] mMaze;
    private final int rows;
    private final int cols;
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;

    /**
     * Load a maze from text.
     *
     * @param filename file
     * @throws FileNotFoundException
     */
    public Maze(final File filename) throws FileNotFoundException {

        Scanner scan;
        try {
            scan = new Scanner(filename);
        } 
        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            throw e;
        }
        rows = scan.nextInt();
        cols = scan.nextInt();
        mMaze = new String[rows][cols];
        startX = scan.nextInt();
        startY = scan.nextInt();
        endX = scan.nextInt();
        endY = scan.nextInt();
        for (int i = 0; i < rows; i++) {
            String temp = scan.next();
            for (int j = 0; j < cols; j++) {
                mMaze[i][j] = "" + temp.charAt(j);

            }
        }
        scan.close();
    }

    /**
     * To string.
     *
     * @return string
     */
    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp = temp + mMaze[i][j] + " ";
            }
            temp = temp + '\n';
        }
        return temp;
    }

    /**
     * Search.
     *
     * @return solution
     */
    public final boolean search() {
        return searchMaze(startX, startY, -1);
    }

    /**
     * Search for exit.
     *
     * @param i i
     * @param j j
     * @param d d
     * @return exit
     */
    public final boolean searchMaze(final int i, final int j, final int d) {
        boolean ok = false;
        for (int k = 0; k < 4 && !ok; k++) {
            if (k == d) {
                continue;
            }
            switch (k) {
                // 0 = up, 1 = right, 2 = down, 3 = left
                case 0:
                    if (i > 0 && mMaze[i - 1][j].equals("a")) {
                        mMaze[i - 1][j] = "v";
                        ok = ok || searchMaze(i - 1, j, 2);
                    }
                    break;
                case 1:
                    if (j < rows - 1 && mMaze[i][j + 1].equals("a")) {
                        mMaze[i][j + 1] = "v";
                        ok = ok || searchMaze(i, j + 1, 3);
                    }
                    break;
                case 2:
                    if (i < cols - 1 && mMaze[i + 1][j].equals("a")) {
                        mMaze[i + 1][j] = "v";
                        ok = ok || searchMaze(i + 1, j, 0);
                    }
                    break;
                case 3:
                    if (j > 0 && mMaze[i][j - 1].equals("a")) {
                        mMaze[i][j - 1] = "v";
                        ok = (!(!ok && !searchMaze(i, j - 1, 1)));
                    }
                    break;
            }

        }

        if (i == endX && j == endY) {
            ok = true;
        }

        if (ok) {
            mMaze[i][j] = " ";
            switch (d) {
                case 0:
                    mMaze[i - 1][j] += " ";
                    break;
                case 1:
                    mMaze[i][j + 1] += " ";
                    break;
                case 2:
                    mMaze[i + 1][j] += " ";
                    break;
                case 3:
                    mMaze[i][j - 1] += " ";
                    break;
                default:
                    break;
            }
        }
        return ok;
    }
}
