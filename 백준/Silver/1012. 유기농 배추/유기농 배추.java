import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = new int[] {-1, 0, 1, 0};
    public static int[] dy = new int[] {0, 1, 0, -1};
    public static int count = 0;
    public static boolean[][] map;
    public static int n, m, k;

    public static void dfs(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<m && map[nx][ny]){
                map[nx][ny] = false;
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(in.readLine());

        for(int iter=0; iter<t; iter++){
            int[] infos = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = infos[0];
            m = infos[1];
            k = infos[2];

            map = new boolean[n][m];

            for(int j=0; j<k; j++){
                int[] p = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                map[p[0]][p[1]] = true;
            }

            for(int i = 0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j]){
                        dfs(i, j);
                        count++;
                    }
                }
            }
            out.write(count + "\n");
            count = 0;
        }

        out.flush();
        out.close();
        in.close();
    }
}