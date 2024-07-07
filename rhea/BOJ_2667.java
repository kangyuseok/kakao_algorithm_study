package rhea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2667 {
    static int N, cnt;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0}; // 방향 체크
    static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 지도 크기
        map = new int[N][N];

        // 지도 정보
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = str.charAt(j) - '0'; // 각 문자를 정수로 변환후 저장
            }
        }

        ArrayList<Integer> arr = new ArrayList<>(); // 집의 수 저장용 배열
        int ans = 0; // 단지의 수
        // 지도 순회 & 단지 탐색
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                cnt = 0;
                // 집 위치에서 DFS 탐색 시작
                if(map[i][j] == 1){
                    dfs(i,j);
                    arr.add(cnt); // 집의 수 센 후 저장
                    ans++; // 단지 수 증가
                }
            }
        }

        Collections.sort(arr); // 오름차순 정렬
        System.out.println(ans);
        for(int i : arr){
            System.out.println(i); // 한줄에 하나씩 출력
        }
    }

    public static void dfs(int x, int y){
        map[x][y] = 0; // 현재 위치 빙믄 표시
        cnt += 1; // 집의수 증가

        // 다음에 이동할 위치 걔산
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 지도 범위 내에 있고 집이 있는 경우 탐색 지속
            if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]==1) dfs(nx, ny);
        }
    }
}
