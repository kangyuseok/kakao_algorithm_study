package kangyuseok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13023 {
    static int n;
    static int m;

    static List<Integer>[]list;
    static boolean[]visit;

    static boolean isSuccess;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new List[n];
        visit = new boolean[n];
        for(int i=0;i<n;i++)list[i] = new ArrayList<>();

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=0;i<n;i++){
            visit[i] = true;
            dfs(i, 1);
            Arrays.fill(visit, false);
            if(isSuccess)break;
        }

        if(isSuccess) System.out.println(1);
        else System.out.println(0);

    }
    static void dfs(int v, int cnt){
        if(cnt == 5){
            isSuccess = true;
            return;
        }


        for(int i : list[v]){
            if(!visit[i]){
                visit[v] = true;
                dfs(i, cnt+1);
                visit[v] = false;
            }
        }
    }
}
