package chapter1.ch1;

import org.junit.Test;

public class Matrix {


    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};  // a[3][4]
        int[][] b = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};           // b[4][2]

        int[][] c = multiply(a, b);
        int row = a.length, col = b[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 矩阵相乘
     */
    public static int[][] multiply(int[][] a, int[][] b) {
        int row = a.length, col = b[0].length;

        int[][] c = new int[row][col]; // c[3][2]  a 的行数 ，b 的列数

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // c[i][j] = a 的第 i 行 元素 * b 的第 j 列元素之和
                for (int k = 0; k < a[0].length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return c;
    }

    /**
     * 矩阵转置
     */
    public static double[][] transpose(double[][] a) {
        int newRow = a[0].length;
        int newCol = a.length;

        double[][] b = new double[newRow][newCol];
        for (int i = 0; i < newRow; i++) {
            for (int j = 0; j < newCol; j++) {
                b[i][j] = a[j][i];
            }
        }
        return b;
    }

    /**
     * 向量点乘
     */
    public static double dot(double[] x, double[] y) {
        double result = 0;
        for (int i = 0; i < x.length; i++) {
            result += x[i] * y[i];
        }
        return result;
    }

    /**
     * 矩阵和向量乘积
     *
     * @param a
     * @param b
     * @return
     */
    public static double[] multiply(double[][] a, double[] b) {
        double[] c = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                c[i] += a[i][j] * b[j];
            }
        }
        return c;
    }

    @Test
    public void testArrayInit() {
        int[][] a;
        a = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(a[i][j]);
            }
        }
    }
}
