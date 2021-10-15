package boj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 백준 P21941
 *
 * 문자열 제거.
 *
 */
public class P21941 {
	static int dp[];
	static String str;
	static Map<String,Integer > words;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		dp = new int[str.length()+1];
		words = new HashMap<>();
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			String key = sc.next();
			int value= sc.nextInt();
			if(key.length()<value) words.put(key, value); //문자열 크기보다 작은 값은 굳이 넣지않는다.
		}

		remove(0);

		System.out.println(dp[dp.length-1]);

	}

	static void remove(int idx) {
		if(idx >= dp.length-1) return;

		for (String key : words.keySet()) {
			int newIdx = str.indexOf(key, idx) ; // 현재 위치부터 뒤에 있는 문자열중에 지울수있는 문자열 찾는다.
			if(newIdx != -1 ) {
				// 찾았을 때 index 위치 + 삭제연산 문자열 크기위치 인덱스에
				// value값 + 현재 위치서부터 얼마나 떨어져있는 문자열인지
				dp[newIdx+key.length()] = Math.max(dp[idx]+newIdx-idx +words.get(key), dp[newIdx+key.length()]);
			}
		}
		dp[idx+1]= Math.max(dp[idx+1], dp[idx]+1); // 1개씩 지우는 게 더클경우.
		remove(idx+1);
	}
}
