package 暂未分类.单词接龙;

public class test {
    public static void main(String[] args) {
        MinMutation test = new MinMutation();
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = new String[]{"AACCGGTA"};
        int res = test.minMutation(start, end, bank);
        System.out.println(res);
    }
}
