import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static char[][] map;
    public static boolean[][] visit;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void dfs(int x, int y, char color) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if (!visit[nx][ny] && map[nx][ny] == color) {
                dfs(nx, ny, color);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = in.readLine().toCharArray();
        }

        visit = new boolean[n][n];
        int commonCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    dfs(i, j, map[i][j]);
                    commonCount++;
                }
            }
        }

        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'R') map[i][j] = 'G'; // R을 G로 변환
            }
        }

        int colorCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    dfs(i, j, map[i][j]);
                    colorCount++;
                }
            }
        }

        System.out.print(commonCount + " " + colorCount);
    }
}