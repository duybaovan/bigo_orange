import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }

    private static void solve(InputReader in, PrintWriter out) {
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            boolean done = false;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            HashSet<Integer> pos_diff = new HashSet<>();
            HashSet<Integer> neg_diff = new HashSet<>();
            for (int i = 1; i < n; i++) {
                int diff = Math.abs(arr[i] - arr[i-1]);
                if(arr[i] > arr[i-1]) pos_diff.add(diff);
                else neg_diff.add(diff);
            }
            if(pos_diff.size() > 1 || neg_diff.size() > 1){
                System.out.println(-1);
                done = true;
            }
            else if(pos_diff.size() == 0 || neg_diff.size() == 0){
                System.out.println(0);
                done = true;
            }
            if(!done) {
                int c = (int) (pos_diff.toArray())[0];
                int m = ((int) (neg_diff.toArray())[0]) + c;

                for (int i = 0; i < n; i++) {
                    if (arr[i] > m) {
                        System.out.println(-1);
                        done = true;
                        break;
                    }
                }
                if(!done){
                    System.out.println(m + " " + c);
                }
            }
        }

    }


    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}