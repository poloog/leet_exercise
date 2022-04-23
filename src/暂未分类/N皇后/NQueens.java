package 暂未分类.N皇后;


import java.util.LinkedList;
import java.util.List;

// N皇后问题
public class NQueens {
    public List<List<String>> res = new LinkedList<>();

    public List<List<String>> nQueens(int n) {   // 返回各种排列  ["..Q..", ".Q..."]
        int r = nq1(n);
        return res;

    }

    public void genList(int[] record) {
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < record.length; i++) {
            String s = "";
            for (int j = 0; j < record.length; j++) {
                if (j == record[i]) {
                    s = s + "Q";
                } else {
                    s = s + ".";
                }
            }
            ans.add(s);
        }
        res.add(ans);
    }

    //--------------------------------------------------
    public int nq1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process1(0, record, n);
    }

    public int process1(int i, int[] record, int n) {
        if (i == n) {
            genList(record);
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i+1, record, n);
            }
        }
        return res;
    }

    public boolean isValid(int[] record, int i, int j) {
        // 遍历第i层前面的层，看看行不行
        for (int k = 0; k < i; k++) {
            if (record[k] == j || Math.abs(record[k] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }
    //---------------------------------------------------------

    // 用位运算优化，所以n>32是不行的
    public int nq2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int limit = n == 32 ? -1 : (1<<n) - 1;   // -1的二进制是32个1.
        return process2(limit, 0, 0, 0);
    }

    // 7皇后问题
    // limit : 0....0 1 1 1 1 1 1 1
    // 之前皇后的列影响：colLim
    // 之前皇后的左下对角线影响：leftDiaLim
    // 之前皇后的右下对角线影响：rightDiaLim
    public static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {
            return 1;
        }
        // pos中所有是1的位置，是你可以去尝试皇后的位置
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(limit, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }


}
