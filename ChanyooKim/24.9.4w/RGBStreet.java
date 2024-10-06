package D14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBStreet {
    static int Red = 0;
    static int Green = 1;
    static int Blue = 2;
    static int n;
    static int[][] paintArray;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        paintArray = new int[n][3];
        dp = new int[n][3];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            paintArray[i][Red] = Integer.parseInt(st.nextToken());
            paintArray[i][Green] = Integer.parseInt(st.nextToken());
            paintArray[i][Blue] = Integer.parseInt(st.nextToken());
        }

        dp[0][Red] = paintArray[0][Red];
        dp[0][Green] = paintArray[0][Green];
        dp[0][Blue] = paintArray[0][Blue];

        System.out.println(Math.min(calculate(n - 1, Red),Math.min(calculate(n - 1, Green), calculate(n - 1, Blue))));

    }
    public static int calculate(int index, int color) {
        if(dp[index][color] == 0){
            if(color == Red){
                dp[index][Red] = Math.min(calculate(index - 1, Green), calculate(index - 1, Blue)) + paintArray[index][Red];
            }else if(color == Green) {
                dp[index][Green] = Math.min(calculate(index - 1, Red), calculate(index - 1, Blue)) + paintArray[index][Green];
            }else{
                dp[index][Blue] = Math.min(calculate(index - 1, Red), calculate(index - 1, Green)) + paintArray[index][Blue];
            }
        }

        return dp[index][color];
    }
}
