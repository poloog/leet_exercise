package 暂未分类.括号生成;

import java.util.LinkedList;
import java.util.List;

public class GennerateParenthesis {
    public List<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        String str = "";
        dfs(0, 0, str, n);
        return res;
    }

    public void dfs(int left, int right, String str, int n) {
        if (str.length() == n * 2) {
            res.add(str);
            return;
        }
        if (left < n) dfs(left + 1, right, str + "(", n);
        if (right < left) dfs(left, right + 1, str + ")", n);
    }
}
