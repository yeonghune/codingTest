package D27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNumber {
    public static int[] numList;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        numList = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numList);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int target = Integer.parseInt(st.nextToken());
            BinarySearch(target);
        }

        System.out.println(sb);
    }
    public static void BinarySearch(int num){
        int start = 0;
        int end = numList.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;

            if(numList[mid] == num){
                sb.append(1).append("\n");
                return;
            }else if(numList[mid] > num){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        sb.append(0).append("\n");
    }
}
