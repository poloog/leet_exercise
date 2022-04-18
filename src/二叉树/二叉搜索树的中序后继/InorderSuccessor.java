package 二叉树.二叉搜索树的中序后继;
import 二叉树.TreeNode;

public class InorderSuccessor {
    public static void main(String[] args) {
        System.out.println(" ");
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        TreeNode point = root;
        while (point != null) {
            if (point.val > p.val) {
                res = point;
                point = point.left;
            } else {
                point = point.right;
            }
        }
        return res;
    }
}
