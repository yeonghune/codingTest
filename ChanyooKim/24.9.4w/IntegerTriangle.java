package D14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntegerTriangle {
    static int[][] triangle;
    static int[][] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        triangle = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            dp[n - 1][i] = triangle[n - 1][i];
        }

        System.out.println(calculate(0, 0));
    }

    public static int calculate(int depth, int idx){
        if(depth == n - 1){
            return dp[depth][idx];
        }

        if(dp[depth][idx] == 0){
            dp[depth][idx] = Math.max(calculate(depth + 1, idx), calculate(depth + 1, idx + 1))
                    + triangle[depth][idx];
        }

        return dp[depth][idx];
    }
}
