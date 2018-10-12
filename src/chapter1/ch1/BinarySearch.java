package chapter1.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class BinarySearch {

    public static int rank(int key, int[] a) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (key < a[mid]) r = mid - 1;
            else if (key > a[mid]) l = mid + 1;
            else return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        System.out.println(Arrays.toString(whitelist));

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            System.out.print("key=" + key);
            if (rank(key, whitelist) >= 0) {
                System.out.print("  找到");
            }
            System.out.println();
        }
    }

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
            // 找到相等的数
            while (mid >= 0 && a[mid] == key) mid--;
            return mid + 1;
        } else {
            // 未找到相等的数, l>r
            if (a[l] < key) {
                while (l < a.length && a[l] < key) l++;
                return l;
            } else {
                // 从 a[r] 开始找到第一个小于 key 的数
                while (r >= 0 && a[r] > key) r++;
                return r + 1;
            }
        }

    }
}
