package sep.week4.session7_0929;

import java.util.Scanner;

public class Main2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        while(TC-- > 0)
        {
            int t = sc.nextInt();
            int[] arr = new int[20];

            for(int i=0; i<20; i++)
                arr[i] = sc.nextInt();

            int[] sorted = new int[20];
            int cnt = 0;

            for(int i=0; i<20; i++)  // 1. 줄 서 있는 학생 중 자기보다 큰 학생을 찾는다.
            {
                for(int j=0; j<20; j++) // 1. 줄 서 있는 학생 중 자기보다 큰 학생을 찾는다.
                {
                    if(sorted[j]>arr[i]) // 2. 있다면 그 앞에 선다.
                    {
                        for(int k=i-1; k>=j; k--) // 2-1. 뒤 학생들 모두 뒤로 한 발씩 간다.
                        {
                            sorted[k+1] = sorted[k];
                            cnt += 1;
                        }
                        sorted[j] = arr[i]; // 그 앞에 선다
                        break;
                    }
                    // 2-2. 없다면 맨 뒤에 선다.
                    else
                    {
                        sorted[i] = arr[i];
                    }
                }
            } // 3. 반복

            System.out.println(t + " " + cnt);
        }

    }
}
