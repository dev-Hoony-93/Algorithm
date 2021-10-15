package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * boj 16987 - 계란으로 바위치기
 *
 * 백트래킹
 *
 * */
public class P16987 {
	static int max;

	static {
		max=0;
	}
	static class Egg {
		int dur;
		int wei;
		public Egg(int dur, int wei) {
			this.dur = dur;
			this.wei = wei;
		}

		@Override
		public String toString() {
			return dur+"";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Egg [] eggs = new Egg[N];
		for (int i = 0; i < eggs.length; i++) {
			eggs[i] = new Egg(sc.nextInt(), sc.nextInt());
		}

		sol(0, eggs);
		System.out.println(max);
	}

	static void sol(int i , Egg [] eggs) {
		System.out.println(Arrays.toString(eggs));
		if(i==eggs.length) {


			int cnt=0;
			for (int j = 0; j < eggs.length; j++) {
				if(eggs[j].dur<=0)cnt++;
			}
			max = Math.max(max, cnt);

			return;
		}

		boolean f=false;
		if(eggs[i].dur <=0) {
			sol(i+1,eggs);
			return;
		}
		for (int j = 0; j < eggs.length; j++) {
			if(i==j) continue;
			if(eggs[j].dur<=0) continue;
			f=true;
			eggs[i].dur-=eggs[j].wei;
			eggs[j].dur-=eggs[i].wei;
			sol(i+1, eggs);
			eggs[i].dur+=eggs[j].wei;
			eggs[j].dur+=eggs[i].wei;
		}
		if(!f) sol(i+1, eggs);
	}


}
