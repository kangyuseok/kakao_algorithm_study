package somin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16937 {
    static int H;
    static int W;
    static int[][] arr;
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(arr[i][0] + arr[j][0] <= H && Math.max(arr[i][1], arr[j][1]) <= W ||
                        arr[i][0] + arr[j][0] <= W && Math.max(arr[i][1], arr[j][1]) <= H) {
                    sum = arr[i][0] * arr[i][1] + arr[j][0] * arr[j][1];
                }
                else if(arr[i][0] + arr[j][1] <= H && Math.max(arr[i][1], arr[j][0]) <= W ||
                        arr[i][0] + arr[j][1] <= W && Math.max(arr[i][1], arr[j][0]) <= H) {
                    sum = arr[i][0] * arr[i][1] + arr[j][0] * arr[j][1];
                }
                else if(arr[i][1] + arr[j][0] <= H && Math.max(arr[i][0], arr[j][1]) <= W ||
                        arr[i][1] + arr[j][0] <= W && Math.max(arr[i][0], arr[j][1]) <= H) {
                    sum = arr[i][0] * arr[i][1] + arr[j][0] * arr[j][1];
                }
                else if(arr[i][1] + arr[j][1] <= H && Math.max(arr[i][0], arr[j][0]) <= W ||
                        arr[i][1] + arr[j][1] <= W && Math.max(arr[i][0], arr[j][0]) <= H) {
                    sum = arr[i][0] * arr[i][1] + arr[j][0] * arr[j][1];
                }
                answer = Math.max(answer, sum);
            }
        }

        System.out.println(answer);
    }
}
