package BitManipulation;

import java.util.Scanner;

public class l2_q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            if(n%2 == 0){
                System.out.println(0);
                continue;
            }
            else {
                int res = 0;
                for (int i = 0; i < n; i=i+2) {
                    res ^= arr[i];
                }
                System.out.println(res);
            }
        }

    }
}
