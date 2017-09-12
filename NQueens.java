import java.util.*;

public class NQueens {
    public static List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        solveNQueens(n, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void solveNQueens(int n, int row, List<Integer> colPlacement, List<List<Integer>> result) {
        if(row == n) {
            result.add(new ArrayList<>(colPlacement));
        }
        else {
            for(int col = 0; col < n; col++) {
                colPlacement.add(col);
                if(isValid(colPlacement)) {
                    solveNQueens(n, row+1, colPlacement, result);
                }
                // to do understand the reasoning behind it
                colPlacement.remove(colPlacement.size()-1);
            }
        }
    }

    private static boolean isValid(List<Integer> colPlacement) {
        int rowID = colPlacement.size() - 1;
        for(int i = 0; i < rowID; i++) {
            // to do reasoning behind calculating diff between last row
            int diff = Math.abs(colPlacement.get(i) - colPlacement.get(rowID));
            if(diff == 0 ||  diff == rowID - 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = nqueens(5);
        System.out.println(result);
    }
}