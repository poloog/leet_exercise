package 数组.最短无序连续子数组;

public class FindUnsortedSubarray {
    public static void main(String[] args) {
        int[] in = new int[]{2,3,3,2,4};
        int res = findUnsortedSubarray(in);
        System.out.println(res);
    }
    public static int findUnsortedSubarray(int[] nums) {
        int left_cur = 0;
        int right_cur = nums.length - 1;
        while (left_cur<nums.length-1 && nums[left_cur] <= nums[left_cur + 1]) left_cur++;
        while (right_cur>0 && nums[right_cur] >= nums[right_cur - 1]) right_cur--;
        if (left_cur >= right_cur) return 0;
        int index = left_cur;
        while (index <= right_cur) {
            while (left_cur>0 && nums[index] < nums[left_cur - 1]) {
                left_cur--;
            }
            while (right_cur<nums.length-1 && nums[index] > nums[right_cur + 1]) {
                right_cur++;
            }
            index++;
        }
        return right_cur - left_cur + 1;
    }
}
