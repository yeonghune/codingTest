package sep.week4.session6_0929;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main
{
    // 1 <= T <= 1,000,000
    // 1<= A,B <= 1,000

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0; i<TC; i++)
        {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bw.write(A+B + "\n");
        }
        bw.flush(); // 한번에 출력. 모든 데이터를 버퍼에 쌓아두고, 반복이 끝난 후에 한꺼번에 출력하는 방식
        bw.close();
        br.close();
    }
}
