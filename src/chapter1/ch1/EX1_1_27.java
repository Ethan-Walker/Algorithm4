package chapter1.ch1;

import edu.princeton.cs.algs4.Counter;

import java.util.Scanner;

public class EX1_1_27 {
    static long count = 0;
    static Counter counter = new Counter("ex1_1_27");

    //  递归
    public static double binomial(int N, int k, double p) {
        count++;
        counter.increment();

        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    // 递归优化
    public static double binomial2a(int N, int k, double p) {
        double[][] v = new double[N + 1][k + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= k; j++) {
                v[i][j] = -1;
            }
        }
        return binomial2b(v, N, k, p);
    }
    public static double binomial2b(double[][] v, int n, int k, double p) {
        if (n == 0 && k == 0) return 1.0;
        if (n < 0 || k < 0) return 0.0;
        if (v[n][k] == -1) {
            // 初始值，表示该值未计算
            v[n][k] = (1.0 - p) * binomial2b(v, n - 1, k, p) + p * binomial2b(v, n - 1, k - 1, p);
        }
        return v[n][k];

    }

    // 迭代
    public static double binomialImprove(int N, int k, double p) {
        double[][] a = new double[N + 1][k + 1];
        a[0][0] = 1;
        for (int i = 0; i <= N; i++) a[i][0] = Math.pow(1 - p, i);
        for (int j = 1; j <= k; j++) a[0][j] = 0.0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= k; j++) {
                a[i][j] = (1 - p) * a[i - 1][j] + p * a[i - 1][j - 1];
            }
        }
        return a[N][k];
    }


    public static void main(String[] args) {
        int n, k;
        double p;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        p = sc.nextDouble();

//        double result1 = binomial(n, k, p);
//        System.out.println("result1 = " + result1);

        double result2 = binomialImprove(n, k, p);
        System.out.println("result2 = " + result2);

        double result3 = binomial2a(n, k, p);
        System.out.println("result3 = " + result3);

//        System.out.println(count);
//        System.out.println(counter);
    }
}
