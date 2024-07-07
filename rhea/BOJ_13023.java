package rhea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023 {
    static  int N, M;
    static ArrayList<Integer>[] edge;
    static boolean[] visited; // 중복 체크
    static int ans;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 노드 수
        M = Integer.parseInt(st.nextToken()); // 엣지 수
        edge = new ArrayList[N]; // 엣지 저장 배열
        visited = new boolean[N];

        // 엣지 정보 저장 위해서 각 요소에 ArrayList 할당
        for (int i=0;i<N;i++) {
            edge[i] = new ArrayList<Integer>();
        }

        // 관계 입력
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양방향
            edge[a].add(b);
            edge[b].add(a);
        }

        // dfs 탐색
        for(int i=0;i<N;i++) {
            visited[i] = true; // 방문 표시
            dfs(i, 0); // dfs 탐색
            visited[i] = false;

            // ans == 1이면 종료
            if(ans == 1) {
                break;
            }
        }
        System.out.println(ans);

    }
    static void dfs(int n, int cnt) {
        // 친구 관계가 4개 이상이면(조건 만족) ans = 1
        if(cnt >= 4) {
            ans = 1;
            return;
        }

        // 현재 노드에 연결된 모든 노드 탐색
        for(int i : edge[n]) {
            if(!visited[i]) { // 연격된 노드 중 탐색하지 않은 노드이면
                visited[i] = true; // 방문 표시 후
                dfs(i, cnt + 1); // 탐색
                visited[i] = false;
            }  // backtracking 1. visited[i] = false; 2. edge[n].remove(i); 3. dfs(i, cnt + 1); 4. Collections.sort(edge[n], Collections.reverseOrder()); 5. edge[n].sort((o1, o2) -> {
        }
    }
}

