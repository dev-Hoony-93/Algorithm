package boj;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 백준 2589 - 보물찾기
 *
 * 브루트 포스 + BFS문제이다.
 *
 * 풀이순서
 * 1. 모든 L(땅)을 시작으로 BFS를 돌린다.
 * 2. q에 방문거리를 담고 큐에서 뽑을때마다 최대거리를 비교한다.
 *
 */
public class P2589 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int max = 0;
	static int M, N;
	static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		map = new char[M][N];

		for (int i = 0; i < M; i++) {
			String str = sc.next();
			map[i] = str.toCharArray();
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'L')
					bfs(i, j);
			}
		}
		System.out.println(max);

	}

	static void bfs(int i, int j) {

		boolean[][] isVisited = new boolean[M][N];
		LinkedList<Pair> bfs_q = new LinkedList<>();
		bfs_q.add(new Pair(i, j, 0));
		isVisited[i][j] = true;
		while (!bfs_q.isEmpty()) {

			Pair p = bfs_q.poll();
			max = Math.max(max, p.d);
			for (int k = 0; k < 4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];

				if (!isRange(nx, ny))	continue;
				if (isVisited[nx][ny])	continue;
				if (map[nx][ny] == 'W')	continue;
				isVisited[nx][ny] = true;

				bfs_q.add(new Pair(nx, ny, p.d + 1));

			}
		}

	}

	static class Pair {
		int x;
		int y;
		int d;

		public Pair(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static boolean isRange(int x, int y) {
		if (x < 0 || x >= M)	return false;
		if (y < 0 || y >= N)	return false;
		return true;
	}

}
