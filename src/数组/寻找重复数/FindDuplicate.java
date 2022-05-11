package 数组.寻找重复数;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        } while(fast != slow);
        slow = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
