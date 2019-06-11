package search;

public class Sqrt {

    public static double sqrt(double x) {
        double low = 0;
        double up = x;
        if (x < 0) return Double.NaN;
        if (x == 0) return 0;
        if (x == 1) return 1;
        if (x > 0 && x < 1) {
            low = x;
            up = 1;
        }
        double mid = (low + up) / 2;
        while (Math.abs(low - up) >= 1e-6) {
            if (mid * mid > x) {
                up = mid;
            } else if (mid * mid < x) {
                low = mid;
            } else if (Math.abs(mid * mid - x) <= 1e-6) {
                return mid;
            }
            mid = (low + up) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(1.44));
        System.out.println(sqrt(1.21));
    }
}
