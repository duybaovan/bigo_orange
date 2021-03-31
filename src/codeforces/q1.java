package codeforces;

import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t <T ; t++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n ; i++) {
                arr[i] = scanner.nextInt();
            }
            int sum = 0;
            for (int i = 1; i < n; i++) {
                double x1 = arr[i];
                double x2 = arr[i-1];
                double ratio = x1 > x2? x1/x2: x2/x1;

                int count = 0;
                while(ratio > 2){
                    ratio /= 2;
                    count++;
                }
                sum+=count;
            }
            System.out.println(sum);
        }
    }
}
