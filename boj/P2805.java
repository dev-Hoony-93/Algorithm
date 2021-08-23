package boj;
import java.util.Scanner;

/**
 * 백준 2805 - 나무 자르기
 *
 * 이분 탐색
 *
 *
 */

public class P2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int [] treeLen = new int [N];
		int max = 0;
		int min = 1;
		int answer = 0;
		for (int i = 0; i < treeLen.length; i++) {
			treeLen[i] = sc.nextInt();
			max= Math.max(max, treeLen[i]);
		}
		long pivot = 0;
		while(max>=min) {
			long sum = 0;
            pivot = (0L+max +min) /2;
			for (int i = 0; i < treeLen.length; i++) {
				long len = treeLen[i] -pivot;
				if(len>0) sum += len;
			}
			if(sum >= M) {
				min = (int) (pivot +1);
				answer = Math.max(answer, (int)pivot);
			}else {
				max = (int) (pivot -1);
			}
		}
		System.out.println(answer);
	}

}