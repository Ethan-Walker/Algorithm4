package chapter1.ch1;

public class EX1_1_35 {


    public static void main(String[] args) {
        // 掷两次筛子，两数之和出现的概率
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for(int i=1;i<=SIDES;i++){
            for(int j=1;j<=SIDES;j++){
                dist[i+j]+=1.0;
            }
        }
        for(int k=2;k<=2*SIDES+1;k++){
            dist[k]/=36.0;
        }
    }
}
