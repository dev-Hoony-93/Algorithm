package Algorithm.boj;

import java.util.Scanner;

/**
 * boj - P15988 1 +2 + 3  + 3
 *
 * Dp문제
 *
 * */

public class P15988 {


    public static void main(String[] args) {
        long [] dp = new long[1000001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int j = 4; j <= 1000000; j++) {
            dp[j] = (dp[j-1]%1000000009+dp[j-2]%1000000009+dp[j-3]%1000000009)%1000000009;
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]%1000000009);
        }
    }

}
