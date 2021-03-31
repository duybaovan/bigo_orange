package Backtracking;

import java.util.*;

public class l3_q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            char[][] matrix1 = new char[4][4];
            char[][] matrix2 = new char[4][4];
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    String s = scanner.next();
                    if(s.charAt(0) == '#') return;
                    matrix1[r][c] = s.charAt(0);
                }
                for (int c = 0; c < 4; c++) {
                    matrix2[r][c] = scanner.next().charAt(0);
                }
            }
            TreeSet<String> res1 = new TreeSet<>();
            TreeSet<String> res2 = new TreeSet<>();

            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    backtrack(matrix1, "", res1, 0, r, c);
                    backtrack(matrix2, "", res2, 0, r, c);
                }
            }

            res1.retainAll(res2);
            if(res1.isEmpty()){
                System.out.println("There are no common words for this pair of boggle boards.");
            }
            else{
                for(String s: res1){
                    System.out.println(s);
                }
            }
            System.out.println();
        }
    }

    private static void backtrack(char[][] matrix, String s, TreeSet<String> res, int num_vowels, int r, int c) {
        if(s.length() >= 4){
            if(num_vowels == 2)
                res.add(s);
            return;
        }
//        System.out.println(s);
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
        if(r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] != '.'){
            for (int d = 0; d < 8; d++) {
                int new_r = r + dir[d][0];
                int new_c = c + dir[d][1];
                String new_s = s+matrix[r][c];
                char temp = matrix[r][c];
                matrix[r][c] = '.';
                backtrack(matrix, new_s, res, num_vowels + isVowel(temp), new_r, new_c);
                matrix[r][c] = temp;
            }
        }
    }

    private static int isVowel(char c) {
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'Y')? 1: 0;
    }

    private void printMatrix(char[][] matrix){
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
