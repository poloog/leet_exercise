package com.leet;

import java.util.*;

public class ProgramTest {
    public static void main(String[] args) {
        int[] input = new int[]{1,0,1};
        String s1 = "ADOBECODEBANC";
        String s2 = "ABC";
        int[] a = {2,1,5,6,2,3};
        Node tree = createTree();
        List<List<Integer>> res = levelOrder(tree);
        System.out.println(res);
        //test();
    }

    public static int findMaxLength(int[] nums) {
        int[] pre_nums = new int[nums.length+1];
        pre_nums[0] = 0;
        for(int i=1;i<pre_nums.length;i++){
            if(nums[i-1]==0) nums[i-1] = -1;
            pre_nums[i] = pre_nums[i-1] + nums[i-1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int res = 0;
        for(int j=1;j<pre_nums.length;j++){
            if(pre_nums[j]==0) res = Math.max(res, j);
            else{
                if(map.containsKey(pre_nums[j])) res = Math.max(res, j - map.get(pre_nums[j]));
                else map.put(pre_nums[j], j);
            }
        }
        return res;
    }

    public static int subarraySum(int[] nums, int k) {
        int[] pre_nums = new int[nums.length+1];
        for(int i=1;i<pre_nums.length;i++) pre_nums[i] = pre_nums[i-1] + nums[i-1];
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int j=1;j< pre_nums.length;j++){
            if(pre_nums[j]==k) res++;
            if(map.containsKey(pre_nums[j]-k)) res += map.get(pre_nums[j]-k);
            if(map.containsKey(pre_nums[j])){
                map.put(pre_nums[j], map.get(pre_nums[j])+1);
            }else{
                map.put(pre_nums[j], 1);
            }
        }
        return res;
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i=0;i<s1.length();i++) arr1[s1.charAt(i) - 'a'] ++;
        for(int j=0;j<s1.length();j++) arr2[s2.charAt(j) - 'a'] ++;
        for(int left=0,right=s1.length()-1;right<s2.length();left++, right++){
            if(Arrays.equals(arr1, arr2)) return true;
            if(right==s2.length()-1) continue;
            arr2[s2.charAt(left)-'a']--;
            arr2[s2.charAt(right+1)-'a']++;
        }
        return false;
    }

    public static int lengthOfLongestSubstring(String s) {
        int len=s.length();
        if(len==0 || len==1) return len;
        int res = 0;
        int left=0,right=1;
        int flag = 1<<(s.charAt(left)-'a');
        while(right<len){
            int t = 1<<(s.charAt(right)-'a');
            if((t&flag) == 0){
                res = Math.max(res, right-left+1);
                flag |= t;
                right++;
            }else{
                flag = (1<<(s.charAt(left)-'a'))^flag;
                left++;
            }
        }
        return res;
    }

    public static String minWindow(String s, String t) {
        if ( s.length() < t.length() ) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int count = map.size();
        int strStart=0, strEnd=0;
        int minWindowSize = Integer.MAX_VALUE;

        while(right < s.length() || ( count==0 && right==s.length() )){
            if(count>0){
                char c = s.charAt(right);
                if(map.containsKey(c)){
                    map.put(c, map.get(c)-1);
                    if(map.get(c)==0){
                        count--;
                    }
                }
                right++;
            }
            else{
                if(right-left < minWindowSize){
                    minWindowSize = right - left;
                    strStart = left;
                    strEnd = right;
                }
                char k = s.charAt(left);
                if(map.containsKey(k)){
                    map.put(k, map.get(k)+1);
                    if(map.get(k)==1){
                        count++;
                    }
                }
                left++;
            }
        }
        return Integer.MAX_VALUE > minWindowSize ? s.substring(strStart, strEnd) : "";

    }

    public static boolean isPalindrome(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i< s.length(); i++){
            int ch = s.charAt(i);
            if(ch >= 65 && ch <= 90){
                stack.push(ch+32);
                queue.offer(ch+32);
            }
            else if(ch >= 97 && ch <= 122){
                stack.push(ch);
                queue.offer(ch);
            }
            else if(ch >= 48 && ch <= 57){
                stack.push(ch);
                queue.offer(ch);
            }
        }
        int len = stack.size();
        for(int j=0; j< len; j++){
            int st = stack.pop();
            int q = queue.poll();
            if(st != q){
                return false;
            }
        }
        return true;
    }

    public static boolean palindrome(String s){
        int left = 0, right = s.length() - 1;
        while (left<right) {
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i=0; i<heights.length; i++) {
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]) {
                int t = stack.pop();
                res = Math.max(res, (i - t) * heights[t]);
            }
            stack.push(i);
        }
        return res;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] res = new int[temperatures.length];
        for(int i=0; i< temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }



// Definition for a Node.
static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    //[1,null,3,2,4,null,5,6]
    public static Node createTree() {
        Node node_5 = new Node(5);
        Node node_6 = new Node(6);
        List<Node> list1 = new ArrayList<>();
        list1.add(node_5); list1.add(node_6);
        Node node_3 = new Node(3, list1);
        Node node_2 = new Node(2);
        Node node_4 = new Node(4);
        List<Node> list2 = new ArrayList<>();
        list2.add(node_3); list2.add(node_2); list2.add(node_4);
        Node tree = new Node(1, list2);
        return tree;
    }


    public static List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node curEnd = root;
        Node nextEnd = null;
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            Node t = queue.poll();
            list.add(t.val);
            if(t.children != null) {
                List<Node> children = t.children;
                for(Node child : children) {
                    queue.offer(child);
                    nextEnd = child;
                }
            }
            if(t == curEnd) {
                List<Integer> tmp = new ArrayList<>(list);
                res.add(tmp);
                list.clear();
                curEnd = nextEnd;
            }
        }
        return res;
    }


    public static void test(){
        int[] a = new int[]{1,0,0,0,0,1};
        int[] b = new int[]{1,0,0,0,0,1};
        if(a==b) System.out.println("a==b");
        else System.out.println("a!=b");
    }
}




