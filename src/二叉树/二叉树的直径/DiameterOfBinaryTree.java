package 二叉树.二叉树的直径;
import 二叉树.TreeNode;

public class DiameterOfBinaryTree {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int a = process(root);
        return res;
    }

    public int process(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = process(node.left);
        int right = process(node.right);
        if (node.left == null && node.right == null) {
            return 0;
        }
        else if (node.left == null || node.right == null) {
            res = Math.max((left+right+1), res);
            return Math.max(left, right) + 1;
        }
        else {
            res = Math.max((left+right+2), res);
            return Math.max(left, right) + 1;
        }
    }
}
