import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static BufferedWriter out;
    public static boolean[][] visit;
    public static int[][] map;
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static void bfs(int x, int y){

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        visit[x][y] = true;

        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();

            for(int i=0; i<4; i++){
                int nx = currentPoint.x + dx[i];
                int ny = currentPoint.y + dy[i];

                if(nx <= 0 || ny <= 0 || nx > n || ny > m)
                    continue;

                if(map[nx][ny] == 0 || visit[nx][ny])
                    continue;

                map[nx][ny] = map[currentPoint.x][currentPoint.y]+1;
                visit[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        visit = new boolean[n+1][m+1];

        for(int i=0; i<n; i++){
            int[] infos = Arrays.stream(in.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<m; j++){
                map[i+1][j+1] = infos[j];
            }
        }

        bfs(1,1);

        out.write(Integer.toString(map[n][m]));
        out.flush();
        out.close();
        in.close();
    }
}