import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static char[][] map;
    public static boolean[][] visit;
    public static int count = 0;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void bfs(int x, int y){

        if(map[x][y]=='P')
            count++;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 ||ny<0 || nx>=n||ny>=m)
                continue;
            if(!visit[nx][ny] && map[nx][ny]!='X'){
                visit[nx][ny] = true;
                bfs(nx, ny);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] mapInfo = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = mapInfo[0];
        m = mapInfo[1];

        map = new char[n][m];
        visit = new boolean[n][m];

        int x=0, y=0;

        for(int i=0; i<n; i++){
            char[] infos = in.readLine().toCharArray();
            for(int j=0; j<infos.length; j++){
                map[i][j] = infos[j];
                if(infos[j]=='I'){
                    x = i;
                    y = j;
                }
            }
        }

        visit[x][y]= true;
        bfs(x, y);

        System.out.print(count==0 ? "TT":count);
    }
}