package sep.week3.session1_0921;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        for(int i=0; i<str.length(); i++)
        {
            if (str.charAt(i) < 97)
            {
                System.out.printf("%c",str.charAt(i)+32);
            }
            else
            {
                System.out.printf("%c", str.charAt(i)-32);
            }
        }
    }
}
