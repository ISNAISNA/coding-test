import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static BufferedWriter out;
    public static ArrayList<Integer>[] graph;

    public static void bfs(int start, boolean[] visit) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            out.write(node + " ");

            for (int i : graph[node]) {
                if (!visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }

    public static void dfs(int start, boolean[] visit) throws IOException {
        out.write(start + " ");
        visit[start] = true;

        for (int i : graph[start]) {
            if (!visit[i]) {
                dfs(i, visit);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        boolean[] visitDfs = new boolean[n + 1];
        boolean[] visitBfs = new boolean[n + 1];

        dfs(start, visitDfs);
        out.write("\n");
        bfs(start, visitBfs);

        out.flush();
        out.close();
        in.close();
    }
}