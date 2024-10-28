// 3085, [BOJ] 사탕 게임 / 실버2
package oct.week3.session1_1012;

import java.io.*;

public class Main {
    public static void swapCandy(char[][] arr, int r1, int r2, int c1, int c2){
        char temp;
        temp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = temp;
    }

    public static int getCurrentMaxLength(char[][] arr, int n){
        char currentColor;
        int currentColMaxLength = 0;
        int currentRowMaxLength = 0;
        // 1. 열방향
        for(int i=0; i<n ; i++){
            int len = 1;
            for(int j=0; j<n-1; j++){
                currentColor = arr[i][j];

                if(currentColor == arr[i][j+1]){
                    len++;
                    currentColMaxLength = Math.max(len, currentColMaxLength);
                }else{
                    currentColor = arr[i][j+1];
                    len = 1;
                }
            }
        }
        // 2. 행방향
        for(int i=0; i<n ; i++){
            int len = 1;
            for(int j=0; j<n-1; j++){
                currentColor = arr[j][i];

                if(currentColor == arr[j+1][i]){
                    len++;
                    currentRowMaxLength = Math.max(len, currentRowMaxLength);
                }else{
                    currentColor = arr[j+1][i];
                    len = 1;
                }
            }
        }

        return Math.max(currentColMaxLength, currentRowMaxLength);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] bomboni = new char[N][N];
        int currentMax = 0;

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                bomboni[i][j] = str.charAt(j);
            }
        }

        // 1. 열 방향, 행 방향으로 각각 인접한 격자를 현재 격자와 swap (색이 서로 다른 경우만)
        // 2. 현재의 rowMax, colMax 보다 크다면 currentMax 에 저장
        // 3. 원위치를 위해 한번 더 swap

        // 열방향 swap
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                if(bomboni[i][j] != bomboni[i][j+1]){
                    swapCandy(bomboni, i, i, j, j+1);
                    currentMax = Math.max(currentMax, getCurrentMaxLength(bomboni, N));
                    swapCandy(bomboni, i, i, j, j+1);
                }
            }
        }
        // 행방향 swap
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                if(bomboni[j][i] != bomboni[j+1][i]){
                    swapCandy(bomboni, j, j+1, i, i);
                    currentMax = Math.max(currentMax, getCurrentMaxLength(bomboni, N));
                    swapCandy(bomboni, j, j+1, i, i);
                }
            }
        }

        bw.write(String.valueOf(currentMax));
        bw.flush();
        bw.close();
        br.close();
    }
}
