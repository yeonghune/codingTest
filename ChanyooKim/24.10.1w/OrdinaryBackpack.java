package D17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OrdinaryBackpack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] products = new int[N + 1][2];
        int[][] dp = new int[N + 1][K + 1];
        for(int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            products[i][0] = Integer.parseInt(st.nextToken());
            products[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N  + 1; i++) {
            for(int j = 1; j < K + 1; j++){
                if(products[i][0] > j){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - products[i][0]] + products[i][1]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
