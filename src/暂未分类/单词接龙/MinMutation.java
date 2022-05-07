package 暂未分类.单词接龙;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinMutation {
    HashSet<String> set = new HashSet<>();
    public int minMutation(String start, String end, String[] bank) {
        for (String b : bank) set.add(b);
        if (!set.contains(end)) return 0;
        int res = bfs(start, end);
        return res == -1 ? 0 : res;
    }

    public int bfs(String start, String end) {
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        q1.offer(start);
        q2.offer(end);
        map1.put(start, 0);
        map2.put(end, 0);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int t = -1;
            if (q1.size() <= q2.size()) {
                t = process(q1, map1, map2);
            } else {
                t = process(q2, map2, map1);
            }
            if (t != -1) return t;
        }
        return -1;
    }

    public int process(Queue<String> q, HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        char[] gen = new char[]{'A', 'C', 'G', 'T'};
        int len = q.size();
        for (int i = 0; i < len; i++) {
            String t = q.poll();
            for (int j = 0; j < 8; j++) {
                for (char g : gen) {
                    String s = t.substring(0,j) + g + t.substring(j + 1);
                    if (set.contains(s)) {
                        if (map1.containsKey(s) && map1.get(s) <= map1.get(t)+1) continue;
                        if (map2.containsKey(s)) {
                            return map1.get(t) + map2.get(s) + 1;
                        } else {
                            q.offer(s);
                            map1.put(s, map1.get(t) + 1);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
