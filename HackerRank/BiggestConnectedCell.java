import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BiggestConnectedCell {
    
    public static int getBiggestRegion(int[][] matrix) {
//        int count = 0;
        int currentCount = 0;
        int maxCount = 0;
        boolean visited[][] = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i< matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==1 && !visited[i][j]) {
                    currentCount = dfs(matrix, i, j, visited);
//                    count++;
//                    System.out.println(currentCount);
                    if(currentCount > maxCount) {
                        maxCount = currentCount;
                    }
                }
            }
        }
        return maxCount;
    }
    
    public static int dfs(int[][] matrix, int row, int column, boolean visited[][]) {
        int[] rowPos = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colPos = {-1, 0, 1, -1, 1, -1, 0, 1};
        int currentCount = 1;
        visited[row][column] = true;
        for(int i = 0; i < 8; i++) {
            if(isSafe(row+rowPos[i], column+colPos[i], matrix.length, matrix[0].length, matrix, visited)) { 
                currentCount += dfs(matrix, row+rowPos[i], column+colPos[i], visited);
                //count++;
            }
        }
        return currentCount;
    }
    
    public static boolean isSafe(int row, int column, int rowSize, int colSize, int matrix[][], boolean visited[][]) {
        return (row >= 0 && row < rowSize && column >= 0 && column < colSize && matrix[row][column] == 1 && !visited[row][column]);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}

