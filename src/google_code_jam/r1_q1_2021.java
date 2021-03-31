package google_code_jam;

import java.util.Scanner;

public class r1_q1_2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int sum = 0;
            int idx = -1;
            for (int i = 0; i < n-1; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = i; j < n; j++) {
                    if(arr[j] < min){
                        min = arr[j];
                        idx = j;
                    }
                }
                sum += idx - i + 1;
                rev(arr, i, idx);
            }
            System.out.println("Case #" + (t+1) + ": " + sum);
        }
    }

    private static void rev(int[] arr, int i, int idx) {
        while(i < idx){
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
            i++;
            idx--;
        }
    }
}
