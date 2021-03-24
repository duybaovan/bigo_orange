import java.util.*;

public class l1_q7 {
    static int x;
    static int maxcount;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        HashSet<Integer> p = new HashSet<>();
        for (int i = 0; i < m; i++) {
            p.add(scanner.nextInt()-1);
        }

        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            int u = scanner.nextInt()-1;
            int v = scanner.nextInt()-1;
            graph[u].add(v);
            graph[v].add(u);
        }
        maxcount = Integer.MIN_VALUE;
        dfs(0, n, graph, p);
        int x1 = x;
        maxcount = Integer.MIN_VALUE;
        dfs(x, n, graph, p);
        int x2 = x;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        dist1[x1] = 0;
        dist2[x2] = 0;
        bfs(x1, graph, dist1);
        bfs(x2, graph, dist2);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(dist1[i] <= d && dist2[i] <= d){
                res++;
            }
        }
        System.out.println(res);
    }

    private static void bfs(int x, ArrayList<Integer>[] graph, int[] dist) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        boolean[] visited = new boolean[graph.length];
        while(!q.isEmpty()) {
            int top = q.poll();
            visited[top] = true;
            int curr_dist = dist[top];
            for (int v : graph[top]) {
                if (!visited[v]) {
                    q.add(v);
                    dist[v] = curr_dist + 1;
                }
            }
        }
    }

    private static void dfs(int node, int n, ArrayList<Integer>[] graph, HashSet<Integer> p) {
        boolean[] visited = new boolean[n];
        int count = 0;
        Arrays.fill(visited, false);
        dfs_util(node, count+1, visited, graph, p);
    }

    private static void dfs_util(int node, int count, boolean[] visited, ArrayList<Integer>[] graph, HashSet<Integer> p) {
        visited[node] = true;
        count++;
        for(int neighbor: graph[node]){
            if(!visited[neighbor]){
                if(count >= maxcount && p.contains(neighbor)){
                    maxcount = count;
                    x = neighbor;
                }
                dfs_util(neighbor, count, visited, graph, p);
            }
        }
    }

}
