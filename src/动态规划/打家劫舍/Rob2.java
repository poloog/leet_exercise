package 动态规划.打家劫舍;

public class Rob2 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        //int res = process(nums, 0, false);
        int res = dp(nums);
        return res;
    }

    public int process(int[] nums, int cur_index, boolean first) {
        if (cur_index == nums.length - 1) {
            if (first) return 0;
            else return nums[cur_index];
        }
        if (cur_index == nums.length - 2) {
            if (first) return nums[cur_index];
            else return Math.max(nums[cur_index], nums[cur_index + 1]);
        }
        if (cur_index == 0) {
            int rob = nums[cur_index] + process(nums, cur_index + 2, true);
            int not_rob = process(nums, cur_index + 1, false);
            return Math.max(rob, not_rob);
        } else {
            int rob = nums[cur_index] + process(nums, cur_index + 2, first);
            int not_rob = process(nums, cur_index + 1, first);
            return Math.max(rob, not_rob);
        }
    }

    public int dp(int[] nums) {
        int len = nums.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp1[len - 1] = 0;
        dp1[len - 2] = nums[len - 2];
        dp2[len - 1] = nums[len - 1];
        dp2[len - 2] = Math.max(nums[len - 1], nums[len - 2]);
        for (int i = len - 3; i >= 0; i--) {
            if (i == 0) {
                dp1[i] = nums[i] + dp1[i + 2];
                dp2[i] = dp2[i + 1];
            } else {
                dp1[i] = Math.max(nums[i] + dp1[i + 2], dp1[i + 1]);
                dp2[i] = Math.max(nums[i] + dp2[i + 2], dp2[i + 1]);
            }
        }
        return Math.max(dp1[0], dp2[0]);
    }
}
