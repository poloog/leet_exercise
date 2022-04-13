package 二叉树.二叉树的右侧视图;
import 二叉树.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightSideView {
    public static void main(String[] args) {
        System.out.println("main");
    }

    public static List<Integer> myRightSideView(TreeNode root) {
        if(root==null) return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        List<Integer> res = new LinkedList<>();
        while(!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if(t.left!=null) {
                queue.offer(t.left);
                nextEnd = t.left;
            }
            if(t.right!=null) {
                queue.offer(t.right);
                nextEnd = t.right;
            }
            if(curEnd==t) {
                res.add(t.val);
                curEnd = nextEnd;
            }
        }
        return res;
    }
}
