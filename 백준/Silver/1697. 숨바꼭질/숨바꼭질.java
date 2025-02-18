import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = numbers[0];
        int k = numbers[1];

        if(n==k){
            System.out.println(0);
            return;
        }

        boolean[] visit = new boolean[100001];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        int count=0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for(int i=0; i<size; i++) {
                int node = queue.remove();
                visit[node] = true;
                if(node-1 == k ||node*2==k || node+1==k){
                    System.out.println(count);
                    return;
                }

                if(node-1>=0&& !visit[node-1]){
                    visit[node-1]=true;
                    queue.add(node-1);
                }

                if(node+1<=100000 && !visit[node+1]){
                    visit[node+1]=true;
                    queue.add(node+1);
                }
                if(node*2<=100000 && !visit[node*2]){
                    visit[node*2]=true;
                    queue.add(node*2);
                }
            }
        }
        System.out.println(count);
    }
}