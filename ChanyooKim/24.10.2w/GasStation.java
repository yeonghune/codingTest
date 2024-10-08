package D22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GasStation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] line = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] station = new int[N];
        for (int i = 0; i < N; i++) {
            station[i] = Integer.parseInt(st.nextToken());
        }

        int min = station[0];
        long sum = 0;
        for (int i = 1; i < N; i++) {
            long length = line[i - 1];
            sum += min * length;
            if(station[i] < min){
                min = station[i];
            }
        }

        System.out.println(sum);
    }
}
