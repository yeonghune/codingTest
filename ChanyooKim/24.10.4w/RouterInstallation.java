package D31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RouterInstallation {
    public static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int low = 1;
        int high = house[N - 1] - house[0] + 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (routerInstall(mid) < C) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low - 1);
    }

    public static int routerInstall(int distance) {
        int count = 1;
        int lastLocation = house[0];

        for (int i = 1; i < house.length; i++) {
            int location = house[i];

            if (location - lastLocation >= distance) {
                lastLocation = location;
                count++;
            }
        }

        return count;
    }
}
