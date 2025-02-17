import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MOD = 10007;

        int n = Integer.parseInt(in.readLine());


        int[] dp = new int[n+1];

        dp[1] = 1;
        if(n>=2)
            dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1]+dp[i-2])%MOD;
        }


        out.write(Integer.toString(dp[n]));

        out.flush();
        out.close();
        in.close();
    }
}