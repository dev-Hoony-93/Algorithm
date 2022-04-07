package Algorithm.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * boj - P3187 양치기 꿍
 *
 * BFS
 *
 *
 * */

public class P3187 {

    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int R,C,maxV,maxK;
    static char [][] board;
    static boolean [][] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        board  = new char[R][C];
        visit  = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = sc.next();
            for (int j = 0; j < C; j++) {
                board[i][j] =str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bfs(i,j);
            }
        }
        System.out.println(maxK + " " + maxV );

    }

    static void bfs(int x,int y){

        int v=0;
        int k=0;
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(x,y));

        while(!que.isEmpty()){
            Point p = que.poll();

            if(visit[p.x][p.y])continue;
            visit[p.x][p.y] = true;
            if(board[p.x][p.y] == '#') continue;
            if(board[p.x][p.y] == 'v') v++;
            if(board[p.x][p.y] == 'k') k++;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(!isRange(nx,ny))continue;
                if(visit[nx][ny])continue;
                if(board[nx][ny] == '#') continue;
                que.add(new Point(nx,ny));
            }
        }
        if(k<=v){
            maxV +=v;
        }else{
            maxK += k;
        }

    }
    static boolean isRange(int x,int y){
        return x >= 0 && y >= 0 && x<R && y<C;
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
