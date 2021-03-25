package Bit_Manipulation;

import java.util.*;

public class l2_q7 {

    static boolean cycle = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        ArrayList<Integer> specialties = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            specialties.add(scanner.nextInt()-1);
        }
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            for (int j = 0; j < t; j++) {
                int v = scanner.nextInt()-1;
                graph[i].add(v);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        boolean[] instack = new boolean[n];
        for (int i = 0; i < k; i++) {
            int v = specialties.get(i);
            if(!visited[v]) {
                dfs(v, visited, instack, graph, res);
            }
        }
        if(!cycle) {
            System.out.println(res.size());
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i) + " ");
            }
        }
        else
            System.out.println(-1);
    }


    private static void dfs(Integer node, boolean[] visited, boolean[] instack, ArrayList<Integer>[] graph, ArrayList<Integer> res) {
        visited[node] = true;
        instack[node] = true;
        for(int neighbor: graph[node]){
            if(instack[neighbor] && visited[neighbor]){
                cycle = true;
            }
            if(!visited[neighbor]){
                dfs(neighbor, visited, instack, graph, res);
            }
        }
        instack[node] = false;
        res.add(node+1);
    }
}
