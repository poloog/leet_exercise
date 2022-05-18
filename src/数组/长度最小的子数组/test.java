package 数组.长度最小的子数组;

public class test {
    public static void main(String[] args) {
        MinSubArrayLen test = new MinSubArrayLen();
        int[] input = new int[]{2,3,1,2,4,3};
        int target = 7;
        int res = test.minSubArrayLen(target, input);
        System.out.println(res);
    }
}
