public class LongestCommonSubSequence {
    public static int lcs(char[] a, char[] b, int m, int n) {
        int[][] res = new int[m+1][n+1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                // if(i == 0 || j == 0) {
                //     res[i][j] = 0;
                // }
                if(a[i-1] == b[j-1]) {
                    res[i][j] = res[i-1][j-1] + 1;
                }
                else {
                    res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
                }
            }
        }

        int xPos = m;
        int yPos = n;

        while(xPos != 0 && yPos != 0) {
            
        }
        return res[m][n];
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        System.out.println("lcs of a and b is: " + lcs(a,b,a.length,b.length));
    }
}