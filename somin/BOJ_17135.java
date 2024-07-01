package somin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17135 {
    static int n, m, d;
    static int answer = 0;
    static int[][] board;
    static int[] archers;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        archers = new int[3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pick(0, 0);
        System.out.println(answer);
    }

    // 궁수 3명 뽑기
    public static void pick(int cnt, int start) {
        if (cnt == 3) {
            answer = Math.max(answer, game());
            return;
        }

        for (int i=start; i<m; i++) {
            archers[cnt] = i;
            pick(cnt + 1, i + 1);
        }
    }

    // 게임 시작
    public static int game() {
        int cnt = 0;
        int[][] status = new int[n][m];

        for (int line=n; line>0; line--) {
            for (int archer : archers){
                for (int dis=1; dis<=d; dis++) {

                    int cur = attack(status, dis, line, archer);
                    if (cur<0) continue;
                    cnt += cur;
                    break;
                }
            }
        }

        return cnt;
    }

    public static int attack(int[][] status, int d, int line, int archer) {
        int nn;

        for (int nm=archer-d; nm<=archer+d; nm++) {
            nn = line-(d-Math.abs(nm-archer));
            if (nn<0 || nn>=line || nm<0 || nm>=m) continue;
            if(board[nn][nm] == 0) continue;
            if (status[nn][nm] == 0) {
                status[nn][nm] = line;
                return 1;
            } else if (status[nn][nm] == line) return 0;
        }

        return -1;
    }
}
