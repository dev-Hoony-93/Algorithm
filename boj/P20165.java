package boj;

import java.util.Scanner;
/**
 * boj 20165 - 인내의 도미노 장인 호석
 *
 * 시뮬레이션 문제이다.
 *
 * */
public class P20165 {
	static int N,M;
	static int board[][];
	static boolean dw[][];
	static int dx[] = {0,0 ,1,-1};
	static int dy[] = {1,-1,0,0};
	static int cnt =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int R = sc.nextInt();
		board = new int [N][M];
		dw = new boolean [N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < R; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int dir = dir(sc.next().charAt(0));

			attack(x,y,dir);
			x = sc.nextInt()-1;
			y = sc.nextInt()-1;
			dw[x][y] = false;
		}
		System.out.println(cnt);
		check();
	}
	static void check() {
		for (int i = 0; i <N; i++) {
			String str= "";
			for (int j = 0; j < M; j++)	str+= dw[i][j] ?" F" : " S";
			System.out.println(str.substring(1));
		}

	}
	static void attack(int x,int y ,int dir) {

		if(!isRange(x,y)) return;
		if(dw[x][y]) return;
		dw[x][y] = true;
		cnt++;
		for(int i=1; i< board[x][y] ; i++) {
			attack(x+dx[dir]*i, y+dy[dir]*i, dir);
		}

	}
	static boolean isRange(int x, int y) {
		if(x<0 || x>=N || y< 0 || y>= M) return false;
		return true;

	}

	static int dir(char dir) {
		switch (dir) {
		case 'E':return 0;
		case 'W':return 1;
		case 'S':return 2;
		case 'N':return 3;
		default: return -1;
		}
	}
}
