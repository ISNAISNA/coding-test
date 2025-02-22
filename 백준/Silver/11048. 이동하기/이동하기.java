import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        int[] info = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int m = info[1];

        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++){
            int[] point = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<point.length; j++){
                map[i][j] = point[j];
            }
        }

        int[] dx = new int[]{0, 1, 1};
        int[] dy = new int[]{1, 1, 0};

        dp[0][0] = map[0][0];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<3; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx>=n||ny>=m){
                        continue;
                    }
                    dp[nx][ny] = Math.max(dp[i][j]+map[nx][ny], dp[nx][ny]);
                }

            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}