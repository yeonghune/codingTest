// 10448, [BOJ] 유레카 이론 / 브론즈1
// 최적화
package oct.week1.session1_1001;

import java.io.*;

public class Main2 {
    static final int K_NUMBER = 1000;
    static boolean isEurekaNumber[] = new boolean[K_NUMBER + 1];

    // K보다 작은 삼각수 구해주는 함수
    public static int getTriangleNumbers(int K, int[] triangleNumbers){
        int triangleNumberCount = 0;
        for(int i=1; ; i++){
            int triangleNumber = i*(i+1)/2;
            if(triangleNumber > K){
                break;
            }
            triangleNumbers[triangleNumberCount++] = triangleNumber; // K 이하의 삼각수만 배열에 저장
        }
        return triangleNumberCount;
    }

/* O(n^3) */
//    public static void preprocess(){
//        int[] triangleNumbers = new int[50];
//        int triangleNumberCount = getTriangleNumbers(K_NUMBER, triangleNumbers);
//
//        for(int i=0; i<triangleNumberCount; i++){
//            for(int j=0; j<triangleNumberCount; j++){
//                for(int k=0; k<triangleNumberCount; k++){
//                    int sum = triangleNumbers[i]+triangleNumbers[j]+triangleNumbers[k];
//                    if(sum <= K_NUMBER){
//                        isEurekaNumber[sum] = true;
//                    }
//                }
//            }
//        }
//
//    }


/* O(K * n) */
    public static void preprocess(){
        int[] triangleNumbers = new int[50];
        int triangleNumberCount = getTriangleNumbers(K_NUMBER, triangleNumbers);
        boolean[] isSumOfTriangleNumbers = new boolean[K_NUMBER+1];

        for(int i=0; i<triangleNumberCount; i++){
            for(int j=0; j<triangleNumberCount; j++){
                if(triangleNumbers[i] + triangleNumbers[j] < K_NUMBER){
                    isSumOfTriangleNumbers[triangleNumbers[i] + triangleNumbers[j]] = true;
                }
            }
        }

        for(int i=1; i<=K_NUMBER; i++){
            if(!isSumOfTriangleNumbers[i])
                continue;
            for(int j=0; j<triangleNumberCount; j++){
                int eurekaNumber = i + triangleNumbers[j];
                if(eurekaNumber > K_NUMBER){
                    break;
                }
                isEurekaNumber[eurekaNumber] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        preprocess();

        while(T-- > 0){
            int K = Integer.parseInt(br.readLine());
            bw.write(isEurekaNumber[K] ? "1\n" : "0\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}