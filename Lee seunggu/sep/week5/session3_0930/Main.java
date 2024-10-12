// 2309, [BOJ] 일곱 난쟁이 / 브론즈1
package sep.week5.session3_0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] hobits = new int[9];
        for(int i=0; i<9; i++){
            hobits[i] = Integer.parseInt(br.readLine());
        }
        int sum = 0;
        for(int i=0; i<9; i++){
            sum += hobits[i];
        }
        int sumOfNotHobits = sum - 100;
        int[] ansArray = new int[7];

        boolean found = false;
        for(int i=0; i<9 && !found; i++){
            for(int j=i+1; j<9; j++){
                if(sumOfNotHobits == hobits[i]+hobits[j]){
                    int ansIndex = 0;
                    for(int k=0; k<9; k++){
                        if(k!=i && k!=j){
                            ansArray[ansIndex++] = hobits[k];
                        }
                    }
                    found = true;
                    break;
                }
            }
        }

        Arrays.sort(ansArray);
        for(int i=0; i<7; i++){
            System.out.println(ansArray[i]);
        }
    }
}
