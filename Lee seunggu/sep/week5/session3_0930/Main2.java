// 2309, [BOJ] 일곱 난쟁이 / 브론즈1
// 브루트 포스
package sep.week5.session3_0930;

import java.io.*;
import java.util.Arrays;

public class Main2 {

    public static void insertionSort(int[] arr){
        int len = arr.length;
        for(int i=0; i<len; i++){
            for(int j=0; j<i; j++){
                if(arr[i]<arr[j]){
                    int temp = arr[i];
                    for(int k=i; k>j; k--){
                        arr[k] = arr[k-1];
                    }
                    arr[j] = temp;
                    break;
                }
            }
        }

    }

    public static void selectionSort(int[] arr){
        int len = arr.length;
        for(int i=0; i<len; i++){
            int minIndex = i;
            for(int j=i+1; j<len; j++){
                if(arr[minIndex]>arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] hobits = new int[9];
        int[] ansArr = new int[7];
        for(int i=0; i<9; i++){
            hobits[i] = Integer.parseInt(br.readLine());
        }

        for(int i1=0; i1<9; i1++){
            for(int i2=i1+1; i2<9; i2++){
                for(int i3=i2+1; i3<9; i3++){
                    for(int i4=i3+1; i4<9; i4++){
                        for(int i5=i4+1; i5<9; i5++){
                            for(int i6=i5+1; i6<9; i6++){
                                for(int i7=i6+1; i7<9; i7++){
                                    int realSumOfHobits = hobits[i1]+hobits[i2]+hobits[i3]+hobits[i4]+hobits[i5]+hobits[i6]+hobits[i7];
                                    if(realSumOfHobits==100){
                                        ansArr[0] = hobits[i1];
                                        ansArr[1] = hobits[i2];
                                        ansArr[2] = hobits[i3];
                                        ansArr[3] = hobits[i4];
                                        ansArr[4] = hobits[i5];
                                        ansArr[5] = hobits[i6];
                                        ansArr[6] = hobits[i7];
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

//        insertionSort(ansArr);
        selectionSort(ansArr);
        for(int i=0; i<7; i++){
            bw.write(ansArr[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
