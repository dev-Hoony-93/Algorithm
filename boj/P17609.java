package Algorithm.boj;

import java.util.Scanner;

public class P17609 {
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            ans = 2;
            String str = sc.next();
            check(0,str.length()-1,false,str);
            System.out.println(ans);
        }

    }

    static void check(int start , int end, boolean isDeleted, String str){
//        System.out.println(start + "  "+ end+"  "+ str.charAt(start)+ " "+str.charAt(end)+ " ");
//        System.out.println();
        if(start >= end ){
            ans = isDeleted?1:0;
            return;
        }
        if(str.charAt(start) == str.charAt(end)){
            check(start+1,end-1,isDeleted,str);
        } else if ( !isDeleted) {
            check(start+1,end,true,str);
            check(start,end-1,true,str);
        }

    }
}
