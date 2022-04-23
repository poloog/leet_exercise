package 动态规划.最长公共子序列;

public class LongestCommonSubsequence {
    public int longestSubsequence(String s1, String s2) {
        int len_s1 = s1.length();
        int len_s2 = s2.length();
        int[][] dp = new int[len_s1 + 1][len_s2 + 1];
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        for (int i = 1; i <= len_s1; i++) {
            for (int j = 1; j <= len_s2; j++) {
                if (ch1[i-1] == ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len_s1][len_s2];
    }
}
