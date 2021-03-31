import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class q3 {
    static int NUM_BITS = 26;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            HashMap<Long, Long> map = new HashMap<>();
            for (long i = 1; i < 10000; i++) {
                map.put(i*i*i, i);
            }
            long num = scanner.nextLong();
            boolean found = false;
            for (long i = 1; i < 10000; i++) {
                long cube = i*i*i;
//                System.out.println(i);
                if(map.containsKey(num-cube)){
                    found = true;
//                    System.out.println(i + " " + map.get(num-cube));
                    break;
                }
            }
            System.out.println(found?"YES":"NO");
        }

    }


    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {}
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }

}
