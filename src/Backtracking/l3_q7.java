package Backtracking;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class l3_q7 {
    static Fraction min = new Fraction(10000000, 1);

    static class Fraction{
        long numerator;
        long denominator;
        public Fraction(long numer, long denom){
            this.numerator = numer;
            this.denominator = denom;
        }

        public double compareTo(Fraction other){
            return (this.numerator * other.denominator - other.numerator * this.denominator);
        }

        public Fraction subtract(Fraction other){
            long numerator_new = this.numerator*other.denominator - other.numerator*this.denominator;
            long denominator_new = this.denominator * other.denominator;
            return new Fraction(numerator_new, denominator_new);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] res_arr = new int[4];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(j == i) continue;
                for (int k = 0; k < 5; k++) {
                    if(k == i || k == j) continue;
                    for (int l = 0; l < 5; l++) {
                        if(l == k || l == j || l == i) continue;
                        Fraction a = new Fraction(arr[i], arr[j]);
                        Fraction b = new Fraction(arr[k], arr[l]);
                        Fraction diff = a.subtract(b);
                        diff = new Fraction(Math.abs(diff.numerator), Math.abs(diff.denominator));
//                        System.out.println(diff.numerator + "/" + diff.denominator);

                        if(diff.compareTo(min) < 0){
                            min = diff;
                            res_arr = new int[]{i,j,k,l};
                        }
                    }
                }
            }
        }
        for(int r: res_arr){
            System.out.print(r + " ");
        }
        System.out.println();
    }

}
