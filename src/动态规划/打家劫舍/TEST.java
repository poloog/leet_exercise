package 动态规划.打家劫舍;

public class TEST {
    public static void main(String[] args) {
        int[] input = new int[]{2,1,1,2};
        Rob1 rob1 = new Rob1();
        int res = rob1.rob(input);
        System.out.println(res);
    }
}
