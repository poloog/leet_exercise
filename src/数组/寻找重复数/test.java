package 数组.寻找重复数;

public class test {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,4,2,2};
        FindDuplicate b = new FindDuplicate();
        int res = b.findDuplicate(a);
        System.out.println(res);
    }
}
