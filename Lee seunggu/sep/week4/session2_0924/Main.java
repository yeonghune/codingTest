// 1. 문서 하나씩 순회
// 2. 문서 글자와 단어 글자 하나씩 비교
// 3-1. 단어와 완전히 일치하면 카운트 + 1 하고, 문서의 다음 글자부터 2를 반복.
// 3-2. 단어와 일치 하지 않으면 문서의 다음 글자부터 2를 반복

package sep.week4.session2_0924;

import java.util.Scanner;

public class Main
{
//    public static void main(String[] args)
//    {
//        Scanner sc = new Scanner(System.in);
//        String document = sc.nextLine();
//        String searchWord = sc.nextLine();
//
//        int count = 0;
//
//        for(int i=0; i<document.length(); i++)
//        {
//            boolean isMatch = true;
//
//            for(int j=0; j<searchWord.length(); j++)
//            {
//                if((i+j) >= document.length() || document.charAt(i + j) != searchWord.charAt(j)) // 리스트 인덱스 범위 고려
//                {
//                    isMatch = false;
//                    break;
//                }
//                else
//                {
//                    isMatch = true;
//                }
//            }
//
//            if(isMatch)
//            {
//                count++;
//                i = i + searchWord.length() - 1;
//            }
//        }
//
//        System.out.print(count);
//    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String document = sc.nextLine();
        String searchWord = sc.nextLine();

        int startIndex = 0;
        int count = 0;

        while(true)
        {
            startIndex = document.indexOf(searchWord, startIndex);

            if(startIndex >= 0)
            {
                count++;
                startIndex += searchWord.length();
            }
            else
            {
                break;
            }
        }
        System.out.print(count);
    }
}
