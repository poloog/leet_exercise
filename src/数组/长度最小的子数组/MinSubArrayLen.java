package 数组.长度最小的子数组;

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (left <= right && right <nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                res = Math.min(res, right-left);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
