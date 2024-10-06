package D13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadobanSequence{
    static long[] s = new long[100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        s[0] = 1;
        s[1] = 1;
        s[2] = 1;

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());

            if(n <= 3){
                sb.append(1).append('\n');
                continue;
            }

            for(int j = 3; j < n; j++){
                if(s[j] == 0){
                    s[j] = s[j - 2] + s[j - 3];
                }
            }

            sb.append(s[n - 1]).append('\n');
        }

        System.out.println(sb);
    }
}
