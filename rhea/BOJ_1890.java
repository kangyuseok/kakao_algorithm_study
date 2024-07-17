package rhea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890 {
    static int N;
    static int[][] board;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        dp = new long[N][N];

        // 게임판에 숫자 입력
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 배열 초기화
        dp[0][0] = 1;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                // 마지막 칸에 도달한 경우
                if(i == N-1 && j == N-1) {
                    break;
                }
                // 0인 경우는 패스 (이동 불가)
                if(dp[i][j] == 0) {
                    continue;
                }
                // 오른쪽, 아래로 이동
                int jump = board[i][j];
                // 오른쪽, 아래로 이동 가능한 경우 dp 배열에 값 더하기
                if(i+jump < N) {
                    dp[i+jump][j] += dp[i][j];
                }
                if(j+jump < N) {
                    dp[i][j+jump] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
}
