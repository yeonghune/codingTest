package sep.week4.session3_0925;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] currentTimes = sc.next().split(":");
        String[] dropTimes = sc.next().split(":");

        int currentHour = Integer.parseInt(currentTimes[0]);
        int currentMinute = Integer.parseInt(currentTimes[1]);
        int currentSecond = Integer.parseInt(currentTimes[2]);

        int dropHour = Integer.parseInt(dropTimes[0]);
        int dropMinute = Integer.parseInt(dropTimes[1]);
        int dropSecond = Integer.parseInt(dropTimes[2]);

        int currentSecondAmount = currentHour*3600 + currentMinute*60 + currentSecond;
        int dropSecondAmount = dropHour*3600 + dropMinute*60 + dropSecond;

        int requiredSecondAmount = dropSecondAmount - currentSecondAmount;

        if(requiredSecondAmount <= 0)
        {
            requiredSecondAmount += 24*60*60;
        }

        int requiredHour = requiredSecondAmount / 3600;
        int requiredMinute = (requiredSecondAmount % 3600) / 60;
        int requiredSecond = requiredSecondAmount % 60;

        System.out.println(String.format("%02d:%02d:%02d", requiredHour, requiredMinute, requiredSecond));
        //System.out.printf("%02d:%02d:%02d", requiredHour, requiredMinute, requiredSecond);
    }
}


//public class Main
//{
//    public static int[] getTimeArray(String str)
//    {
//        // str = HH:MM:SS
//        int[] timeArray = new int[3];
//        int hour = (str.charAt(0)-'0')*10 + str.charAt(1)-'0';
//        int minute = (str.charAt(3)-'0')*10 + str.charAt(4)-'0';
//        int second = (str.charAt(6)-'0')*10 + str.charAt(7)-'0';
//
//        timeArray[0] = hour;
//        timeArray[1] = minute;
//        timeArray[2] = second;
//
//        return timeArray;
//    }
//
//    public static void printTime(int[] timeArr)
//    {
//        if(timeArr[0] < 10)
//        {
//            System.out.printf("0%d",timeArr[0]);
//        }
//        else
//        {
//            System.out.print(timeArr[0]);
//        }
//
//        if(timeArr[1] < 10)
//        {
//            System.out.printf(":0%d", timeArr[1]);
//        }
//        else
//        {
//            System.out.print(":");
//            System.out.print(timeArr[1]);
//        }
//
//        if(timeArr[2] < 10)
//        {
//            System.out.printf(":0%d", timeArr[2]);
//        }
//        else
//        {
//            System.out.print(":");
//            System.out.print(timeArr[2]);
//        }
//    }
//
//    public static void main(String[] args)
//    {
//        Scanner sc = new Scanner(System.in);
//        String currentTime = sc.nextLine();
//        String dropTime = sc.nextLine();
//        int[] currentTimeArray = getTimeArray(currentTime);
//        int[] dropTimeArray = getTimeArray(dropTime);
//        int[] requiredTimeArray = new int[3];
//
//        requiredTimeArray[0] = dropTimeArray[0] - currentTimeArray[0];
//        requiredTimeArray[1] =  dropTimeArray[1] - currentTimeArray[1];
//        requiredTimeArray[2] = dropTimeArray[2] - currentTimeArray[2];
//
//        if(requiredTimeArray[2] < 0)
//        {
//            dropTimeArray[1]--;
//            requiredTimeArray[1] =  dropTimeArray[1] - currentTimeArray[1];
//            requiredTimeArray[2] += 60;
//        }
//
//        if(requiredTimeArray[1] < 0)
//        {
//            dropTimeArray[0]--;
//            requiredTimeArray[0] = dropTimeArray[0] - currentTimeArray[0];
//            requiredTimeArray[1] += 60;
//        }
//
//        if(requiredTimeArray[0] < 0)
//        {
//            requiredTimeArray[0] += 24;
//
//        }
//
//        if(requiredTimeArray[0]==0 && requiredTimeArray[1]==0 && requiredTimeArray[2]==0)
//        {
//            requiredTimeArray[0] = 24;
//        }
//
//        printTime(requiredTimeArray);
//
//    }
//}
