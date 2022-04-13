package 二叉树.二叉树剪枝;
import 二叉树.TreeNode;

public class pruneTree {

    public static void main(String[] args) {
        System.out.println("test");
    }

    public TreeNode myPruneTree(TreeNode root) {
        boolean res = process(root);
        if(!res) return root;
        else return null;
    }

    public boolean process(TreeNode node) {
        if(node==null) return true;
        if(node.left==null && node.right==null) {
            if(node.val==1) return false;
            else return true;
        }
        boolean left = process(node.left);
        boolean right = process(node.right);
        if(node.val==1) {
            if(left) node.left=null;
            if(right) node.right=null;
        }else {
            if(left && right) return true;
            else if(left) node.left=null;
            else if(right) node.right=null;
        }
        return false;
    }

}
