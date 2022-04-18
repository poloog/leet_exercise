package 暂未分类.字典序排数;

import java.util.LinkedList;
import java.util.List;

public class LexicalOrder {
    public static void main(String[] args) {
        int n = 89;
        List<Integer> list = lexicalOrder2(n);
        System.out.println(list);
    }

    // 递归变量字典树
    public static List<Integer> lexicalOrder1(int n) {
        List<Integer> res = new LinkedList<>();
        for(int i=1; i<=9; i++) dfs(i, n, res);
        return res;
    }
    public static void dfs(int i, int limit, List<Integer> list) {
        if (i > limit) return;
        list.add(i);
        for(int j=0; j<=9; j++) dfs(i*10+j, limit, list);
    }

    //迭代
    public static List<Integer> lexicalOrder2(int n) {
        List<Integer> res = new LinkedList<>();
        for (int i=0, j=1; i < n; i++) {
            res.add(j);
            if(j * 10 <= n) {
                j*= 10;
            } else {
                // 回退j
                while (j % 10 == 9 || j + 1 > n) j /= 10;
                j++;
            }
        }
        return res;
    }
}
