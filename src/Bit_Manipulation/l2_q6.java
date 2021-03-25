package Bit_Manipulation;

import java.util.Scanner;

public class l2_q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int NUM_BITS = 32;
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            if(N == 1){
                int num = scanner.nextInt();
                System.out.println(isPowerOfTwo(num)?"YES":"NO");
                continue;
            }
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            int all_ones = 0;
            all_ones = ~all_ones;
            boolean res = false;
            for (int i = 0; i < NUM_BITS; i++) {
                int candidate = all_ones;
                for (int j = 0; j < N; j++) {
                    if(bitIsSet(arr[j], i)){
                        candidate &= arr[j];
                    }
                }
                if(isPowerOfTwo(candidate)){
                    res = true;
                    break;
                }
            }
            System.out.println(res? "YES": "NO");

        }
    }

    private static boolean bitIsSet(int m, int k) {
        return ((m >> (k-1)) & 1) == 1;
    }


    private static boolean isPowerOfTwo(int num) {
        boolean isPowerOfTwo = (num & (num-1)) == 0;
        boolean notZero = num > 0;
        return isPowerOfTwo && notZero;
    }
}
