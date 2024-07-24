package somin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        long[][] dp = new long[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (dp[i][j] == 0) continue;
                if (i == N-1 && j == N-1) break;

                if (i + arr[i][j] < N) dp[i + arr[i][j]][j] += dp[i][j];
                if (j + arr[i][j] < N) dp[i][j + arr[i][j]] += dp[i][j];
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}
