package 字符串.不同的子序列;

public class test {
    public static void main(String[] args) {
        NumDistinct test = new NumDistinct();
        String s = "dbaaadcddccdddcadacbadbadbabbbcad";
        String t = "dadcccbaab";
        int res = test.numDistinct(s, t);
        System.out.println(res);
    }
}
