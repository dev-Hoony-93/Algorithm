package boj;

import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * boj - p2665 미로만들기
 *
 * 풀이방법
 * 다익스트라인가이게
 *
 * */
public class P2665_d {
	static int N ;
	static int [] dx = { -1,0,1,0};
	static int [] dy = { 0,-1,0,1};
	static int [][] map;
	static int [][] dis;
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		N = Integer.parseInt(sc.nextLine());

		map = new int[N][N];
		dis = new int[N][N];

		for (int i = 0; i < N; i++) {
			char temp[] = sc.nextLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j]-'0';
				dis[i][j] = -1;
			}
		}
		bfs();
		System.out.println(dis[N-1][N-1]);

	}

	public static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0, map[0][0]==1?0:1));
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(!isRange(nx, ny)) continue;
				if( dis[nx][ny] == -1 || dis[nx][ny] > (map[nx][ny] ==1? p.b2w: p.b2w+1)) {
					dis[nx][ny] = map[nx][ny] ==1? p.b2w: p.b2w+1;
					q.add(new Pair(nx, ny, dis[nx][ny]));
				}
			}
		}
	}

	public static boolean isRange(int x , int y) {
		if(x < 0 || x>=N || y<0 || y>=N) return false;
		return true;
	}

	static class Pair {
		int x;
		int y;
		Integer b2w;
		public Pair(int x, int y, Integer b2w) {
			super();
			this.x = x;
			this.y = y;
			this.b2w = b2w;
		}
	}
}
