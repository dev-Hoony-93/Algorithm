package Algorithm.boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 17291 - 새끼치기
 *
 * DP...
 */

public class P17291 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int dp[]=new int[21];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < 21; i++) {
            System.out.println(Arrays.toString(dp));
            dp[i] = dp[i - 1] * 2;

            if( i == 4 ) dp[i] -= dp[i - 4];
            else if (i >= 4 && i % 2 == 0) {
                dp[i] -= dp[i - 4] + dp[i - 5]; // -3 , -4 를 빼줘야되는게 아닌가 한참 해맸지만, 태어난 수이므로 그 전년도의 세포수를 빼줘야된다.
            }
        }
// 1 2 3  4    5      6        7       8
// 1 2 4 7(-1) 14(-0) 22(-4-2) 44(-0) 88(-7 - 14)
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);

    }
}
