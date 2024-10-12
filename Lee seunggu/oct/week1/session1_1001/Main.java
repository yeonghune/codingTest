// 10448, [BOJ] 유레카 이론 / 브론즈1
package oct.week1.session1_1001;

import java.io.*;

public class Main {

    static final int MAX_TRIANGLE_NUMBER = 45;

    public static int getTriangleNumber(int n){
        return n*(n+1)/2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0){
            int sum = Integer.parseInt(br.readLine());
            boolean possible = false;
            for(int i=MAX_TRIANGLE_NUMBER; i>0; i--){
                for(int j=MAX_TRIANGLE_NUMBER; j>0; j--){
                    for(int k=MAX_TRIANGLE_NUMBER; k>0; k--){
                        if(sum == getTriangleNumber(i)+getTriangleNumber(j)+getTriangleNumber(k)){
                            possible = true;
                            break;
                        }
                    }
                }
            }
            if(possible){
                bw.write(1+"\n");
            }
            else{
                bw.write(0+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
