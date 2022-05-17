package 暂未分类.最大正方形;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') dp[0][i] = 1;
            res = Math.max(res, dp[0][i]);
        }
        for (int j = 0; j <m ; j++) {
            if (matrix[j][0] == '1') dp[j][0] = 1;
            res = Math.max(res, dp[j][0]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') dp[i][j] = 0;
                else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res*res;
    }
}
