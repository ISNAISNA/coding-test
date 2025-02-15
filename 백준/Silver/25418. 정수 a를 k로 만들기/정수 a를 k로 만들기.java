import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] infos = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int a = infos[0];
        int k = infos[1];

        int[] dp = new int[k+1];
        for(int i=a+1; i<=k; i++){
            dp[i] = dp[i-1]+1;
            if(i>=a*2 && i%2==0)
                dp[i] = Math.min(dp[i/2]+1, dp[i]);
        }

        out.write(Integer.toString(dp[k]));

        out.flush();
        out.close();
        in.close();
    }
}