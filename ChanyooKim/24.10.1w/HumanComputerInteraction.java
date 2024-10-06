package D19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HumanComputerInteraction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] alphabet = new int[S.length() + 1][26];

        for(int i = 1; i <= S.length(); i++){
            for(int j = 0; j < 26; j++){
                if(S.charAt(i - 1) == (char)(j + 97)){
                    alphabet[i][S.charAt(i - 1) - 'a'] = alphabet[i - 1][S.charAt(i - 1) - 'a'] + 1;
                }else{
                    alphabet[i][j] = alphabet[i - 1][j];
                }
            }
        }

        for(int i  = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken()) + 1;
            int r = Integer.parseInt(st.nextToken()) + 1;

            int count = alphabet[r][c - 'a'] - alphabet[l - 1][c - 'a'];
            sb.append(count).append("\n");
        }


        System.out.println(sb);
    }
}
