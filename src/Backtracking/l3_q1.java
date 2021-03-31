package Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class l3_q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        while(k!=0){
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = scanner.nextInt();
            }
            ArrayList<Integer> ls = new ArrayList<>();
            ls.add(-1);
            backtrack(arr, ls, 0);

            k = scanner.nextInt();
            System.out.println();
        }
    }

    private static void backtrack(int[] arr, ArrayList<Integer> ind, int i) {
        if(i == 6){
            for(int idx: ind){
                if(idx == -1) continue;
                System.out.print(arr[idx] + " ");
            }
            System.out.println();
            return;
        }

        for (int idx = ind.get(ind.size()-1)+1; idx < arr.length; idx++) {
            ind.add(idx);
            backtrack(arr, ind, i+1);
            ind.remove(ind.size()-1);
        }
    }
}
