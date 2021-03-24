import java.util.*;

public class l1_q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int E = scanner.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[V];
        for(int i = 0; i < V; i++){
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[V];
        for(int i = 0; i < E; i++){
            int x = scanner.nextInt()-1;
            int y = scanner.nextInt()-1;
            indegree[y]++;
            graph[x].add(y);
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < V; i++) {
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int top = q.poll();
            result.add(top);
            ArrayList<Integer> neighbors = graph[top];
            for(int neighbor: neighbors){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        for(int i = 0; i < V; i++){
            if(indegree[i] > 0){
                System.out.println("Sandro fails.");
                return;
            }
        }

        for(int v: result){
            System.out.print(v+1 + " ");
        }



    }
}
