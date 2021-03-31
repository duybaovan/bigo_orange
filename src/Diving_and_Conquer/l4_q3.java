package Diving_and_Conquer;

import java.util.Scanner;

public class l4_q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int x = getMinCapacity(arr, 0, sum(arr), m);
            System.out.println(x);
        }
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for(int num: arr) sum+=num;
        return sum;
    }

    private static int getMinCapacity(int[] arr, int l, int r, int m) {
        int mid = l + (r-l)/2;
        if(l > r) return Integer.MAX_VALUE;
        if(checkFill(arr, mid, m)){
            return Math.min(mid, getMinCapacity(arr, l, mid-1, m));
        }
        else{
            return getMinCapacity(arr, mid+1, r, m);
        }
    }

    private static boolean checkFill(int[] arr, int maxCapacity, int m) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(arr[i] > maxCapacity) return false;
            if(sum > maxCapacity){
                count++;
                sum = arr[i];
            }
        }
        if(sum > 0) count++;
        return count <= m;
    }
}
