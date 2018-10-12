package chapter1.ch1;

import java.util.Arrays;
import java.util.Scanner;

public class EX1_1_29 {
    /**
     * 在升序数组中寻找比 key 小的数的数量
     */
    public static int smallerCount(int key, int[] a) {
        int l = 0, mid = 0;
        int r = a.length - 1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (key < a[mid]) r = mid - 1;
            else if (key > a[mid]) l = mid + 1;
            else break;
        }
        if (l <= r) {
            // 找到相等的数，往前寻找第一个比 key 小的数
            while (mid >= 0 && a[mid] == key) mid--;
            return mid + 1;
        } else {
            // 未找到相等的数, l>r
            if (a[l] < key) {
                // 在右边寻找第一个比 key 大的数
                while (l < a.length && a[l] < key) l++;
                return l;
            } else {
                // 从 a[r] 开始找到第一个小于 key 的数
                while (r >= 0 && a[r] > key) r--;
                return r + 1;
            }
        }

    }

    /**
     * 与 key 相等的数数量
     */
    public static int equalCount(int key, int[] a) {
        int l = 0, mid = 0;
        int r = a.length - 1;
        int cnt = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (key < a[mid]) r = mid - 1;
            else if (key > a[mid]) l = mid + 1;
            else {
                int t = mid;
                while (t < a.length && a[t] == key) {
                    t++;
                    cnt++;
                }
                mid--;
                while (mid >= 0 && a[mid] == key) {
                    cnt++;
                }
                return cnt;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 输入数组长度
        int key = sc.nextInt(); // 输入key

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * (100));  // [0,10000)之间的整数
        }

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        System.out.println(smallerCount(key, a));
        System.out.println(equalCount(key, a));

    }
}
