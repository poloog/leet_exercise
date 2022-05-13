package 暂未分类.POW;

public class Pow {
    public double myPow(double x, int n) {
        long N = n;
        double res = 1;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        while (N > 0) {
            if ((N & 1) == 1) res *= x;
            x = x * x;
            N = N >> 1;
        }
        return res;
    }
}
