package 字符串.不同的子序列;

//public class NumDistinct {
//    int res = 0;
//    public int numDistinct(String s, String t) {
////        process(s, 0, "", t);
////        return res;
//        return process2(s, 0, "", t);
//    }
//
//    public void process(String s, int index, String a, String t) {
//        if (a.length() == t.length()) {
//            if (t.equals(a)) {
//                res++;
//                return;
//            } else return;
//        }
//        if (index > s.length() - 1) return;
//        String yes = a + s.charAt(index);
//        process(s, index+1, yes, t);
//        process(s, index+1, a, t);
//    }
//
//    public int dp(String s, String t) {
//        int[][] dp = new int[s.length()][t.length()];
//        for (int j = 0; j < t.length(); j++) {
//            for (int i = 0; i < s.length(); i++) {
//                //if (s.charAt(i) == t.charAt(j))
//            }
//        }
//    }
//}
