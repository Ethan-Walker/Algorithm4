package chapter1.ch1;

/**
 * Created by lenovo on 2018/6/23.
 */
public class ReverseArray {
    public static void reverse(int[] a){
        int n = a.length ;
        for(int i=0;i<n/2;i++){
            swap(a,i,n-i-1);
        }
    }

    private static void swap(int[] a, int i, int j) {
        a[i] = a[i]+a[j] - (a[j] = a[i]);
    }

    public static void main(String[] args) {
    }
}
