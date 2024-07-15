package kangyuseok;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_2667 {
    static int[][] arr;
    static int n;
    static int sns = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        sc.nextLine();  // consume the newline character

        for (int i = 0; i < n; i++) {
            String st = sc.nextLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = st.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sns = 0;
                if (arr[i][j] == 0) continue;
                dfs(i, j);
                cnt++;
                result.add(sns);
            }
        }

        Collections.sort(result);
        System.out.println(cnt);
        for (int r : result) {
            System.out.println(r);
        }

        sc.close();
    }

    public static void dfs(int row, int col) {
        arr[row][col] = 0;
        sns++;
        for (int i = 0; i < 4; i++) {
            int x = dx[i] + row;
            int y = dy[i] + col;
            if (x >= 0 && y >= 0 && x < n && y < n && arr[x][y] == 1) {
                dfs(x, y);
            }
        }
    }
    
}
