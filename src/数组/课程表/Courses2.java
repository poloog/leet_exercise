package 数组.课程表;
import java.util.*;

public class Courses2 {
    public static void main(String[] args) {
        int numberOfCourses = 2;
        int[][] prerequisites = new int[1][2];
        prerequisites[0][0] = 1;
        prerequisites[0][1] = 0;
        int[] res = findOrder(numberOfCourses, prerequisites);
        System.out.println(res);
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] course = new int[numCourses];
        List<Integer> res = new ArrayList<Integer>();
        Arrays.fill(course, -1);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int[] a : prerequisites){
            int i = a[0];
            int j = a[1];
            if (course[i]==-1){
                course[i] = 1;
            } else{
                course[i]++;
            }
            if (!map.containsKey(j)){
                List<Integer> t = new ArrayList<>();
                t.add(i);
                map.put(j, t);
            } else{
                List<Integer> t = map.get(j);
                t.add(i);
                map.put(j, t);
            }
        }
        for (int i=0; i<numCourses; i++){
            if (course[i]==-1){
                queue.offer(i);
            }
        }
        if (queue.isEmpty()) {
            return new int[0];
        } else{
            while (!queue.isEmpty()){
                int t = queue.poll();
                res.add(t);
                if (map.containsKey(t)){
                    List<Integer> tt = map.get(t);
                    for (Integer a : tt){
                        course[a]--;
                        if (course[a] == 0){
                            queue.offer(a);
                        }
                    }
                    map.remove(t);
                }
            }
            for (int c : course){
                if (c>0) return new int[0];
            }
            int[] r = new int[numCourses];
            for (int i=0; i<numCourses; i++){
                r[i] = res.get(i);
            }
            return r;
        }
    }
}
