package 二叉树.节点之和的最大路径;
import 二叉树.TreeNode;

public class pathSum {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(9);
        TreeNode tree2 = new TreeNode(6);
        TreeNode tree3 = new TreeNode(-3);
        TreeNode tree4 = new TreeNode(-6);
        TreeNode tree5 = new TreeNode(2);
        TreeNode tree6 = new TreeNode(2);
        TreeNode tree7 = new TreeNode(-6);
        TreeNode tree8 = new TreeNode(-6);
        TreeNode tree9 = new TreeNode(-6);

        tree1.left = tree2; tree1.right = tree3;
        tree3.left = tree4; tree3.right = tree5;
        tree5.left = tree6;
        tree6.left = tree7; tree6.right = tree8;
        tree7.left = tree9;

        int res = maxPathSum(tree1);
        System.out.println(res);
    }

    public static class Info {
        public int maxPath1;
        public int maxPath2;
        public int res = 0;   //  可以设置为pathSum的成员变量
        boolean flag = false;  // 没有必要，为了逻辑更清晰而设置的。表示是否是空节点
        public Info(int maxpath1, int maxpath2, int res, boolean flag) {
            maxPath1 = maxpath1;
            maxPath2 = maxpath2;
            this.res = res;
            this.flag = flag;
        }
    }

    public static int maxPathSum(TreeNode root) {
        Info res = process(root);
        return res.res;
    }


    public static Info process(TreeNode node) {
        int res = 0;
        int maxPath1;
        int maxPath2;
        if(node==null) return new Info(res, res, Integer.MIN_VALUE, false);
        Info left = process(node.left);
        Info right = process(node.right);
        if(left.flag && right.flag) {
            maxPath1 = Math.max(Math.max(left.maxPath1 + node.val, right.maxPath1 + node.val), node.val);
            maxPath2 = left.maxPath1 + right.maxPath1 + node.val;
            res = Math.max(Math.max(maxPath1, maxPath2), Math.max(left.res, right.res));
        }
        else if(left.flag) {
            maxPath1 = Math.max(left.maxPath1 + node.val, node.val);
            maxPath2 = left.maxPath1 + node.val;
            res = Math.max(Math.max(maxPath1, maxPath2), left.res);
        }
        else if(right.flag) {
            maxPath1 = Math.max(right.maxPath1 + node.val, node.val);
            maxPath2 = right.maxPath1 + node.val;
            res = Math.max(Math.max(maxPath1, maxPath2), right.res);
        }
        else {
            maxPath1 = node.val;
            maxPath2 = node.val;
            res = node.val;
        }
        return new Info(maxPath1, maxPath2, res, true);
    }

    // 简化一点的代码：
//    public static class Info {
//        public int maxPath1;
//        public int maxPath2;
//        public int res = 0;
//        public Info(int maxpath1, int maxpath2, int res) {
//            maxPath1 = maxpath1;
//            maxPath2 = maxpath2;
//            this.res = res;
//        }
//    }
//    public static Info process(TreeNode node) {
//        int res = 0;
//        if(node==null) return new Info(res, res, Integer.MIN_VALUE);
//        Info left = process(node.left);
//        Info right = process(node.right);
//        int maxPath1 = Math.max(Math.max(left.maxPath1 + node.val, right.maxPath1 + node.val), node.val);
//        int maxPath2 = left.maxPath1 + right.maxPath1 + node.val;
//        res = Math.max(Math.max(maxPath1, maxPath2), Math.max(left.res, right.res));
//        return new Info(maxPath1, maxPath2, res);
//    }
}
