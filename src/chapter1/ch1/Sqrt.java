package chapter1.ch1;

import java.util.Random;

/**
 * Created by lenovo on 2018/6/23.
 * 计算一个数的平方根:二分法逼近
 */
public class Sqrt {
    public static double sqrt(double n) {
        if (n == 1.0) return 1.0;
        // 考虑 0---1 --- n
        double left, right, mid = 0;
        if (n < 1) {
            left = n;
            right = 1;
        } else {
            left = 1;
            right = n;
        }
        double number = -1000;
        while (Math.abs(number - n) > 10e-10) {
            mid = (left + right) / 2.0;
            number = mid * mid;
            if (number < n) {
                left = mid;
            } else if (number > n) {
                right = mid;
            } else {
                return mid;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        Random random = new Random();
        for(int i=0;i<100;i++){
            double abs = Math.abs(random.nextDouble()*10);
            System.out.println(abs+" 平方根= "+sqrt(abs));
        }
    }
}
