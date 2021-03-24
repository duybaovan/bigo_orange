import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class l2_q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            long n = scanner.nextLong();
            long m = scanner.nextLong();

            List<Integer> res = new ArrayList<>();
            for (int k = 54; k >= 0; k--) {
                if(bitIsSet(m, k)){
                    res.add(k);
                }
            }
            for (int j = 0; j < res.size(); j++) {
                if(j == res.size()-1){
                    System.out.print("(" + n + "<<" + res.get(j) + ")");
                    continue;
                }
                System.out.print("(" + n + "<<" + res.get(j) + ")" + " + ");
            }
            System.out.println();
        }
    }

    private static boolean bitIsSet(long m, int k) {
        return ((m >> k) & 1) == 1;
    }
}
