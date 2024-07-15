package rhea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2075 {
    static int N;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<>();

        // 첫 줄에 N개의 수 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        // Queue N 개 입력
        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                Integer num = Integer.parseInt(st.nextToken());

                // 큐의 마지막 값보다 크면 큐에 넣고 가장 작은 값 제거
                if(queue.peek() < num){
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        System.out.println(queue.poll());
    }
}
