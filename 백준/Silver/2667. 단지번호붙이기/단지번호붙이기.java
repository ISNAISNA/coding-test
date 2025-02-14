import java.io.*;
import java.util.*;

public class Main {
    public static boolean[][] visit;
    public static List<Integer> house;
    public static int[] dx = new int[] {-1, 0, 1, 0};
    public static int[] dy = new int[] {0, 1, 0, -1};
    public static int n;
    public static int count = 1;

    public static void dfs(int x, int y){
        for(int i=0; i<4; i++){
            int nX = x + dx[i];
            int nY = y + dy[i];

            if(nX>=1 && nY>=1 && nX<=n && nY<=n&&visit[nX][nY]){
                visit[nX][nY] = false;
                count++;
                dfs(nX, nY);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


        n = Integer.parseInt(in.readLine());
        house = new ArrayList<>();
        visit = new boolean[n+1][n+1];

        for(int i=0; i<n; i++){
            int[] infos = Arrays.stream(in.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<n; j++){
                visit[i+1][j+1] = infos[j] == 1;
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(visit[i][j]){
                    count=1;
                    visit[i][j] = false;
                    dfs(i,j);
                    house.add(count);
                }
            }
        }

        house.sort(Comparator.naturalOrder());
        out.write(house.size() + "\n");
        for (int integer : house) {
            out.write(integer + "\n");
        }
        out.flush();
        out.close();
        in.close();
    }
}