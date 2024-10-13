package D23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuadTree {
    public static int[][] board;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                board[i][j] = str.charAt(j) - '0';
            }
        }

        quadTree(0, 0 , N);

        System.out.println(sb);
    }

    public static void quadTree(int row, int col, int size) {

        if(isPossible(row, col, size)) {
            sb.append(board[row][col]);
            return;
        }

        int newSize = size / 2;

        sb.append('(');

        quadTree(row, col, newSize);
        quadTree(row, col + newSize, newSize);
        quadTree(row + newSize, col, newSize);
        quadTree(row + newSize, col + newSize, newSize);

        sb.append(')');
    }


    public static boolean isPossible(int row, int col, int size) {

        int x = board[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(x != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
