package com.algorithm.search;
import java.lang.*;

class Islands {
    static final int ROW = 5, COL = 5;
    int count = 0;
    boolean[][] visited = new boolean[ROW][COL];
    Islands() {
        for(int i = 0; i < ROW; i++) {
            visited[i][i] = false;
        }
    }
    int countIslands(int[][] lands) {
        for(int i = 0; i < lands.length; i++){
            for(int j = 0; j < lands.length; j++) {
                if(lands[i][j] == 1 && !visited[i][j]) {
                    dfsSearch(lands,i,j);
                    ++count;
                }
            }
        }
        return count;
    }

    void dfsSearch(int[][] lands, int row, int col) {
        visited[row][col] = true;
        int[] rows = {-1,-1,-1,0, 0,1,1,1};
        int[] cols = {-1, 0, 1,-1,1,-1,-1,0};
        for(int i = 0; i < rows.length; i++) {
            if(isSafe(rows[i] + row,col + cols[i],visited,lands)) {
                dfsSearch(lands,rows[i] + row,col + cols[i]);
            }
        }
    }
    boolean isSafe(int row, int col,boolean[][] visited,int[][] lands) {
        if(row >= 0 && row < ROW && col >= 0 && col < COL && !visited[row][col] && lands[row][col] == 1) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws java.lang.Exception
    {
        int M[][] = new int[][]
                { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        Islands I = new Islands();
        System.out.println("Number of islands is: " + I.countIslands(M));
    }
}
