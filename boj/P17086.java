package boj;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * boj 17086 - 아기상어2
 *
 * BFS 문제
 *
 * 상어가잇는점에서 모두 bfs돌리기
 *
 * */
public class P17086 {
	static int N,M, map [][],dis [][];
	static int dx [] = {-1,1,0,0,-1,-1,1,1};
	static int dy []= {0,0,-1,1,1,-1,1,-1,};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int [N][M];
		dis = new int [N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				dis[i][j] = -1;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1)	{
					bfs(i,j);
				}
			}
		}
		int max = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max= Math.max(max, dis[i][j]);
			}
		}
		System.out.println(max);
	}

	public static void bfs(int x,int y){
		LinkedList<Pair> q = new LinkedList<>();
		boolean [][] isVisited = new boolean [N][M];
		q.add(new Pair(x, y, 0));
		isVisited[x][y] = true;
		while(!q.isEmpty()) {
			Pair p = q.poll();

			if(dis[p.x][p.y]==-1) dis[p.x][p.y]= p.d;
			else dis[p.x][p.y] = Math.min(dis[p.x][p.y], p.d);
			for (int i = 0; i < 8; i++) {
				int nx=p.x + dx[i];
				int ny=p.y + dy[i];
				if(!isRange(nx, ny))continue;
				if(isVisited[nx][ny])continue;
				if(map[nx][ny]==1) continue;
				isVisited[nx][ny] = true;
				q.add(new Pair(nx, ny, p.d+1));
			}
		}
	}

	public static boolean isRange(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=M) return false;
		return true;
	}


	static class Pair{
		int x;
		int y;
		int d;
		public Pair(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}


	}
}
