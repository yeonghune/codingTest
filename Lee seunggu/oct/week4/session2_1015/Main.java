// 1730, [BOJ] 행운의 바퀴 / 실버4
package oct.week4.session2_1015;

import java.io.*;

public class Main {
    public static boolean isDuplicated(char[] chars){
        int[] alphabet = new int[26];
        for(int i=0; i<chars.length; i++){
            if(chars[i] != '?'){
                alphabet[chars[i] - 'A']++;
            }
        }

        for(int i=0; i<26; i++){
            if(alphabet[i] >= 2){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]); // 칸 수
        int K = Integer.parseInt(nums[1]); // 횟수

        int cursor = 0;
        char[] wheel = new char[N];
        for(int i=0; i<N; i++)
            wheel[i] = '?';

        for(int i=0; i<K; i++){
            String[] nums2 = br.readLine().split(" ");
            int S = Integer.parseInt(nums2[0]); // 바뀐 횟수
            char C = nums2[1].charAt(0); // 현재 알파벳

            cursor += S;
            if(cursor >= N){
                cursor = cursor % N;
            }

            if(wheel[cursor] == '?' || wheel[cursor] == C){
                wheel[cursor] = C;
            } else {
                bw.write('!');
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }


        //출력
        if(isDuplicated(wheel)){
            bw.write('!');
        }else {
            while(N-- > 0){
                bw.write(wheel[cursor]);
                cursor--;
                if(cursor < 0)
                    cursor += wheel.length;
            }
        }



        bw.flush();
        bw.close();
        br.close();
    }
}

// 커서가 반시계 방향으로 이동 한다고 생각
// 커서 순서대로 인덱스 0 ~ N-1
