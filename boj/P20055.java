package boj;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * boj - P20055 컨베이어 벨트위 로봇
 *
 * 그냥 시뮬레이션.
 *
 *
 * */
public class P20055 {
	static Queue<Integer> robots;
	static int [] belt ;
	static int N,K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		belt = new int [N*2];

		for (int i = 0; i < belt.length; i++) {
			belt[i] = sc.nextInt();
		}

		//로봇위치는 큐
		robots = new LinkedList<>();
		int cnt =0;
		while(true) {
			cnt++;
			//회전
			rotate();
			//이동
			move();
			//로봇 올림
			put();
			//내구도 체크
			if(checkEnd()) break;
		}
		System.out.println(cnt);


	}

	//회전
	public static void rotate() {
		// belt 회전
		int temp = belt[belt.length-1];
		for (int i = belt.length-1; i >0; i--) {
			belt[i] = belt[i-1];
		}
		belt[0] = temp;

		//로봇 회전
		int size = robots.size();

		while(size-->0) {
			int robot = robots.poll()+1;
			if(robot != N-1) robots.add(robot);
		}
	}


	public static void move() {

		int size = robots.size();

		while(size-->0) {

			int robot = robots.poll();

			if(isExistRobot(robot+1) || belt[robot+1]<=0) {
				robots.add(robot);

			}else {
				belt[robot+1]--;
				if(robot+1 != N-1) robots.add(robot+1);
			}
		}
	}

	public static boolean isExistRobot(int robot) {
		for (int i : robots) {
			if(robot == i) return true;
		}
		return false;
	}


	public static void put() {
		if(belt[0]>=1) {

			robots.add(0);
			belt[0]--;
		}


	}


	public static boolean checkEnd() {
		int cnt = 0;

		for (int i : belt) {
			if(i<=0) cnt++;
		}
		return cnt>=K ? true: false;

	}


}
