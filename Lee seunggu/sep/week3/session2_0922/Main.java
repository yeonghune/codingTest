package sep.week3.session2_0922;

import java.util.Scanner;

public class Main
{
    private static final int ALPHABET_COUNT = 26;

    public static int[] getAlphabetCountArray(String str)
    {
        int[] alphabetCountArray = new int[26];

        for(int i=0; i<str.length(); i++)
        {
            alphabetCountArray[str.charAt(i) - 'a']++;
        }

        return alphabetCountArray;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String firstWord = sc.next();
        String secondWord = sc.next();

        int answer = 0;

        int[] firstWordAlphabetCountArray = getAlphabetCountArray(firstWord);
        int[] secondWordAlphabetCountArray = getAlphabetCountArray(secondWord);

        for(int i=0; i<ALPHABET_COUNT; i++)
        {
            answer += Math.abs(firstWordAlphabetCountArray[i]-secondWordAlphabetCountArray[i]);
        }

        System.out.print(answer);
    }
}
