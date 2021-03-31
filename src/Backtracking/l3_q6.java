package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class l3_q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while(num != 0) {
            ArrayList<Integer> ind = getSetBits(num);
            int a = 0;
            for (int i = 0; i < ind.size(); i = i + 2) {
                a |= (1 << (31-ind.get(i)));
            }
            int b = 0;
            for (int i = 1; i < ind.size(); i = i + 2) {
                b |= (1 << (31-ind.get(i)));
            }
            System.out.println(a + " " + b);
            num = scanner.nextInt();
        }
    }

    private static ArrayList<Integer> getSetBits(int num) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 31; i >= 0; i--) {
            if((num&1) == 1){
                res.add(i);
            }
            num >>= 1;
            if(num == 0) break;
        }
        return res;
    }
}
