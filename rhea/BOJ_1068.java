package rhea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1068 {
    static ArrayList<Integer>[] tree;
    static int del; // 삭제할 노드
    static int root; // 루트 노드
    static int ans; // 리프 노드 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) { // 트리 초기화
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        del = Integer.parseInt(br.readLine());

        root = -1;
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken()); // 부모 노드 읽음
            if (parent == -1) { // 루트 노드인지 확인
                root = i; // 루트 노드에 인덱스 저장
            } else {
                tree[parent].add(i); // 자식관계 설정
            }
        }

        // 루트 노드가 삭제되는 경우 처리
        if (del == root) {
            System.out.println(0);
            return;
        }

        dfs(root);

        System.out.println(ans);
    }

    public static void dfs(int node) {
        if (node == del) {
            return;
        }

        // 리프 노드 판별
        if (tree[node].isEmpty()) {
            ans++;
            return;
        }

        boolean isLeaf = true;
        for (int child : tree[node]) {
            if (child != del) {
                isLeaf = false;
                dfs(child);
            }
        }

        // 자식이 있지만 모두 삭제된 경우를 처리하기 위해 isLeaf 체크
        if (isLeaf) {
            ans++;
        }
    }
}
