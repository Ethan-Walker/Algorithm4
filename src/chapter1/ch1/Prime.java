package chapter1.ch1;

/**
 * Created by lenovo on 2018/6/23.
 * 判断一个数是否是素数
 */
public class Prime {
    public static boolean isPrime(long n) {
        if (n < 2) return false;
        // n = 2、3 直接跳出
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;

    }

    public static void main(String[] args) {

    }
}
