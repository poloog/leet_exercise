package 数组.课程表;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        int numberOfCourses = 2;
        int[][] prerequisites = new int[1][2];
        prerequisites[0][0] = 1;
        prerequisites[0][1] = 0;
        boolean res = canFinish(numberOfCourses, prerequisites);
        System.out.println(res);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] course = new int[numCourses];
        Arrays.fill(course, -1);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int[] a : prerequisites){
            if (course[a[0]]==-1){
                course[a[0]] = 1;
            } else{
                course[a[0]]++;
            }
            if (!map.containsKey(a[1])){
                List<Integer> t = new ArrayList<Integer>();
                t.add(a[0]);
                map.put(a[1], t);
            } else{
                List<Integer> t = map.get(a[1]);
                t.add(a[0]);
                map.put(a[1], t);
            }
        }
        for (int i=0; i<course.length; i++){
            if (course[i] == -1){
                queue.offer(i);
            }
        }
        if (queue.isEmpty()){
            return false;
        } else{
          while (!queue.isEmpty()){
              int t = queue.poll();
              if (map.containsKey(t)){
                  List<Integer> tt = map.get(t);
                  for (Integer c : tt){
                      course[c]--;
                      if (course[c] == 0){
                          course[c] = -1;
                          queue.offer(c);
                      }
                  }
                  map.remove(t);
              }
          }
          for (int d : course){
              if (d > 0) return false;
          }
          return true;
        }
    }

}
