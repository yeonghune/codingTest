package D12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sudoku {
    static final int SIZE = 9;
    static int count = 0;
    static int[][] map = new int[SIZE][SIZE];
    static StringBuilder sb = new StringBuilder();
    static boolean isFound = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        for(int i = 0; i < SIZE; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < SIZE; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    count++;
                }
            }
        }

        sudoku(0, 0, 0);
        System.out.println(sb);

    }
    public static void sudoku(int nowX, int nowY, int countZero){
        if(count == countZero && !isFound){
            isFound = true;
            for(int i = 0; i < SIZE; i++){
                for(int j = 0; j < SIZE; j++){
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
            return;
        }

        if(nowX < 8 && nowY == 9){
            nowX += 1;
            nowY = 0;
        }

        if(nowX == 8 && nowY == 9){
            return;
        }

        if(map[nowX][nowY] == 0){
            for(int num = 1; num <= SIZE; num++){
                boolean isPresent = false;
                for(int col = 0; col < SIZE; col++){
                    if(map[nowX][col] == num){
                        isPresent = true;
                        break;
                    }
                }
                if(isPresent){
                    continue;
                }

                for(int row = 0; row < SIZE; row++){
                    if(map[row][nowY] == num){
                        isPresent = true;
                        break;
                    }
                }

                int squareRow = (nowX / 3) * 3;
                int squareCol = (nowY / 3) * 3;

                for(int i = squareRow; i < squareRow + 3; i++){
                    for(int j = squareCol; j < squareCol + 3; j++){
                        if(map[i][j] == num){
                            isPresent = true;
                            break;
                        }
                    }
                }

                if(!isPresent){
                    map[nowX][nowY] = num;
                    sudoku(nowX, nowY + 1, countZero + 1);
                    map[nowX][nowY] = 0;
                }
            }
        }else{
            sudoku(nowX, nowY + 1, countZero);
        }
    }
}
