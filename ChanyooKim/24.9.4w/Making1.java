package D14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Making1 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];

        System.out.println(solution(n));
    }

    public static int solution(int n){
        if(n <= 0){
            return -1;
        }
        if(dp[n] == 0){
            if(n % 6 == 0){
                dp[n] = Math.min(solution(n - 1), Math.min(solution(n / 2),
                        solution(n / 3))) + 1;
            }else if(n % 3 == 0){
                dp[n] = Math.min(solution(n / 3), solution(n - 1)) + 1;
            }else if(n % 2 == 0){
                dp[n] = Math.min(solution(n / 2), solution(n - 1)) + 1;
            }else{
                dp[n] = solution(n - 1) + 1;
            }
        }
        return dp[n];
    }
}
