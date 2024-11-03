package M2.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AbsoluteValueHeap {
    private static class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (Math.abs(o1) > Math.abs(o2)) {
                return 1;
            } else if (Math.abs(o1) < Math.abs(o2)) {
                return -1;
            } else {
                if (o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int input;
        PriorityQueue<Integer> absoluteValueHeap = new PriorityQueue<>(new CustomComparator());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());
            if (input != 0) {
                absoluteValueHeap.add(input);
            } else {
                if (!absoluteValueHeap.isEmpty()) {
                    sb.append(absoluteValueHeap.poll()).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}
