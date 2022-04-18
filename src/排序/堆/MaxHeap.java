package 排序.堆;

// 大根堆
public class MaxHeap {
    private int[] heap;   // 实际的堆数组
    private final int limit;  //堆的最大容量
    private int heapSize;    //当前堆的大小

    // 初始化heap
    public MaxHeap(int limit) {
        heap = new int[limit];
        this.limit = limit;
        heapSize = 0;
    }

    // 判断堆是否为空
    public boolean isEmpty() {
//        if (heapSize == 0) {
//            return true;
//        } else {
//            return false;
//        }
        return heapSize == 0;   // 更简洁的写法
    }

    // 判断堆是否满
    public boolean isFull() {
        return heapSize == limit;
    }

    // 向堆中插入一个值
    public void push(int value) {
        if (heapSize == limit) {
            throw new RuntimeException("can not push, heap is full");
        }
        heap[heapSize] = value;
        heapInsert(heap, heapSize++);
    }

    // 从堆顶部弹出一个值（最大值）
    public int pop() {
        int res = heap[0];
        swap(heap, 0, --heapSize);
        heapify(heap, 0, heapSize);
        return res;
    }

    // 插入堆，使其保持大根堆结构
    // 输入：堆数组， 刚插入的index
    private void heapInsert(int arr[], int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // pop出节点后，重新恢复大根堆结构
    private void heapify(int arr[], int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }


}
