package com.caozeal.leetcode.before20230324;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 示例 1:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * 提示：
 *
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 *
 * @author Zhiyong Cao
 * @since 1.0.0
 */
public class MaxValue {

    public static void main(String[] args) {
        MaxValue value = new MaxValue();
        System.out.println(value.maxValue1(new int[][]{{1,3,1}, {1,5,1}}));
    }

    public int maxValue(int[][] grid) {
        int lengthX = grid.length;
        int lengthY = grid[0].length;
        int[][] bak = new int[lengthX][lengthY];
        bak[0][0] = grid[0][0];
        for (int i = 0; i < lengthX + lengthY -1; i++) {
            for (int x = Math.max(0, i - lengthY +1); x <= Math.min(i, lengthX-1); x++) {
                int y = i - x;
                if(x < lengthX-1){
                    bak[x+1][y] = Math.max(bak[x][y] + grid[x+1][y], bak[x+1][y]);
                }
                if(y < lengthY-1){
                    bak[x][y+1] = Math.max(bak[x][y] + grid[x][y+1], bak[x][y+1]);
                }
            }
        }
        return bak[lengthX-1][lengthY-1];
    }

    public int maxValue1(int[][] grid) {
        int lengthX = grid.length;
        int lengthY = grid[0].length;
        for (int i = 1; i < lengthX + lengthY -1; i++) {
            for (int x = Math.max(0, i - lengthY +1); x <= Math.min(i, lengthX-1); x++) {
                int y = i - x;
                if(x == 0){
                    grid[x][y] = grid[x][y-1] + grid[x][y];
                    continue;
                }
                if(y == 0){
                    grid[x][y] = grid[x-1][y] + grid[x][y];
                    continue;
                }
                grid[x][y] = Math.max( grid[x][y-1], grid[x-1][y]) + grid[x][y];
            }
        }
        return grid[lengthX-1][lengthY-1];
    }
}
