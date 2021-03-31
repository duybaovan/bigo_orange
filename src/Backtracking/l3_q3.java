package Backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class l3_q3 {
    static HashSet<Long> res;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            char[][] matrix = new char[N][N];
            for (int i = 0; i < N; i++) {
                String row = scanner.next();
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = row.charAt(j);
                }
            }
            res = new HashSet<>();
            long visited = 0;
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[0].length; c++) {
                    backtrack(matrix, 0, r, c, visited);
                }
            }
            System.out.println(res.size());
        }
    }

    private static void backtrack(char[][] matrix, int i, int x, int y, long visited) {
        if(i == 8){
            res.add(visited);
            return;
        }
        int[][] d = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] == 'X'){
            for (int j = 0; j < 4; j++) {
                int x2 = x + d[j][0];
                int y2 = y + d[j][1];
                matrix[x][y] = '.';
                visited = setBit(x*matrix[0].length+y, visited, 1);
                backtrack(matrix, i+1, x2, y2, visited);
                matrix[x][y] = 'X';
                visited = setBit(x*matrix[0].length+y, visited, 0);
            }
        }
    }

    private static long setBit(int k, long visited, int isSet) {
        long mask = 1;
        mask <<= k;
        visited = visited | mask;
        if(isSet == 0){
            visited ^= mask;
        }
        return visited;
    }
}
