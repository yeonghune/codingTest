package sep.week4.session5_0927;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] guardStatus = new char[N][M];

        for(int i=0; i<N; i++)
        {
            guardStatus[i] = sc.next().toCharArray();
        }

        int requiredGuardInRow = N;
        int requiredGuardInCol = M;

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if('X' == guardStatus[i][j])
                {
                    requiredGuardInRow--;
                    break;
                }
            }
        }

        for(int j=0; j<M; j++)
        {
            for(int i=0; i<N; i++)
            {
                if(guardStatus[i][j] == 'X')
                {
                    requiredGuardInCol--;
                    break;
                }
            }
        }

        System.out.print(Math.max(requiredGuardInRow, requiredGuardInCol));
    }
}
