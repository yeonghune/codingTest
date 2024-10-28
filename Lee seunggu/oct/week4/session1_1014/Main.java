// 1730, [BOJ] 판화 / 실버4
package oct.week4.session1_1014;

import java.io.*;

public class Main {
    public static int[] drawCrtalo(int x, int y, boolean[][] isRowVisited, boolean[][] isColVisited, char dir, int n){ // DRDRRUU
            if(dir == 'U'){
                if(y != 0){
                    isRowVisited[y][x] = true;
                    isRowVisited[y-1][x] = true;
                    y--;
                }
            }else if(dir == 'D'){
                if(y != n-1){
                    isRowVisited[y][x] = true;
                    isRowVisited[y+1][x] = true;
                    y++;
                }
            }else if(dir == 'L'){
                if(x != 0){
                    isColVisited[y][x] = true;
                    isColVisited[y][x-1] = true;
                    x--;
                }
            }else{
                if(x != n-1){
                    isColVisited[y][x] = true;
                    isColVisited[y][x+1] = true;
                    x++;
                }
            }

            return new int[] {x, y};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String movings = br.readLine(); // DRDRRUU

        boolean[][] isRowVisited = new boolean[N][N];
        boolean[][] isColVisited = new boolean[N][N];
        int currentX = 0;
        int currentY = 0;

        int len = movings.length();
        int[] cur = new int[2];
        for(int i=0; i<len; i++){
            char dir = movings.charAt(i);
            cur = drawCrtalo(currentX, currentY, isRowVisited, isColVisited, dir, N);
            currentX = cur[0];
            currentY = cur[1];
        }

        // 격자 출력
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(isRowVisited[i][j] == true && isColVisited[i][j] == true)
                    bw.write(43); // +
                else if(isRowVisited[i][j] == true && isColVisited[i][j] == false)
                    bw.write(124); // |
                else if(isRowVisited[i][j] == false && isColVisited[i][j] == true)
                    bw.write(45); // -
                else
                    bw.write(46); // .
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
