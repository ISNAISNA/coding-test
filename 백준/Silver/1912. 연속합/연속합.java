import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] numbers = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[n+1];
        dp[1] = numbers[0];

        for(int i=2; i<=n; i++){
            dp[i] = Math.max(dp[i-1]+numbers[i-1], numbers[i-1]);
        }

        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n; i++){
            if(max < dp[i])
                max = dp[i];
        }

        System.out.println(max);
    }
}