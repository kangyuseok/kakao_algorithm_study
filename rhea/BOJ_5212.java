package rhea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5212 {
    static int R, C;
    static char[][] map;
    static char[][] check;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        check = new char[R][C];

        // 지도 입력
        for(int i=0;i<map.length;i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
            check[i] = str.toCharArray();
        }

        // 섬이 잠기는지 확인
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[i].length;j++) {
                if(map[i][j] == 'X') {
                    int cnt = 0;

                    // 상하좌우 탐색하며 확인
                    for(int k=0;k<4;k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        // 범위 밖이면 바다로 간주
                        if(ny < 0 || ny >= R || nx < 0 || nx >= C) {
                            cnt++;
                            // 범위내에서 바다
                        } else if(map[ny][nx] == '.') {
                            cnt++;
                        }
                    }

                    // 인접한 세칸, 네칸 바다인 경우
                    if(cnt >= 3) {
                        check[i][j] = '.';
                    }
                }
            }
        }

        // 새로운 지도 범위
        int minRow = R, maxRow = 0, minCol = C, maxCol = 0;

        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(check[i][j] == 'X') {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        for(int i = minRow; i<=maxRow; i++) {
            for(int j = minCol; j<=maxCol; j++) {
                System.out.print(check[i][j]);
            }
            System.out.println();
        }

    }
}
