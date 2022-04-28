package 暂未分类.单词接龙;

import java.util.*;

public class LadderLength {
    String begin;
    String end;
    HashSet<String> set = new HashSet<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        begin = beginWord;
        end = endWord;
        for (String s : wordList) set.add(s);
        if (!set.contains(endWord)) return 0;
        int res = bfs();
        return res == -1 ? 0 : res + 1;
    }

    private int bfs() {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        queue1.add(begin);
        queue2.add(end);
        map1.put(begin, 0);
        map2.put(end, 0);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int t = -1;
            if (queue1.size() < queue2.size()) {
                t = update(queue1, map1, map2);
            } else {
                t = update(queue2, map2, map1);
            }
            if (t != -1) return t;
        }
        return -1;
    }

    private int update(Queue<String> queue, HashMap<String, Integer> cur, HashMap<String, Integer> other) {
        int len = queue.size();
        for (int i = 0; i < len; i++) {
            String s = queue.poll();
            int n = s.length();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 26; k++) {
                    String new_s = s.substring(0,j) + (char)('a' + k) + s.substring(j + 1);
                    if (set.contains(new_s)) {
                        if (cur.containsKey(new_s) && cur.get(new_s) <= cur.get(s) + 1) continue;
                        if (other.containsKey(new_s)) {
                            return cur.get(s) + 1 + other.get(new_s);
                        } else {
                            queue.add(new_s);
                            cur.put(new_s, cur.get(s) + 1);
                        }
                    }
                }
            }
        }
        return -1;
    }

}
