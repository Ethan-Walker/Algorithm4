package chapter1.ch1;

public class EX_1_1_30 {
    public static void main(String[] args) {
        int n = 20;
        boolean[][] a = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = isRelativelyPrime(i, j) ? true : false;
            }
        }
    }

    /**
     * 判断 a b 是否互质
     * @param a
     * @param b
     * @return
     */
    public static boolean isRelativelyPrime(int a, int b) {

        // 求 a && b 最大公约数
        int t;
        while (a != 0) {
            t = b % a;
            b = a;
            a = t;
        }
        if (b > 1) return true;
        return false;
    }
}
