import java.util.*;

public class l1_q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] start = new int[2];
        start[0] = scanner.nextInt();
        start[1] = scanner.nextInt();
        int[] end = new int[2];
        end[0] = scanner.nextInt();
        end[1] = scanner.nextInt();
        int N = scanner.nextInt();
        HashMap<Integer, HashSet<Integer>> allowed = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int row = scanner.nextInt();
            if(!allowed.containsKey(row))
                allowed.put(row, new HashSet<>());
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            for (int j = a; j <= b; j++) {
                allowed.get(row).add(j);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        Queue<Integer> distq = new LinkedList<>();
        q.add(start);
        distq.add(0);
        int[][] dir = {{1,1},{-1,-1},{1,-1},{-1,1},{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] top = q.poll();
            int dist = distq.poll();
            if(top[0] == end[0] && top[1] == end[1]) {
                System.out.println(dist);
                return;
            }
            for(int[] d: dir){
                int x = top[0] + d[0];
                int y = top[1] + d[1];
                if(x < 0 || x > 1000000000 || y < 0 || y > 1000000000) continue;
                int[] candidate = {x,y};
                if(allowed.containsKey(x)){
                    if(allowed.get(x).contains(y)){
                        allowed.get(x).remove(y);
                        q.add(candidate);
                        distq.add(dist+1);
                    }
                }
            }
        }
        System.out.println(-1);
        return;

//        for (int num: allowed.keySet()) {
//            System.out.print(num + " ");
//            for(int k: allowed.get(num)){
//                System.out.print(k + " ");
//            }
//            System.out.println();
//        }
    }
}
