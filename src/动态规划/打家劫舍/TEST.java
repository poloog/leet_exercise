package 动态规划.打家劫舍;

public class TEST {
    public static void main(String[] args) {
        int[] input = new int[]{2,3,2};
        Rob1 rob1 = new Rob1();
        Rob2 rob2 = new Rob2();
        int res = rob2.rob(input);
        System.out.println(res);
    }
}
