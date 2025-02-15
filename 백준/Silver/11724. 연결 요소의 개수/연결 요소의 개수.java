import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    public static List<Integer>[] map;
    public static boolean[] visit;
    public static int n;

    public static void dfs(int start){
        visit[start]=true;
        for(int i=0; i<map[start].size(); i++){
            int node = map[start].get(i);
            if(!visit[node]){
                dfs(node);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] infos = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = infos[0];
        int m = infos[1];

        map = new ArrayList[n+1];
        visit = new boolean[n+1];

        for(int i=0; i<n; i++){
            map[i+1] = new ArrayList<>();
        }

        for(int i=1; i<=m; i++){
            int[] nodes = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[nodes[0]].add(nodes[1]);
            map[nodes[1]].add(nodes[0]);
        }
        int count = 0;
        for(int i=1; i<=n; i++){
            if(!visit[i]){
                dfs(i);
                count++;
            }
        }

        out.write(Integer.toString(count));

        out.flush();
        out.close();
        in.close();
    }
}