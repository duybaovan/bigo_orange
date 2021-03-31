package Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class l3_q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int H = scanner.nextInt();
            backtrack(new ArrayList<>(), 0, N, H);
        }
    }

    private static void backtrack(ArrayList<Integer> ls, int num1s, int n, int h) {
        if(ls.size() == n){
            if(num1s == h){
                for (int i = 0; i < ls.size(); i++) {
                    System.out.print(ls.get(i));
                }
                System.out.println();
            }
            return;
        }
        ls.add(0);
        backtrack(ls, num1s, n, h);
        ls.remove(ls.size()-1);
        ls.add(1);
        backtrack(ls, num1s+1, n, h);
        ls.remove(ls.size()-1);
    }
}
