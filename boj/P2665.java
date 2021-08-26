package boj;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * boj - p2665 미로만들기
 *
 * 풀이방법
 * 우선순위큐를이용한 탐색
 *
 * */
public class P2665 {
	static int N ;
	static int [] dx = { -1,0,1,0};
	static int [] dy = { 0,-1,0,1};
	static int [][] map;
	static boolean [][] isVisited;
	static int ans;
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		N = Integer.parseInt(sc.nextLine());

		map = new int[N][N];
		isVisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			char temp[] = sc.nextLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j]-'0';
			}
		}


		bfs();
		System.out.println(ans);

	}

	public static void bfs() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0, 0, map[0][0]==1?0:1));
		isVisited[0][0]=true;

		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			if(p.x == N-1 && p.y==N-1) {
				ans = p.b2w;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(!isRange(nx, ny)) continue;
				if(isVisited[nx][ny]) continue;
				isVisited[nx][ny] =true;
				pq.add(new Pair(nx, ny, map[nx][ny] ==1? p.b2w: p.b2w+1));

			}

		}

	}

	public static boolean isRange(int x , int y) {
		if(x < 0 || x>=N || y<0 || y>=N) return false;
		return true;
	}

	static class Pair implements Comparable<Pair> {
		int x;
		int y;
		Integer b2w;
		public Pair(int x, int y, Integer b2w) {
			super();
			this.x = x;
			this.y = y;
			this.b2w = b2w;
		}
		public int compareTo(Pair o) {
			return this.b2w.compareTo(o.b2w);
		}
	}
}
