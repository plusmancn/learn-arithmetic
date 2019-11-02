package cn.plusman.search;

import java.text.DecimalFormat;

public class Sqrt {
    public static double sqrtC(double x) {
        if(x < 0) {
            return Double.NaN;
        }


        double low = 1;
        double high = x;
        if (x < 1.0) {
            low = 0;
            high = 1;
        }

        double mid;

        while(true) {
            mid = low + (high - low) / 2;
            double midM2 = mid * mid;

            if(Math.abs(midM2 -x) <= 0.0000001) {
                break;
            }

            if(midM2 > x) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return Double.parseDouble(new DecimalFormat("0.000000").format(mid));
     }

    public static void main(String[] args) {
        System.out.println(sqrtC(4));
        System.out.println(sqrtC(5));
        System.out.println(sqrtC(0.25));
        System.out.println(sqrtC(0.13));
    }
}
