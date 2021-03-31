package Diving_and_Conquer;

import java.util.ArrayList;
import java.util.Scanner;

public class l4_q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int x = dnc(arr, 0, n-1, 0);
        System.out.println(x);
    }

    private static int dnc(int[] arr, int l, int r, int prev_min) {
        int ans = 0;
        int N = r-l+1;
        if(l > r) return 0;
        ArrayList<Integer> ind = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            min = Math.min(min, arr[i]);
        }
        for (int i = l; i <= r; i++) {
            if(arr[i] == min) ind.add(i);
        }
        int sum = 0;
        sum += dnc(arr, l, ind.get(0)-1, min);
        for (int i = 0; i < ind.size() - 1; i++) {
            sum += dnc(arr, ind.get(i)+1, ind.get(i + 1)-1, min);
        }
        sum += dnc(arr, ind.get(ind.size()-1)+1, r, min);
        ans = (min - prev_min) + sum ;
        return Math.min(N, ans);
    }
}
