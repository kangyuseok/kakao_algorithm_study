package somin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023 {
    static int N;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        visited = new boolean[N];
        for (int i=0; i<N; i++) {
            if (answer == 1) break;
            dfs(i, 1);
        }

        System.out.println(answer);
    }

    public static void dfs(int cur, int dep) {
        if (dep == 5) {
            answer = 1;
            return;
        }

        visited[cur] = true;
        for (int to : arr[cur]) {
            if (!visited[to]) {
                dfs(to, dep + 1);
                if (answer == 1) return;  // 이미 정답을 찾은 경우 추가 탐색을 중지
            }
        }
        visited[cur] = false;

    }
}
