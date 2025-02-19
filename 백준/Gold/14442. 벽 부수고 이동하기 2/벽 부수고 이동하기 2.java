import java.io.*;
import java.util.*;

public class Main {
    public static int[][] map;
    public static boolean[][][] visit;
    public static int n, m, k;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    static int minDistance = Integer.MAX_VALUE;

    public static class Move{
        int x, y;
        int count;
        int distance;
        public Move(int x, int y, int count, int distance){
            this.x = x;
            this.y = y;
            this.count = count;
            this.distance = distance;
        }
    }

    public static void bfs(int x, int y){
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(x, y, k, 1));

        while(!queue.isEmpty()){
            Move move = queue.poll();
            int distance = move.distance;

            if(x == n-1 && y == m-1){
                 minDistance = Math.min(minDistance, distance);
                 return;
            }

            for(int i=0; i<4; i++){
                int nx = move.x + dx[i];
                int ny = move.y + dy[i];
                int count = move.count;

                if(nx == n-1 && ny == m-1){
                    minDistance = Math.min(minDistance, distance+1);
                }

                if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if(map[nx][ny]==1){
                    if(count > 0)
                        count--;
                    else
                        continue;
                }

                if(!visit[nx][ny][count]){
                    visit[nx][ny][count] = true;
                    queue.add(new Move(nx, ny, count, distance+1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = numbers[0];
        m = numbers[1];
        k = numbers[2];

        map = new int[n][m];
        visit = new boolean[n][m][k+1];

        for(int i=0; i<n; i++) {
            int[] infos = Arrays.stream(in.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<m; j++) {
                map[i][j] = infos[j];
            }
        }

        bfs(0,0);
        System.out.println(minDistance==Integer.MAX_VALUE?-1:minDistance);
    }
}