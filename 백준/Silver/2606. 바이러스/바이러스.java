import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] visit;
    public static ArrayList<Integer>[] graph;

    public static int bfs(int start){
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int i: graph[node]){
                if(!visit[i]){
                    visit[i] = true;
                    count++;
                    queue.add(i);
                }
            }
        }


        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());

        graph = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        visit = new boolean[n+1];

        for(int i=0; i<m; i++){
            int[] infos = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<m; j++){
                graph[infos[0]].add(infos[1]);
                graph[infos[1]].add(infos[0]);
            }
        }

        for(int i=1; i<=n; i++){
            Collections.sort(graph[i]);
        }

        int count = bfs(1);

        out.write(Integer.toString(count));
        out.flush();
        out.close();
        in.close();
    }
}