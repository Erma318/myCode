package Integer;

import java.util.ArrayList;
import java.util.List;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (dividend < 0 && divisor < 0) {
            return helper(dividend, divisor);
        } else if (dividend > 0 && divisor > 0) {
            return helper(-dividend, -divisor);
        } else if (dividend > 0 && divisor < 0) {
            return -helper(-dividend, divisor);
        } else {
            return -helper(dividend, -divisor);
        }
    }

    private int helper(int dividend, int divisor) {
        if (dividend > divisor) {
            return 0;
        }

        int totalTimes = 0;
        while (dividend <= divisor) {
            int temp = divisor;
            int times = 1;
            while (temp << 1 >= dividend) {
                times <<= 1;
                temp <<= 1;
            }
            dividend -= temp;
            totalTimes += times;
        }
        return totalTimes;
    }

//    public int divide(int dividend, int divisor) {
//        if (dividend == 0) return 0;
//        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
//        int sign = ((dividend > 0) ^ (divisor > 0)) ? -1 : 1;
//
//        long dividendNew = Math.abs((long) dividend);
//        long divisorNew = Math.abs((long) divisor);
//        int totalTimes = 0;
//        while (dividendNew >= divisorNew) {
//            long temp = divisorNew;
//            int times = 1;
//            while (temp << 1 <= dividendNew) {
//                times <<= 1;
//                temp <<= 1;
//            }
//            dividendNew -= temp;
//            totalTimes += times;
//        }
//        return sign * totalTimes;
//    }
    public static void main(String[] args) {
        DivideTwoIntegers here = new DivideTwoIntegers();
        //System.out.println(here.divide(Integer.MIN_VALUE, 1));
        System.out.println(here.divide(-34, 3));
    }
}
