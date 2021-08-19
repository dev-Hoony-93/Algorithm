
package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * boj 1520 - 내리막 길
 *
 * DFS + DP문제
 *
 *
 * */

public class P1520 {
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	static int M,N;
	static int [][] map;
	static int [][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		map = new int [M][N];
		dp = new int [M][N];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
		dfs(0,0);

		System.out.println(dp[0][0]);
	}

	public static boolean isRange(int x, int y) {
		if(x<0 || y<0 || x>= M  || y>= N) return false;
		return true;
	}

	public static int dfs(int x , int y) {

		if(x==M-1 && y == N-1) return 1;

		if(dp[x][y] == -1) {
			dp[x][y] = 0;
			for(int r = 0; r<4 ; r++) {
				int nx = x+dx[r];
				int ny = y+dy[r];
				if(!isRange(nx, ny)) continue;
				if(map[x][y]>map[nx][ny]) {
					dp[x][y] += dfs(nx,ny);
				}
			}
		}
		return dp[x][y];
	}


}
