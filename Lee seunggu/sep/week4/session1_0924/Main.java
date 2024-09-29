package sep.week4.session1_0924;

import java.util.Scanner;

public class Main
{
    private static final int ALPHABET_COUNT = 26;

    public static char getMostUsedAlphabet(String str)
    {
        int[] alphabetCountArray = new int[ALPHABET_COUNT];
        char maxAlphabet = '?';
        int maxAlphabetCount = 0;

        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i)>=65 && str.charAt(i)<=90) // 소문자
            {
                alphabetCountArray[str.charAt(i)-'A']++;
            }
            else // 대문자
            {
                alphabetCountArray[str.charAt(i)-'a']++;
            }
        }

        for(int i=0; i<ALPHABET_COUNT; i++)
        {
            if(alphabetCountArray[i] > maxAlphabetCount)
            {
                maxAlphabetCount = alphabetCountArray[i];
                maxAlphabet = (char)('A' + i);
            }
            else if(alphabetCountArray[i] == maxAlphabetCount)
            {
                maxAlphabet = '?';
            }
        }
        return maxAlphabet;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        System.out.print(getMostUsedAlphabet(word));
    }
}
