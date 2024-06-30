package somin;

import java.io.*;
import java.util.*;

public class BOJ_16918 {

    static int r;
    static int c;

    static Queue<int[]> q = new LinkedList<>();

    static String[][] board;
    static String[][] tmp;

    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        board = new String[r][c];
        tmp = new String[r][c];

        for (int i=0; i<r; i++) {
            board[i] = br.readLine().split("");
        }

        init();

        if (n % 2 == 0) {
            for (int i=0; i<r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(tmp[i][j]);
                }
                System.out.println();
            }
            return;
        }

        for (int k=2; k<=n; k++) {
            if (k % 2 == 0) {
                init();
                continue;
            }

            for (int i=0; i<r; i++) {
                for (int j = 0; j < c; j++) {
                    if (board[i][j].equals(".")) continue;

                    tmp[i][j] = ".";
                    bomb(i, j);

                }
            }

            copyBoard();
        }

        for (int i=0; i<r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    public static void init() {
        for (int i=0; i<r; i++) {
            for (int j = 0; j < c; j++) {
                tmp[i][j] = "O";
            }
        }
    }

    public static void bomb(int x, int y) {
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && tmp[nx][ny].equals("O")) tmp[nx][ny] = ".";
        }
    }

    public static void copyBoard() {
        for (int i=0; i<r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = tmp[i][j];
            }
        }
        init();
    }
}