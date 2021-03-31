package Backtracking;

import java.util.HashSet;
import java.util.Scanner;

public class l3_q5 {
    static int og_num_plus = 0;
    static int og_num_sub = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '+') og_num_plus++;
            else if(s.charAt(i) == '-') og_num_sub++;
        }
        String s_unknown = scanner.next();
        HashSet<String> set = new HashSet<>();
        HashSet<String> correct = new HashSet<>();
        backtrack(s_unknown.toCharArray(), 0, 0, 0, set, correct);
        double ans = ((double) (correct.size())) / ((double) set.size());
        System.out.println(ans);
    }

    private static void backtrack(char[] s, int i, int num_sub, int num_plus, HashSet<String> set, HashSet<String> correct) {
        if(i == s.length){
            String res = String.valueOf(s);
            set.add(res);
            if(num_plus == og_num_plus && num_sub == og_num_sub){
                correct.add(res);
            }
            return;
        }
        if(s[i] == '?'){
            s[i] = '+';
            backtrack(s, i+1, num_sub, num_plus+1, set, correct);;
            s[i] = '-';
            backtrack(s, i+1, num_sub+1, num_plus, set, correct);
            s[i] = '?';
        }
        else{
            if(s[i] == '+')
                backtrack(s, i+1, num_sub, num_plus+1, set, correct);
            if(s[i] == '-')
                backtrack(s, i+1, num_sub+1, num_plus, set, correct);
        }

    }
}
