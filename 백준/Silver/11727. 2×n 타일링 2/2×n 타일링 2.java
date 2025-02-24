import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        final int MOD = 10007;

        int[] dp = new int[n+1];

        dp[1] = 1;
        if(n>=2)
            dp[2] = 3;

        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1]+dp[i-2]*2)%MOD;
        }

        System.out.println(dp[n]);
    }
}