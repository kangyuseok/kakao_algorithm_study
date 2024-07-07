package rhea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16937 {
    static int H, W, N; // 입력받을 정수
    static int[][] sticker; // 스티커 크기 저장용 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken()); // 스티커 높이
        W = Integer.parseInt(st.nextToken()); // 스티커 넓이

        N = Integer.parseInt(br.readLine().trim()); // 스티커 개수

        // 스티커 2장
        sticker = new int[N][2];

        // 스티커 크기 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sticker[i][0] = Integer.parseInt(st.nextToken());
            sticker[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = 0; // 최대 넓이
        // 스티커 중 2 장을 선택하기 위해, 모든 조합에 대한 최대 넓이 계산
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                max = Math.max(max, MaxArea(sticker[i], sticker[j], H, W));
            }
        }
        System.out.println(max);
    }

    private static int MaxArea(int[] sticker1, int[] sticker2, int H, int W) {
        int maxArea = 0; // 최대 넓이 저장용 변수
        // 스티커 회전 경우의 수 (스티커1과 스티커 2를 회전시켜 배치하는 경우) ㅡ
        int[][] area = {
                {sticker1[0], sticker1[1], sticker2[0], sticker2[1]},
                {sticker1[0], sticker1[1], sticker2[1], sticker2[0]},
                {sticker1[1], sticker1[0], sticker2[0], sticker2[1]},
                {sticker1[1], sticker1[0], sticker2[1], sticker2[0]}
        };

        // 회전 반복
        for (int[] a : area) {
            // 스티커 배치 가능한지 확인
            if ((a[0] + a[2] <= H && Math.max(a[1], a[3]) <= W) ||
                    (a[0] + a[2] <= W && Math.max(a[1], a[3]) <= H)) {
                int stckArea = a[0] * a[1] + a[2] * a[3]; // 가능한 경우 넓이 계산
                maxArea = Math.max(maxArea, stckArea); // 최대 넓이 갱신
            }
        }
        return maxArea;
    }
}
