package D27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class NumberCard2 {
    public static HashMap<Integer, Integer> cards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        cards = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(cards.containsKey(num)) {
                cards.put(num, cards.get(num) + 1);
            }else{
                cards.put(num, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if(cards.containsKey(target)) {
                sb.append(cards.get(target)).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}
