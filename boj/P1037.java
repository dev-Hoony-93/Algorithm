package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * boj - P1037 약수
 *
 * 약수가 전부 주어지면
 * 정렬해서 맨왼쪽꺼랑 맨오른쪽꺼 or 가운데 2개곱하면 원래 수가나온다.
 *
 * */
public class P1037 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);

		int answer = (N%2) ==0 ? num[N/2-1] * num[N/2] : num[N/2] *num[N/2];

		System.out.println(answer);

	}
}
