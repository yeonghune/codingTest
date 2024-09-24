package D13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSum {
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum(0, 0);
        System.out.println(max);

    }
    public static void sum(int index, int sum){
        if(index >= arr.length){
            return;
        }

        int RecordSum = sum;

        for(int i = index; i < arr.length; i++) {
            RecordSum += arr[i];
            if(RecordSum > max) {
                max = RecordSum;
            }
            sum(i + 1, 0);
        }
    }
}
