package Algorithm.boj;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * boj - P6593 상범빌딩
 *
 * 3차원 bfs문제
 *
 * */

public class P6593 {

    static int dx [] = {0,1,0,-1,0,0};
    static int dy [] = {1,0,-1,0,0,0};
    static int dz [] = {0,0,0,0,1,-1};

    static int L,R,C;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        while(true){

            Point startPoint = null;
            L = scanner.nextInt();
            R = scanner.nextInt();
            C = scanner.nextInt();
            if(L==0 &&R==0 &&C==0 ) break;
            scanner.nextLine();


            // 0 빈곳 1 막힌곳 2 도착지점
            char [][][] map = new char [R][C][L];
            boolean isVisited[][][] = new boolean[R][C][L];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String row = scanner.nextLine();
                    for (int k = 0; k < C; k++) {
                        map[j][k][i] = row.charAt(k);
                        if(map[j][k][i] == 'S') {
                            startPoint = new Point(j,k,i,0);
                            isVisited[j][k][i] = true;
                        }
                    }
                }
                scanner.nextLine();
            }

            Queue<Point> que = new PriorityQueue<>();
            que.add(startPoint);

            int length = 0;
            while(!que.isEmpty()){
                Point p = que.poll();
                System.out.println(que);
                if(map[p.x][p.y][p.z] == 'E') {
                    length = p.d;
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int nx = p.x +dx[i];
                    int ny = p.y +dy[i];
                    int nz = p.z +dz[i];

                    if(!isRange(nx,ny,nz)) continue;
                    if(map[nx][ny][nz]=='#') continue;
                    if(isVisited[nx][ny][nz]) continue;
                    isVisited[nx][ny][nz] = true;
                    que.add(new Point(nx,ny,nz,p.d+1));
                }
            }
            if(length!= 0) System.out.println("Escaped in "+length+" minute(s).");
            else System.out.println("Trapped!");
        }

    }
    static boolean isRange(int x,int y, int z){
        return x >= 0 && y >= 0 && z >= 0 && x < R && y < C && z < L;
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int z;
        Integer d;
        public Point(int x, int y, int z,int d) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    ", d=" + d +
                    '}';
        }

        @Override
        public int compareTo(Point o) {
            return this.d.compareTo(o.d);
        }
    }


}
