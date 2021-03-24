import java.util.*;

public class l1_q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int t = 1;
        while(t <= T){
            int V = scanner.nextInt();
            int E = scanner.nextInt();
            ArrayList<Integer>[] graph = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                graph[i] = new ArrayList<>();
            }
            int[] indegree = new int[V];
            for (int i = 0; i < E; i++) {
                int v = scanner.nextInt();
                int u = scanner.nextInt();
                graph[u].add(v);
                indegree[v]++;
            }
            Queue<Integer> q = new LinkedList<>();
            Queue<Integer> level = new LinkedList<>();

            for (int i = 0; i < V; i++) {
                if(indegree[i] == 0){
                    q.add(i);
                    level.add(1);
                }
            }
            ArrayList<int[]> res = new ArrayList<>();
            while(!q.isEmpty()){
                int top = q.poll();
                int curr_level = level.poll();
                res.add(new int[]{curr_level, top});
                for(int v: graph[top]){
                    indegree[v]--;
                    if(indegree[v] == 0){
                        q.add(v);
                        level.add(curr_level+1);
                    }
                }
            }
            Collections.sort(res, (a,b) -> a[0] != b[0]? a[0] - b[0]: a[1] - b[1]);
            System.out.println("Scenario #" + t + ":");
            for(int[] i: res){
                System.out.println(i[0] + " " + i[1]);
            }
            t++;
        }
    }
}
