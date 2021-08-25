package boj;

import java.util.Scanner;

/**
 * 백준 19236 - 청소년 상어
 *
 * 백트래킹 문제
 *
 *
 */

class Fish {
	Integer num;
	int way;
	boolean dead;
	public Fish(int num, int way,boolean dead) {
		this.num = num;
		this.way = way;
		this.dead = dead;
	}

	public Fish clone() {
		return new Fish(num,way,dead);
	}

	@Override
	public String toString() {
		if(dead) return "["+num+" X]";
		return "["+num+" O]";
	}
}

public class P19236 {
	static int [] dx = { -1, -1, 0 ,1,1,1, 0 , -1};
	static int [] dy = { 0 ,-1,-1,-1, 0, 1, 1, 1};
	static int max=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Fish map [][] = new Fish[4][4];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = new Fish(sc.nextInt(), sc.nextInt()-1,false);
//				System.out.print( map[i][j]);
			}
//			System.out.println();
		}
		//크기가 굉장히 작음. 브루트포스 돌리면될듯하다.
		//상어가 이동해서 그자리의 물고기를 먹을수 있을때마다 분기
		//그를 위해서는 상어의 위치및 방향, 분기할때마다 map을 복사, 번호의 합을 가지면 될것 같다.
		eatFish(0, 0, -1, 0, map);
		System.out.println(max);

	}

	static void eatFish(int x,int y,int way,int sum,Fish [][] map ) {
//		System.out.println("----------");
		sum += map[x][y].num;
		way = map[x][y].way%8;
		map[x][y].dead = true;
//		System.out.println("상어위치:" +'x'+x+'y'+y);
//		System.out.println(sum +" ,"+ way);


		max = Math.max(max, sum);
		moveFish(map, x, y);

//		for (int i = 0; i < map.length; i++) {
//			System.out.println(Arrays.toString(map[i]));;
//		}

		for(int d=1; d<4 ;d++) {

			int nx = x + dx[way]*d;
			int ny = y + dy[way]*d;

			if(nx<0||ny<0||nx>=4||ny>=4) break;
			if(map[nx][ny].dead) continue;
//			System.out.println(map[nx][ny].dead);
//			System.out.println("다음위치: "+nx +" , "+ ny +map[nx][ny]);

			Fish newMap [][] = new Fish[4][4];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					newMap[i][j] = map[i][j].clone();
				}
			}
			eatFish(nx, ny, way, sum, newMap);
		}

	}

	static void moveFish(Fish [][] map,int x,int y) {

		//번호가 작은 물고기부터 이동해야함.
		int num = 1 ;

		while(num <= 16) {
			changePos(map, num++,x,y);
		}
	}

	static void changePos(Fish [][] map,int num, int x,int y) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j].num == num && !map[i][j].dead) {
					int cnt =0;
					while(cnt<8) {

						int way = map[i][j].way%8;
						int nx = i+dx[way];
						int ny = j+dy[way];

						if(!isRange(nx,ny) || (x == nx && y ==ny)) {
							map[i][j].way++;
							cnt ++;
							continue;
						}
						Fish temp = map[nx][ny];
						map[nx][ny] = map[i][j];
						map[i][j] = temp;

						return;
					}
				}
			}
		}
	}

	static boolean isRange(int x , int y) {
		if(x<0 || y<0 || x>=4 || y>=4)return false;
		return true;
	}
}
