import java.util.*;

class Solution {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    
    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        
        queue.add(new int[]{0,0,1});
        visit[0][0]=true;
        
        while(!queue.isEmpty()){
            int[] infos = queue.poll();
            int x = infos[0];
            int y = infos[1];
            int count = infos[2];
            
            if(x==n-1&&y==m-1)
                return count;
            
            
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(nx<0||ny<0||nx>=n||ny>=m)
                    continue;
                
                if(!visit[nx][ny] && maps[nx][ny]==1){
                    visit[nx][ny]= true;
                    queue.add(new int[]{nx, ny, count+1});
                }
            }
        }
        
        return -1;
    }
}