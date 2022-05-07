package 动态规划.打家劫舍;

public class Rob1 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        //int res = process(nums, 0);
        int res = dp(nums);
        return res;
    }

    public int process(int[] nums, int cur_index) {
        if (cur_index == nums.length - 1) return nums[cur_index];
        if (cur_index == nums.length - 2) return Math.max(nums[cur_index], nums[cur_index + 1]);
        int rob = nums[cur_index] + process(nums, cur_index + 2);
        int not_rob = process(nums, cur_index + 1);
        return Math.max(rob, not_rob);
    }

    public int dp(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[len-1] = nums[len - 1];
        dp[len - 2] = Math.max(nums[len - 2], nums[len-1]);
        for (int i = len - 3; i >= 0; i--) {
            int a = nums[i] + dp[i + 2];
            int b = dp[i + 1];
            dp[i] = Math.max(a, b);
        }
        return dp[0];
    }
}
