package somin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5212 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] arr = new char[R][C];
        char[][] answer = new char[R][C];

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int minR = 10;
        int minC = 10;
        int maxR = 0;
        int maxC = 0;

        for (int i=0; i<R; i++) {
            String input = br.readLine();
            arr[i] = input.toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 'X') { // 땅인 경우
                    int cnt = 0; // 주변 바다 수
                    for (int k = 0; k < 4; k++) { // 4방향 탐색
                        int x = i + dx[k];
                        int y = j + dy[k];

                        // 지도 밖인 경우에는 바다
                        if ((x == -1 || y == -1 || x == R || y == C) || arr[x][y] == '.') {
                            cnt++;
                        }
                    }

                    if (cnt < 3) { // 3면 이하가 바다인 경우
                        answer[i][j] = 'X';

                        minR = Math.min(minR, i); // 지도 출력 범위 갱신
                        minC = Math.min(minC, j);
                        maxR = Math.max(maxR, i);
                        maxC = Math.max(maxC, j);
                    } else {
                        answer[i][j] = '.';
                    }
                } else {
                    answer[i][j] = '.';
                }
            }
        }

        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
    }
}
