// 10250, [BOJ] ACM 호텔 / 브론즈3
package oct.week3.session2_1013;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int H, W, N;
            String[] nums = br.readLine().split(" ");
            H = Integer.parseInt(nums[0]);
            W = Integer.parseInt(nums[1]);
            N = Integer.parseInt(nums[2]);

            int ACM[][] = new int[H+1][W+1];

            for(int i=1; i<=H; i++){
                for(int j=1; j<=W; j++){
                    ACM[i][j] = 100 * i + j ;
                }
            }

            int roomNumber;

            if(N % H == 0){
                roomNumber = ACM[H][N / H];
            }else{
                roomNumber = ACM[N % H][N / H + 1];
            }

            bw.write(String.valueOf(roomNumber)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
