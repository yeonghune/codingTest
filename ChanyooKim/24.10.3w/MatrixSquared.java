package D25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatrixSquared {
    static final int MOD = 1000;
    static int[][] matrix;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        matrix = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(matrix, B);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    public static int[][] pow(int[][] a, long b) {
        if(b == 1){
            return a;
        }

        int[][] temp = pow(a, b / 2);

        temp = multiply(temp, temp);

        if(b % 2 == 1){
            temp = multiply(temp, matrix);
        }

        return temp;
    }
    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] temp = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    temp[i][j] += a[i][k] * b[k][j];
                    temp[i][j] %= MOD;
                }
            }
        }

        return temp;
    }
}
