package sep.week4.session7_0929;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main
{
    static final int STUDENT_COUNT = 20;

    public static int getStepCount(int[] arr)
    {
        // 1. 한명 세운다
        // 2-1. 자기가 가장 클 경우 맨 뒤에 선다.
        // 2-2. 자기보다 큰 사람 중 가장 앞에 있는 사람 앞에 선다.
        // 2-2-1. 모두 한발자국씩 물러선다.
        // 반복

        //-> 자신보다 앞의 인덱스 중에서 큰 학생 개수 구하기

        int stepCount = 0;
        int[] sorted = new int[STUDENT_COUNT];

        for(int i=0; i<STUDENT_COUNT; i++)
        {
            sorted[i] = arr[i];

            for(int j=0; j<STUDENT_COUNT; j++)
            {
                if(sorted[j]>arr[i])
                {
                    stepCount += 1;
                }
            }
        }
        return stepCount;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0; i<TC; i++)
        {
            st = new StringTokenizer(br.readLine());
            int[] studentArray = new int[STUDENT_COUNT];

            int testCase = Integer.parseInt(st.nextToken());
            for(int j=0; j<STUDENT_COUNT; j++)
            {
                int number = Integer.parseInt(st.nextToken());
                studentArray[j] = number;
            }

            bw.write(testCase + " " +getStepCount(studentArray));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
