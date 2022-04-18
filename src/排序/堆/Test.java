package 排序.堆;

public class Test {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(100);
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < 10; i++) {
            heap.push(a[i]);
        }
        for (int j = 0; j < 10; j++) {
            System.out.println(heap.pop());
        }
    }
}
