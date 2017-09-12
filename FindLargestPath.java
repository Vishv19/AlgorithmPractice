import java.util.*;

public class FindLargestPath {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(100, 200, 300, 400));
        matrix.add(Arrays.asList(500, 600, 700, 800));
        matrix.add(Arrays.asList(900, 1000, 1100, 1200));
        matrix.add(Arrays.asList(1300, 1400, 1500, 1600));
        System.out.println(findLargestPath(matrix));
    }

    public static int findLargestPath(List<List<Integer>> matrix) {
        List<List<Integer>> pathValues = new ArrayList<>();
        pathValues.add(Arrays.asList(100, 200, 300, 400));
        pathValues.add(Arrays.asList(0, 0, 0, 0));
        pathValues.add(Arrays.asList(0, 0, 0, 0));
        pathValues.add(Arrays.asList(0, 0, 0, 0));
        for(int i = 0; i < matrix.size()-1; i++) {
            for(int j = 0; j < matrix.get(i).size(); j++) {
                visitPath(matrix, pathValues, i, j);
            }
        }
        int size = pathValues.size();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < pathValues.get(size-1).size(); i++) {
            if(pathValues.get(size-1).get(i) > max) {
                max = pathValues.get(size-1).get(i);
            }
        }
        return max;
    }

    public static boolean isValidPath(List<List<Integer>> matrix, int x, int y) {
        if(x < 0 || x>=matrix.size() || y < 0 || y>=matrix.get(x).size()) {
            return false;
        }
        return true;
    }

    public static void visitPath(List<List<Integer>> matrix, List<List<Integer>> pathValues,int x, int y) {
        for(int k=-1;k<2;k++) {
            if(isValidPath(matrix, x+1, y+k)) {
                System.out.println("Parent pos: " + (x) + " " + (y));
                System.out.println("Current pos: " + (x+1) + " " + (y+k));
                int pathsum = pathValues.get(x).get(y) + matrix.get(x+1).get(y+k);
                System.out.println(pathsum);
                if(pathsum > pathValues.get(x+1).get(y+k)) {
                    pathValues.get(x+1).set(y+k,pathsum);
                }
            }
        }
    }
}