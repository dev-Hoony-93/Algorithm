
package boj;

import java.util.Scanner;

/**
 * boj 1904 - 01타일
 *
 * DP
 *
 * 점화식 세워서 푼다.
 *
 * */

public class P1904 {
	static long [] memo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		memo = new long[n+1];
		for (int i = 0; i <= n; i++) {
			if( i ==0 || i ==1 || i==2) memo[i] = i;
			else memo[i] = (memo[i-1] + memo[i-2])%15746;
		}
		System.out.println(memo[n]);
	}


}
