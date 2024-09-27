package sep.week4.session4_0926;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        // t = t % getLCM(w,h); -> 시간초과

        // X,Y 좌표 나눠서 각각 계산
        int timeX = t % (2*w);
        int timeY = t % (2*h);
        int currentX = p;
        int currentY = q;
        int deltaX = 1;
        int deltaY = 1;

        while(timeX-->0)
        {
            if(currentX==w)
                deltaX = -1;
            else if(currentX==0)
                deltaX = 1;

            currentX += deltaX;
        }

        while(timeY-- > 0)
        {
            if(currentY==h)
                deltaY = -1;
            else if(currentY==0)
                deltaY = 1;

            currentY += deltaY;
        }

        br.close();
        bw.write(currentX+" "+currentY);
        bw.flush();
        bw.close();
    }
}
