package boj;
import java.util.Scanner;

/**
 * boj - p1806 부분합
 *
 * 투포인터를 이용해서 푸는문제.
 *
 * */
public class P1806 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int [] num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}

		int ans = twoPointer(num,M);

		System.out.println(ans==100000001?0:ans);
	}

	static int twoPointer(int [] num , int M) {
		int min =100000001;
		int start =0;
		int end = 0;
		int sum = 0;

		while (true) {

			if(sum>= M) {
				sum -= num[start++];
			}else if(end >= num.length) {
				break;
			}else {
				sum += num[end++];
			}
//			System.out.println(start +" "+end +" "+sum);
			if(sum >= M) min = Math.min(min, end-start);

		}
		return min;
	}
}
