package 暂未分类.不同路径;

public class UniquePaths {
    int res;
    public int uniquePaths(int m, int n) {
        process1(0, 0, m - 1, n - 1);
        return res;
    }

    public void process1(int x, int y , int m, int n) {
        if (x == m && y == n) {
            res++;
            return;
        }
        if (x < m) process1(x + 1, y, m, n);
        if (y < n) process1(x, y + 1, m, n);
    }

    public int process2(int x, int y, int m, int n) {
        if (x == m &&y == n) return 1;
        int res = 0;
        if (x < m) res += process2(x + 1, y, m, n);
        if (y < n) res += process2(x, y + 1, m, n);
        return res;
    }

    public int dp(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[m][n] = 1;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i < m) dp[i][j] += dp[i + 1][j];
                if (j < n) dp[i][j] += dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}
