import java.util.*;

public class l1_q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = 1;
        while(scanner.hasNext()) {
            int N = scanner.nextInt();
            HashMap<String, ArrayList<String>> graph = new HashMap<>();
            HashMap<String, Integer> indegree = new HashMap<>();
            HashMap<String, Integer> idxmap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String v = scanner.next();
                graph.put(v, new ArrayList<>());
                indegree.put(v, 0);
                idxmap.put(v, i);
            }
            int E = scanner.nextInt();
            for (int i = 0; i < E; i++) {
                String u = scanner.next();
                String v = scanner.next();
                graph.get(u).add(v);
                indegree.put(v, indegree.get(v) + 1);
            }
            PriorityQueue<String> q = new PriorityQueue<>((s1, s2) -> idxmap.get(s1) - idxmap.get(s2));
            for (String v : graph.keySet()) {
                if (indegree.get(v) == 0) q.add(v);
            }
            ArrayList<String> result = new ArrayList<>();
            while (!q.isEmpty()) {
                String top = q.poll();
                result.add(top);
                for (String v : graph.get(top)) {
                    indegree.put(v, indegree.get(v) - 1);
                    if (indegree.get(v) == 0) {
                        q.add(v);
                    }
                }
            }
            String msg = "Case #" + c + ": Dilbert should drink beverages in this order: ";
            System.out.print(msg);
            for (int i = 0; i < result.size()-1; i++) {
                String s = result.get(i);
                System.out.print(s + " ");
            }
            System.out.print(result.get(result.size()-1)+".\n");
            c++;
        }


    }
}
