package org.indolphin.algorithm;

import org.junit.Test;

public class RecursionTest {

    @Test
    public void mazeTest() {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        Maze maze = new Maze(map, 6,5);
        maze.printMaze();
        maze.lookForwardPath(1,1);
        System.out.println("");
        maze.printMaze();
    }
}
