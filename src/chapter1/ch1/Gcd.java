package chapter1.ch1;

import java.util.Random;

/**
 * Created by lenovo on 2018/6/18.
 * 欧几里得算法
 */
public class Gcd {

    // 假設 p < q 
    public static int gcdRecursion(int p, int q) {
        if (p == 0) return q;
        int r = q % p;
        return gcdRecursion(r, p);
    }

    public static int gcd(int p, int q) {
        if (p == 0) return q;
        int r;
        while (p != 0) {
            r = q % p;
            q = p;
            p = r;
        }
        return q;
    }

    public static void main(String[] args) {
        while (true) {
            int x = (int) (Math.random() * 10000);
            int y = (int) (Math.random() * 10000);
            if (gcd(x, y) != gcdRecursion(x, y)) {
                System.out.println("算法有错");
            }
        }
    }
}
