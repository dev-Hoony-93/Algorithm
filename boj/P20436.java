package Algorithm.boj;

import java.util.HashMap;
import java.util.Scanner;

/**
 * boj - P20436 ZOAC 3
 *
 * 시뮬레이션
 * 왼손 오른손 각각 Map에 넣어서 풀었다.
 *
 * */
public class P20436 {

    public static void main(String[] args) {

        HashMap<String, Point> leftMap = new HashMap<>();
        HashMap<String, Point> rightMap = new HashMap<>();
        leftMap.put("q",new Point(0,0));
        leftMap.put("w",new Point(1,0));
        leftMap.put("e",new Point(2,0));
        leftMap.put("r",new Point(3,0));
        leftMap.put("t",new Point(4,0));
        leftMap.put("a",new Point(0,1));
        leftMap.put("s",new Point(1,1));
        leftMap.put("d",new Point(2,1));
        leftMap.put("f",new Point(3,1));
        leftMap.put("g",new Point(4,1));
        leftMap.put("z",new Point(0,2));
        leftMap.put("x",new Point(1,2));
        leftMap.put("c",new Point(2,2));
        leftMap.put("v",new Point(3,2));

        rightMap.put("y",new Point(1,0));
        rightMap.put("u",new Point(2,0));
        rightMap.put("i",new Point(3,0));
        rightMap.put("o",new Point(4,0));
        rightMap.put("p",new Point(5,0));
        rightMap.put("h",new Point(1,1));
        rightMap.put("j",new Point(2,1));
        rightMap.put("k",new Point(3,1));
        rightMap.put("l",new Point(4,1));
        rightMap.put("b",new Point(0,2));
        rightMap.put("n",new Point(1,2));
        rightMap.put("m",new Point(2,2));

        Scanner sc = new Scanner(System.in);

        int time = 0;
        String [] startPoints = sc.nextLine().split(" ");
        Point left = leftMap.get(startPoints[0]);
        Point right = rightMap.get(startPoints[1]);

        String [] arr = sc.nextLine().split("");

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if(leftMap.containsKey(s)){
                Point point = leftMap.get(s);
                time += Math.abs(left.x- point.x) + Math.abs(left.y - point.y)+1;
                left = point;
            }else{
                Point point = rightMap.get(s);
                time += Math.abs(right.x- point.x) + Math.abs(right.y - point.y)+1;
                right = point;
            }
        }
        System.out.println(time);
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
