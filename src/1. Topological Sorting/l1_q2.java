import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class l1_q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int K = scanner.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[V];
        for(int i = 0; i < V; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < K; i++) {
            int W = scanner.nextInt();
            for (int j = 0; j < W; j++) {
                graph[i].add(scanner.nextInt()-1);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        topSort(graph, res);

        int[] ret = new int[V];
        ret[res.get(0)] = -1;
        for (int i = 1; i < ret.length; i++) {
            ret[res.get(i)] = res.get(i-1);
        }
        for (int r: ret) {
            System.out.println(r+1);
        }

    }

    private static void topSort(ArrayList<Integer>[] graph, ArrayList<Integer> result){
        int V = graph.length;
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                dfs(i, graph, visited, result);
            }
        }
        Collections.reverse(result);
    }

    private static void dfs(int i, ArrayList<Integer>[] graph, boolean[] visited, ArrayList<Integer> result) {
        visited[i] = true;
        for (int j = 0; j < graph[i].size(); j++) {
            int neighbor = graph[i].get(j);
            if(!visited[neighbor]){
                dfs(neighbor, graph, visited, result);
            }
        }
        result.add(i);
    }
}
