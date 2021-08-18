
package boj;

import java.util.Scanner;

/**
 * boj 18429 - 근손실
 *
 * 백트래킹
 *
 * 재귀로 n일차까지 돌린다.
 *
 * */

public class P18429 {
	static int cnt =0, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt();
		int kits [] = new int[N];
		for (int i = 0; i < N; i++) {
			kits[i] =sc.nextInt();
		}

		doEx(0,0, N, new boolean [N] , kits);

		System.out.println(cnt);
	}

	public static void doEx(int gr , int r,  int N ,boolean [] isVisit, int [] kits) {
		if(r == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < kits.length; i++) {
			if(isVisit[i]) continue;
			int nGr = gr+kits[i] -K;
			if(nGr < 0) continue;
			isVisit[i] = true;
			doEx(nGr, r+1, N, isVisit, kits);
			isVisit[i] = false;

		}

	}


}
