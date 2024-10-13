// 10989, [BOJ] 수 정렬하기 3 / 브론즈3
package sep.week5.session1_0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    // 1 <= N < 10,000,000
    // 1 <= num <= 10,000
    static final int SIZE = 10001;

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int N = Integer.parseInt(br.readLine());
//        int[] arr = new int[N];
//        int[] countSorted = new int[SIZE];
//
//        for(int i=0; i<N; i++)
//            arr[i] = Integer.parseInt(br.readLine());
//
//        for(int i=0; i<N; i++){
//            countSorted[ arr[i] ]++;
//        }
//
//        for(int i=0; i<SIZE; i++){
//            if(countSorted[i]>0){
//                for(int j=0; j<countSorted[i]; j++){
//                    //System.out.println(i);
//                    bw.write(i+"\n");
//                }
//            }
//        }
//        bw.flush();
//        bw.close();
//        br.close();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] countArr = new int[SIZE];

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            countArr[n]++;
        }

        for(int i=1; i<SIZE; i++){
            while(countArr[i]-- > 0){
                bw.write(i+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
