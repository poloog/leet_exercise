package 二叉树.所有大于等于节点的值之和;
import 二叉树.TreeNode;

public class ConvertBST {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        process(root);
        return root;
    }

    public void process(TreeNode node) {
        if (node == null) {
            return;
        }
        process(node.right);
        sum += node.val;
        node.val = sum;
        process(node.left);
    }
}
