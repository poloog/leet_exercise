package 二叉树.从根节点到叶节点的路径数字之和;
import 二叉树.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class sumNumbers {
    public static void main(String[] args) {
        System.out.println("main");
    }
    // 层序遍历
    public static int mySumNumbers1(TreeNode root) {
        HashMap<TreeNode, String> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        map.put(root, String.valueOf(root.val));
        queue.offer(root);
        int res = 0;
        while(!queue.isEmpty()) {
            TreeNode t = queue.poll();
            String num = map.get(t);
            if(t.left ==null && t.right == null) {
                res += Integer.parseInt(map.get(t));
            }else {
                if(t.left != null) {
                    queue.offer(t.left);
                    map.put(t.left, num+String.valueOf(t.left.val));
                }
                if(t.right != null) {
                    queue.offer(t.right);
                    map.put(t.right, num+String.valueOf(t.right.val));
                }
            }
        }
        return res;
    }

    //递归
    public static int mySumNumbers2(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode node,int val) {
        if (node == null){
            return 0;
        }
        val = val * 10 + node.val;
        if (node.left == null && node.right == null){
            return val;
        }
        return dfs(node.left, val) + dfs(node.right, val);
    }
}
