import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;


public class Main2 {
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
            String a = in.next();
            String b = in.next();
            StringBuilder sb1 = new StringBuilder(a);
            StringBuilder sb2 = new StringBuilder(b);
            int l1 = 0;
            int r1 = sb1.length()-1;
            int l2 = 0;
            int r2 = sb2.length()-1;
            int count = 0;
            while(l1 < r1 && l2 < r2 && sb1.length() != 0 && sb2.length() != 0){
                if(sb1.charAt(l1) != sb2.charAt(l2)){
                    if(sb1.length() > sb2.length()){
                        sb1.deleteCharAt(l1++);
                    }
                    else{
                        sb2.deleteCharAt(l2++);
                    }
                }
                else if(sb1.charAt(r1) != sb2.charAt(r2)){
                    if(sb1.length() > sb2.length()){
                        sb1.deleteCharAt(r1--);
                    }
                    else{
                        sb2.deleteCharAt(r2--);
                    }
                }
                if(sb1.charAt(l1) == sb2.charAt(l2) && sb1.charAt(r1) != sb2.charAt(r2)){
                    System.out.println("yeet");
                    return;
                }
                count++;
            }
            System.out.println(count);

        }
    }

    static boolean isSubstring(String s1, String s2)
    {
       return s1.toLowerCase().contains(s2.toLowerCase());
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