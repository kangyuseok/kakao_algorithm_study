package rhea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_21318 {
    static int N; // 악보 개수
    static  int[] music; // 악보 난이도
    static int[] mistake; // 실수 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        music = new int[N+1];
        mistake = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            int num = Integer.parseInt(st.nextToken());
            music[i] = num; // 난이도 입력
            // 난이도 비교
            if(num<music[i-1]) {
                mistake[i-1]++;
            }
            mistake[i] = mistake[i-1];
        }

        st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());

        for(int i=0;i<Q;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int ans = mistake[y-1] - mistake[x-1]; // 마지막곡 제외 실수 횟수
            System.out.println(ans);
        }

    }
}
