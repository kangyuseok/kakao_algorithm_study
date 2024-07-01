package kangyuseok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class BOJ_16918 {
    static int r;
    static int c;
    static int n;

    static char[][]map;
    static int[][]bombMap;

    static int[]dx = {0, 1, 0, -1};
    static int[]dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        bombMap = new int[r][c];
        for(int i=0;i<r;i++){
            String temp = br.readLine();
            map[i] = temp.toCharArray();
            for(int j=0;j<c;j++){
                if(map[i][j] == '0') bombMap[i][j] = 3;
            }
        }

//        for(int i=0;i<r;i++){
//            for(int j=0;j<c;j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
//
//        for(int i=0;i<r;i++){
//            for(int j=0;j<c;j++){
//                System.out.print(bombMap[i][j] + " ");
//            }
//            System.out.println();
//        }

        for(int i=2;i<=n;i++){
            //폭탄 설치되어있지 않은 칸에 폭탄 설치
            if(i % 2 == 0) installBomb(i);
            else go(i);
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    static void installBomb(int time){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j] == '0')continue;
                map[i][j] = '0';
                bombMap[i][j] = 3 + time;
            }
        }
    }

    static void go(int time){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(bombMap[i][j] == time){ //폭탄 터짐
                    System.out.println("ddd");
                    for(int k=0;k<4;k++){ //동서남북으로 터짐
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if(x<0||y<0||x>=r||y>=c)continue;
                        map[x][y] = '.';
                    }
                    bombMap[i][j] = 0;
                    map[i][j] = '.';
                }
            }
        }
    }
}