package codeforces;

import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int c0 = 0;
            int c1 = 0;
            int c2 = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] % 3 == 0) c0++;
                else if(arr[i] % 3 == 1) c1++;
                else if(arr[i] % 3 == 2) c2++;
            }
            int avg = n/3;
            int num_moves = 0;

            while(c0 < avg){
                if(c2 > avg){
                    num_moves++;
                    c0++;
                    c2--;
                }
                else if(c1 > avg){
                    num_moves += 2;
                    c0++;
                    c1--;
                }
            }
            while(c1 < avg){
                if(c0 > avg){
                    num_moves++;
                    c0--;
                    c1++;
                }
                else if(c2 > avg){
                    num_moves += 2;
                    c2--;
                    c1++;
                }

            }

            while(c2 < avg){
                if(c1 > avg){
                    num_moves++;
                    c1--;
                    c2++;
                }
                else if(c0 > avg){
                    num_moves += 2;
                    c0--;
                    c2++;
                }

            }
            System.out.println(num_moves);
        }
    }
}
