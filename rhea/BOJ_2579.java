package rhea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 계단의 개수
        int[] stairs = new int[N+1]; // 계단 점수

        // 계단 점수 입력
        for(int i=1; i<=N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // 각 계단까지의 최대 점수
        int[] dp = new int[N+1];

        // 계단의 개수가 1일 때
        if(N == 1) {
            System.out.println(stairs[1]);
            return;
        }

        dp[1] = stairs[1];

        // 계단의 개수가 2 이상인 경우 두번째 계단까지의 최대 점수 계산
        if(N >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        // 세번째 계단부터 최대 점수 계산
        for(int i=3; i<=N; i++) {
            // 두 계단 전에서 오는 경우와 세 계단 전에서 오는 경우 중 큰 값에 현재 계단 점수 더함
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }

        // 마지막 계단까지의 최대 점수를 출력
        System.out.println(dp[N]);
    }
}

