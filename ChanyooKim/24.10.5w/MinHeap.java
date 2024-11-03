package M2.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MinHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());// 1~n

        int input;
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());
            if (input > 0) {
                minQueue.add(input);
            } else {
                if (!minQueue.isEmpty()) {
                    sb.append(minQueue.poll()).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}
