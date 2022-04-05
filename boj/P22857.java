package Algorithm.boj;

import java.util.Scanner;

/**
 * boj - P22857 가장 긴 짝수 연속한 부분 수열 (small)
 *
 * 두 포인터 이용해서 푼다.
 *
 * */
public class P22857 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrLen = sc.nextInt();
        int K = sc.nextInt();
        int [] arr= new int[arrLen];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int start =0;
        int end =0;
        int len=0;
        int del =0;
        int maxLen = 0;

        while(end < arrLen){

            if(del > K){
                if(arr[start]%2==0){
                    len--;
                }else{
                    del--;
                }
                start++;
            }else{
                if(arr[end]%2==0){
                    len++;
                }else{
                    del++;
                }
                end++;
            }
            maxLen = Math.max(maxLen,len);
        }
        System.out.println(maxLen);
    }

}
