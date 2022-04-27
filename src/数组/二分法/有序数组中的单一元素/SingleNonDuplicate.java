package 数组.二分法.有序数组中的单一元素;

public class SingleNonDuplicate {
    public static void main(String[] agrs) {
        int[] input = new int[]{1,1,2,2,4,4,5,5,9};
        int res = singleNonDuplicate(input);
        System.out.println(res);
    }

    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (mid % 2 == 0) {
                if (mid + 1 < n && nums[mid] == nums[mid + 1]) l = mid + 1;
                else r = mid;
            } else {
                if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) l = mid + 1;
                else r = mid;
            }
        }
        return nums[r];
    }
}

