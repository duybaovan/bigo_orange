import java.util.*;

public class l2_q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[n];
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            time[i] = t;
            int d = scanner.nextInt();
            for (int j = 0; j < d; j++) {
                int v = scanner.nextInt()-1;
                graph[i].add(v);
                indegree[v]++;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x1,x2) -> time[x1] - time[x2]);
        for (int i = 0; i < n; i++) {
            if(indegree[i] == 0) pq.add(i);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            int top = pq.poll();
            res.add(top);
            for(int v: graph[top]){
                indegree[v]--;
                if(indegree[v] == 0){
                    pq.add(v);
                }
            }
        }
        Collections.reverse(res);
        int max_time = 0;
        for (int i = n-1; i >= 0; i--) {
            max_time = Math.max(max_time, time[res.get(i)]+i);
        }
        System.out.println(max_time);
    }
}
