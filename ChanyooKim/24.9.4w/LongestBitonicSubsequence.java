package D16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestBitonicSubsequence {
    static int[] arr;
    static int[] l_dp;
    static int[] r_dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        l_dp = new int[n];
        r_dp = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            LIS(i);
            LDS(i);
        }

        int max = -1;
        for(int i = 0; i < n; i++){
            max = Math.max(max, l_dp[i] + r_dp[i]);
        }

        System.out.println(max - 1);
    }
    public static int LIS(int idx){
        if(r_dp[idx] == 0){
            r_dp[idx] = 1;

            for(int i = idx - 1; i >= 0; i--){
                if(arr[i] < arr[idx]){
                    r_dp[idx] = Math.max(r_dp[idx], LIS(i) + 1);
                }
            }
        }

        return r_dp[idx];
    }
    public static int LDS(int idx){
        if(l_dp[idx] == 0){
            l_dp[idx] = 1;

            for(int i = idx + 1; i < l_dp.length; i++){
                if(arr[i] < arr[idx]){
                    l_dp[idx] = Math.max(l_dp[idx], LDS(i) + 1);
                }
            }
        }

        return l_dp[idx];
    }
}
