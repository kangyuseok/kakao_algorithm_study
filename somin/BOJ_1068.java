package somin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1068 {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int root;
    static int answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        visited = new boolean[N];

        for (int i=0; i<N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == -1) root = i;
            else tree[tmp].add(i);
        }

        int del = Integer.parseInt(br.readLine());

        if (del == root) {
            System.out.println(0);
            return;
        }

        visited[del] = true;
        visited[root] = true;

        bfs();
        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int parent = q.poll();
            boolean child = false;

            for (int c : tree[parent]) {
                if (!visited[c]) {
                    visited[c] = true;
                    child = true;
                    q.add(c);
                }
            }

            if (!child) answer++;
        }
    }
}
