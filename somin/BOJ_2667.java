package somin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2667 {
    static int N;
    static String[][] board;
    static boolean[][] visited;
    static List<Integer> answer = new ArrayList<>();
    static int count = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new String[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            board[i] = line.split("");
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (board[i][j].equals("0") || visited[i][j]) continue;
                visited[i][j] = true;
                answer.add(bfs(i, j));
            }
        }

        Collections.sort(answer);
        System.out.println(count);
        for (Integer i : answer) {
            System.out.println(i);
        }
    }

    public static int bfs(int x, int y) {
        int cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx <N && ny >= 0 && ny < N && board[nx][ny].equals("1") && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    cnt++;
                }
            }
        }

        count++;
        return cnt;
    }
}
