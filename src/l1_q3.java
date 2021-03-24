import java.util.*;

public class l1_q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            names.add(scanner.next());
        }
        ArrayList<Integer>[] graph = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            for (int j = i; j < V; j++) {
                String s1 = names.get(i);
                String s2 = names.get(j);
                boolean foundDifference = false;
                for (int k = 0; k < s1.length() && k < s2.length(); k++) {
                    if (s1.charAt(k) != s2.charAt(k)) {
                        graph[s1.charAt(k) - 'a'].add(s2.charAt(k) - 'a');
//                        System.out.println(s1.charAt(k) + " " + s2.charAt(k));
                        foundDifference = true;
                        break;
                    }
                }
                if(!foundDifference && s1.length() > s2.length()) {
                    System.out.println("Impossible");
                    return;
                }
            }
        }
        int[] indegree = new int[26];
        for (int u = 0; u < 26; u++) {
            for(int v: graph[u]){
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
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

        for(int i = 0; i < 26; i++){
            if(indegree[i] > 0){
                System.out.println("Impossible");
                return;
            }
        }

        for (int i = 0; i < result.size(); i++) {
            char ch = (char) (result.get(i) + 'a');
            System.out.print(ch);
        }
    }
}
