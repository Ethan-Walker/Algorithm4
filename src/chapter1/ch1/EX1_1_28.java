package chapter1.ch1;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;

// 1.1.28 删去重复元素
public class EX1_1_28 {
    public static ArrayList<Integer> deleteDuplicate(int[] a) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0, i = 0, j;
        while (i < a.length) {
            j = i + 1;
            while (j < a.length && a[j] == a[i]) j++;
            list.add(a[i]);
            i = j;
        }
        return list;
    }

    //其他解法
    void m(int[] whitelist) {

        ArrayList<Integer> list = new ArrayList<>();

        // 注意最后一个元素
        for (int i = 0; i < whitelist.length - 1; i++) {
            if (whitelist[i] != whitelist[i + 1]) {
                // 只要当前值和后一位不等，就加到集合中，多个重复的元素就会取到最后一个
                list.add(whitelist[i]);
            }
        }
        list.add(whitelist[whitelist.length - 1]);
        whitelist = new int[list.size()];
        for (int i = 0; i < whitelist.length; i++) {
            whitelist[i] = list.get(i);
            System.out.print(whitelist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = In.readInts("tinyT.txt");
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        ArrayList<Integer> list = deleteDuplicate(a);
        System.out.println(list);
    }
}
