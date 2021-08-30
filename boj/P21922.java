package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * boj 21922 - 학부 연구생 민상
 *
 *
 * 시뮬레이션 문제
 *
 * */
public class P21922 {
	static int N , M;
	static int [] dx = { -1,0,1,0};
	static int [] dy = { 0,-1,0,1};
	static int area;
	static int [][] room;
	static boolean [][] isVisited;
	static boolean [][][] isVisitedWay;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[  ]  = br.readLine().split(" ");

		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);

		area = 0;
		room = new int[N][M];
		isVisited = new boolean[N][M];
		isVisitedWay = new boolean[N][M][4];

		for (int i = 0; i < room.length; i++) {
			String [] temp2 =  br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(temp2[j]);
			}
		}
		br.close();


		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[0].length; j++) {
				if(room[i][j] == 9) wind(i,j);
			}
		}
		check();
//		for (int i = 0; i < room.length; i++) {
//			for (int j = 0; j < room[0].length; j++) {
//				if(!isVisited[i][j]) System.out.print(0);
//				else  System.out.print(1);
//			}
//			System.out.println();
//		}
		System.out.println(area);

	}

	public static void check() {
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[0].length; j++) {
				if(isVisited[i][j])area++;
			}
		}
	}

	public static void wind(int x, int y) {
		LinkedList<Pair> que = new LinkedList<>();
		que.add(new Pair(x, y,0));
		que.add(new Pair(x, y,1));
		que.add(new Pair(x, y,2));
		que.add(new Pair(x, y,3));
		while(!que.isEmpty()) {
			Pair ele = que.poll();
			isVisited[ele.x][ele.y] = true;

			if(isVisitedWay[ele.x][ele.y][ele.way]) continue;
			isVisitedWay[ele.x][ele.y][ele.way] = true;

			int nextX = ele.x +dx[ele.way];
			int nextY = ele.y +dy[ele.way];

			if(!isRange(nextX,nextY)) continue;

			int way = windWay( room[nextX][nextY], ele.way);
			que.add(new Pair(nextX, nextY, way));

		}

	}

	public static int  windWay(int block, int way ) {
		switch (block) {

		case 1: // 세로방향 그대로
			if(way == 0 || way == 2) return  way;
			else return   (way+2)%4;
		case 2: // 가로방향 그대로
			if(way == 1 || way == 3) return  way;
			else return   (way+2)%4;
		case 3: // 0 3 , 1 2 , 2 1,  3 0
			if(way == 1 || way == 3)return  (way+1)%4;
			else return   (way+3)%4;
		case 4: //  0일시 1 , 1 일시 0 , 2일시 3 3일시 2
			if(way == 0 || way == 2) return  (way+1)%4;
			else return   (way+3)%4;
		default:
			return way;
		}

	}
//	public static int  windWay(int x ,int y , int way , LinkedList<Pair> que) {
//
//		switch (room[x][y]) {
//		case 0:
//			que.add(new Pair(x, y, way));
//			break;
//		case 1: // 세로방향 그대로
//			if(way == 0 || way == 2) que.add(new Pair(x, y, way));
//			else que.add(new Pair(x, y, (way+2)%4));
//			break;
//		case 2: // 가로방향 그대로
//			if(way == 1 || way == 3) que.add(new Pair(x, y, way));
//			else que.add(new Pair(x, y, (way+2)%4));
//			break;
//		case 3: // 0 3 , 1 2 , 2 1,  3 0
//			if(way == 1 || way == 3) que.add(new Pair(x, y, (way+1)%4));
//			else que.add(new Pair(x, y, (way+3)%4));
//			break;
//		case 4: //  0일시 1 , 1 일시 0 , 2일시 3 3일시 2
//			if(way == 0 || way == 2) que.add(new Pair(x, y, (way+1)%4));
//			else que.add(new Pair(x, y, (way+3)%4));
//			break;
//
//		}
//
//	}

	public static boolean isRange(int x , int y) {
		if(x < 0 || x>=N || y<0 || y>=M) return false;
		return true;
	}

}

class Pair {
	int x;
	int y;
	int way;
	public Pair(int x, int y,int way) {
		this.x = x;
		this.y = y;
		this.way = way;
	}
}
