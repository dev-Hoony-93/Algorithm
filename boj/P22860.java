package Algorithm.boj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * boj - P22860 폴더 정리 (small)
 *
 * 구현문제.
 *
 * Map , arrayList 이용해서 품
 * 실수한점 : main폴더부터 나온다고 착각해서 틀림
 *
 * */
public class P22860 {

    static int fileCnt =0;
    static HashSet<String> fileSet;

//    static int folderCnt =0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String , ArrayList<String>> folderMap = new HashMap<>();

        folderMap.put("main",new ArrayList<>());

        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < N+M; i++) {
            String parentFolder = sc.next();
            String thisName = sc.next();
            boolean isFile = sc.nextInt() != 1;
            if(!folderMap.containsKey(parentFolder))
                folderMap.put(parentFolder,new ArrayList<>());

            ArrayList<String> arrayList = folderMap.get(parentFolder);
            arrayList.add(thisName);

            if(!isFile){
                if(!folderMap.containsKey(thisName))
                    folderMap.put(thisName,new ArrayList<>());
            }
//            System.out.println(folderMap);
        }
//        System.out.println(folderMap);

        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            String query = sc.next();
            String[] pathArr = query.split("/");
            String folder = pathArr[pathArr.length-1];
//            System.out.println(folder);

            fileCnt =0;
            fileSet=new HashSet<>();
            check(folderMap,folder);

            System.out.println(fileSet.size()+" "+fileCnt);
        }

    }

    static void check(HashMap<String , ArrayList<String>> folderMap, String folderName){
        ArrayList<String> folderAndFileList = folderMap.get(folderName);
        for ( String name: folderAndFileList ) {
            if(!folderMap.containsKey(name)){
                fileCnt++;
                fileSet.add(name);
            }else{
                check(folderMap,name);
            }
        }



    }
}
