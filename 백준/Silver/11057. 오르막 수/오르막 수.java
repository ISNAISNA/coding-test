import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        final int MOD = 10007;

        int[][] dp = new int [n+1][10];

        for(int i=0; i<=9; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                for(int k=j; k<=9; k++){
                    dp[i][k] += (dp[i-1][j]%MOD);
                }
            }
        }

        bw.write(Long.toString((Arrays.stream(dp[n]).sum()%MOD)));
        bw.flush();
        bw.close();
        br.close();
    }
}