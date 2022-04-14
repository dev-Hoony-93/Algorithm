package Algorithm.boj;

import java.util.*;

/**
 * boj - P22944 죽음의 비
 *
 * bfs인데, visited에 보통 true, false이지만 int값을 넣어서 방문했을때의 체력으로 비교를 해줬다.
 *
 *
 *
 * */
public class P22944 {

    static int N;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int H = sc.nextInt();
        int D = sc.nextInt();
        LinkedList<Point> que = new LinkedList<>();

        char [][] map = new char[N][N];
        int [][] visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j]=='S') que.add(new Point(i,j,H+1,0,0));
            }
        }

        int min = 99999;

        while(!que.isEmpty()){
            Point p = que.poll();

            if(map[p.x][p.y] =='E') {
                //최소거리 세팇
                min = Math.min(min,p.dis);
                break;
            }

            if(p.d >0){
                p.d--;
            }else{
                p.h--;
            }
            if(p.h ==0) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(!isRange(nx,ny)) continue;
                if(visited[nx][ny] < p.d+p.h ){
                    visited[nx][ny] = p.d+p.h;
                    if(map[nx][ny] == 'U'){
                        que.add(new Point(nx,ny,p.h,D,p.dis+1));
                    }else{
                        que.add(new Point(nx,ny,p.h,p.d,p.dis+1));
                    }
                }
            }
        }
        System.out.println(min==99999?-1:min);
    }

    static boolean isRange(int x,int y){
        return x >= 0 && y >= 0 && x<N && y<N;
    }

    static class Point{
        int x;
        int y;
        int h;
        int d; // 우산 내구도
        int dis;

        public Point(int x, int y, int h, int d, int dis) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.d = d;
            this.dis = dis;
        }
    }
}
