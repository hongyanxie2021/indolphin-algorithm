package org.indolphin.algorithm;

/**
 * 迷宫路径问题
 * 使用 递归和回溯
 * @author hongyan
 */
public class Maze {
    private int[][] map;
    private int endPointX;
    private int endPointY;

    public Maze(int[][] data, int endPointX, int endPointY) {
        this.map = data;
        this.endPointX = endPointX;
        this.endPointY = endPointY;
    }

    /**
     * i,j表示从地图的哪个位置开始出发（1,1）
     * 如果小球能到map[6][5]位置，则说明通路找到
     * 约定：map[i][j]为0表示该点没有走过，为1表示墙，2表示通路可达，3表示该点已经走过，但走不通
     * 下-右-上-左 走不通再回溯
     * @param i 起始点i
     * @param j 起始点j
     */
    public boolean lookForwardPath(int i, int j) {
        if(map[endPointX][endPointY] == 2) {
            return true;
        } else {
            if(map[i][j] == 0) {
                map[i][j] = 2;
                if(lookForwardPath(i+1, j)) {
                    return true;
                } else if(lookForwardPath(i,j+1)) {
                    return true;
                } else if(lookForwardPath(i-1,j)) {
                    return true;
                } else if(lookForwardPath(i,j-1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                // 此时map[i][j] = 1/2/3, 1/3表示不通，2表示这个点是当前递归路径已走过的点不能再走，所以返回false
                return false;
            }
        }
    }

    public void printMaze() {
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
