package 数组.旋转函数;

public class MaxRotateFunction {
    public int maxRotateFunction(int[] nums) {
        int len = nums.length;
        // 计算sum(nums)
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        // 计算初始值
        int cur = 0;
        for (int j = 0; j < len; j++) {
            cur += nums[j] * (j);
        }
        int res = cur;

        // 循环，计算所有的情况，更新res。
        for (int k = 1; k < len; k++) {
            cur = cur + sum - nums[len-k] * len;
            if (cur > res) res = cur;
        }
        return res;
    }
}
