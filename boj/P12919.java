package Algorithm.boj;

import java.util.Scanner;

/**
 * boj - P12919 A와 B 2
 *
 * 문자열, 구현, 백트래킹, 재귀
 * 좋은문제였다.
 * 문제에서는 s에서 붙여가는걸 설명했는데, !t에서 줄일수 있는경우!를 생각해서 반대로 풀면 풀수 있다.
 *
 * */
public class P12919 {
    static int ans = 0;
//    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String S = sc.next();
        String T = sc.next();


        recur(S,T);
        System.out.println(ans);
    }

    static void recur(String S , String t){
//        System.out.println(t);
        if(S.equals(t)){
            ans = 1;
            return ;
        }
        if(S.length()>=t.length()){
            return;
        }
        //BABA
        //  BAB
        //
        //  ABA

        if(t.charAt(t.length()-1)=='A'){
            recur(S, t.substring(0,t.length()-1));
        }

        if(t.charAt(0)=='B'){
            StringBuilder sb = new StringBuilder(t.substring(1));
            sb.reverse();
            recur(S, sb.toString());
        }





    }
}
