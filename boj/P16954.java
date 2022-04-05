package Algorithm.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * boj - P16954 움직이는 미로탈출
 *
 * BFS , 3차원 visited로 해결했음
 *
 *
 * */
public class P16954 {

    static int[] dx= {0,0,-1,1,1,-1,-1,0,1};
    static int[] dy= {1,-1,0,1,-1,1,-1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int [8][8];
        boolean[][][] isVisited = new boolean[8][8][64];
        for (int i = 0; i < 8; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < 8; j++) {
                board[i][j] = str.charAt(j)=='.'? 0:1;
            }
        }
        int answer = 0;
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(7,0,0));
        while(!que.isEmpty()){
            Point p = que.poll();


            if(p.x ==0 &&p.y ==7){
                answer =1;
                break;
            }
            if(p.t <=7 && board[(p.x-p.t+8)%8][p.y] == 1 ) continue;
            if(p.t ==63) continue;
            for (int i = 0; i < 9; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(!isRange(nx,ny)) continue;
                if(p.t <=7 && board[(nx-p.t+8)%8][ny] == 1 ) continue;
                if(isVisited[nx][ny][p.t+1]) continue;
                isVisited[nx][ny][p.t+1] = true;
                que.add(new Point(nx,ny,p.t+1));

            }
        }

        System.out.println(answer);


    }

    static boolean isRange(int x,int y){
        return x >= 0 && y >= 0 && x<8 && y<8;
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        Integer t;

        public Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", t=" + t +
                    '}';
        }

        @Override
        public int compareTo(Point o) {
            return o.t.compareTo(this.t);
        }
    }
}
