import java.util.*;

public class NumberWays {
    public static int numberOfWays(int n, int m) {
        return computeNumberOfWaysToXY(n-1, m-1, new int[n][m]);
    }

    public static int computeNumberOfWaysToXY(int x, int y, int[][] numberOfWays) {
        if(x==0 || y== 0) {
            return 1;
        }

        if(numberOfWays[x][y] == 0) {
            int waysTop = x == 0 ? 0: computeNumberOfWaysToXY(x-1, y, numberOfWays);
            int waysLeft = x == 0 ? 0: computeNumberOfWaysToXY(x, y-1, numberOfWays);

            numberOfWays[x][y] = waysLeft + waysTop;
        }
        System.out.println(numberOfWays[x][y]);
        return numberOfWays[x][y];
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(5,5));
    }
}