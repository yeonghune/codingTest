// 11005, [BOJ] 진법 변환 2
package oct.week1.session2_1005;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]); // N <= 1,000,000,000, ex) 100
        int B = Integer.parseInt(nums[1]); // 2 <= B <= 36, ex) 3

        String ans = "";
        while(N>0){
            int D = N % B;
            if(D<10){
                ans += D;
            }else{
                ans += (char)('A'-10+D);
            }
            N = N / B;
        }

        for(int i = ans.length()-1; i>=0; i--){
            bw.write(ans.charAt(i));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
