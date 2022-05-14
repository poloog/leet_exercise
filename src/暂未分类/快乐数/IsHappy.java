package 暂未分类.快乐数;

public class IsHappy {
    public boolean isHappy(int n) {
        int fast = process(process(n));
        int slow = process(n);
        if (slow == 1 || fast == 1) return true;
        while (fast != slow) {
            fast = process(process(fast));
            slow = process(slow);
            if (slow == 1 || fast == 1) return true;
        }
        return false;
    }

    public int process(int n) {
        int sum = 0;
        while (n > 0) {
            int t = n % 10;
            sum += t * t;
            n = n / 10;
        }
        return sum;
    }
}
