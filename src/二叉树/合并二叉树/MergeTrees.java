package 二叉树.合并二叉树;

import 二叉树.TreeNode;

public class MergeTrees {
    TreeNode root = new TreeNode();

    // 创建并返回新树，而不是修改输入的树结构
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        merge(root, root1, root2);
        return root;
    }

    public void merge(TreeNode root, TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return;
        if (root1 != null && root2 != null) {
            root.val = root1.val + root2.val;
            if (root1.left != null || root2.left != null) {
                root.left = new TreeNode();
                merge(root.left, root1.left, root2.left);
            }
            if (root1.right != null || root2.right != null) {
                root.right = new TreeNode();
                merge(root.right, root1.right, root2.right);
            }
        }
        else if (root1 == null) {
            root.val = root2.val;
            if (root2.left != null) {
                root.left = new TreeNode();
                merge(root.left, null, root2.left);
            }
            if (root2.right != null) {
                root.right = new TreeNode();
                merge(root.right, null, root2.right);
            }
        }
        else {
            root.val = root1.val;
            if (root1.left != null) {
                root.left = new TreeNode();
                merge(root.left, root1.left, null);
            }
            if (root1.right != null) {
                root.right = new TreeNode();
                merge(root.right, root1.right, null);
            }
        }
    }
}