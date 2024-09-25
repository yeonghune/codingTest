package D14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Upstair {
    static int[] stairs;
    static int[] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        stairs = new int[n + 1];
        dp = new int[n + 1];

        for(int i = 1; i <= n; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stairs[0];
        dp[1] = stairs[1];

        if(n >= 2){
            dp[2] = stairs[1] + stairs[2];
        }

        System.out.println(find(n));
    }
    public static int find(int n){
        if(dp[n] != 0){
            dp[n] = Math.max(find(n - 2), find(n - 3) + stairs[n -1]) + stairs[n];
        }

        return dp[n];
    }
}
