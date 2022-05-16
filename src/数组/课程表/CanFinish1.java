package 数组.课程表;

public class CanFinish1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] arr = new int[numCourses];
        for (int[] a : prerequisites) {
            arr[a[0]] = a[1];
        }

    }
}
