// 11068, [BOJ] 회문인 수
package oct.week2.session1_1011;

import java.io.*;

public class Main {
    // 64 <= T <= 1,000,000
    // 2 <= B <= 64
    public static boolean isPalindrome(int[] arr, int len){
        for(int i=0; i< len / 2; i++){
            if(arr[i] != arr[len-i-1]){
                return false;
            }
        }
        return true;
    }

    public static int convertToBase(int x, int base, int[] reverseDigit){ // 100, 3 -> 1 0 2 0 1
        int len = 0;
        while(x > 0){
            reverseDigit[len++] = x % base;
            x = x / base;
        }
        return len;
    }

    public static void main(String[] args) throws IOException {
        // 1. 2~64 진법 변환한다
        // 2. 회문인지 확인한다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            boolean ans = false;

            for(int i=2; i<=64; i++){
                int[] baseDigit = new int[20];
                int arrLength = convertToBase(N, i, baseDigit);
                if(isPalindrome(baseDigit, arrLength)){
                    ans = true;
                    break;
                }
            }

            bw.write(ans?"1":"0");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
