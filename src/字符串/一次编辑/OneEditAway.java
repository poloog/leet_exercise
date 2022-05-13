package 字符串.一次编辑;

public class OneEditAway {
    public boolean oneEditAway(String first, String second) {
        int m = first.length();
        int n = second.length();
        int a = Math.abs(m - n);
        if (a != 0 && a != 1) return false;
        boolean flag = true;
        if (a == 0) {
            for (int i = 0; i < m; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (flag) flag = false;
                    else return false;
                }
            }
            return true;
        }
        else {
            int len = Math.min(n, m);
            if (m > n) {
                String t = second;
                second = first;
                first = t;
            }
            int j = 0;
            int k = 0;
            while (j < len) {
                if (first.charAt(j) != second.charAt(k)) {
                    if (flag) {
                        flag = false;
                        k++;
                        continue;
                    }
                    else return false;
                }
                j++;
                k++;
            }
            return true;
        }
    }
}
