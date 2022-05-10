package 动态规划.打家劫舍;
import 二叉树.TreeNode;

import java.util.HashMap;

public class Rob3 {
    public int rob(TreeNode tree) {
        if (tree == null) return 0;
        //int res = process1(tree);

        //HashMap<TreeNode, Integer> map = new HashMap<>();
        //int res = process2(tree, map);

        int res = process3(tree).Res();

        return res;
    }

    // 暴力法
    public int process1(TreeNode tree) {
        if (tree == null) return 0;
        int res = tree.val;
        if (tree.left != null) res += process1(tree.left.left) + process1(tree.left.right);
        if (tree.right != null) res += process1(tree.right.left) + process1(tree.right.right);
        res = Math.max(res, process1(tree.left) + process1(tree.right));
        return res;
    }

    // 记忆化搜索
    public int process2(TreeNode tree, HashMap<TreeNode, Integer> map) {
        if (tree == null) return 0;
        if (map.containsKey(tree)) return map.get(tree);
        int res = tree.val;
        if (tree.left != null) res += process2(tree.left.left, map) + process2(tree.left.right, map);
        if (tree.right != null) res += process2(tree.right.left, map) + process2(tree.right.right, map);
        res = Math.max(res, process2(tree.left, map) + process2(tree.right, map));
        map.put(tree, res);
        return res;
    }


    // 动态dp
    public class InFo {
        int[] dp = new int[2];  // index=0 偷  index=1 不偷
        public InFo (int rob, int not_rob) {
            dp[0] = rob;
            dp[1] = not_rob;
        }

        public int Res() {
            return Math.max(dp[0],dp[1]);
        }

        public int rob() {
            return dp[0];
        }

        public int not_rob() {
            return dp[1];
        }
    }

    public InFo process3(TreeNode tree) {
        if (tree == null) return new InFo(0, 0);
        InFo left = process3(tree.left);
        InFo right = process3(tree.right);
        int rob = tree.val + left.not_rob() + right.not_rob();
        int not_rob = left.Res() + right.Res();
        return new InFo(rob, not_rob);
    }
}
