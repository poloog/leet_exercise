package 字符串.字符最短的距离;

public class ShortestToChar {
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] res = new int[len];
        int index = -1;
        for (int i = 0; i<len;i++) {
            if (s.charAt(i)==c) {
                index = i;
            }
            if (index == -1) {
                res[i] = Integer.MAX_VALUE;
            } else {
                res[i] = i - index;
            }
        }
        index = -1;
        for (int j=len-1;j>=0;j--) {
            if(s.charAt(j)==c) {
                index = j;
            }
            if (index != -1) {
                res[j] = Math.min(res[j], index - j);
            }
        }
        return res;
    }
}
