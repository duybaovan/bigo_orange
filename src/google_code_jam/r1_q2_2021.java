package google_code_jam;
import java.util.Scanner;

public class r1_q2_2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int X = scanner.nextInt(); // CJ
            int Y = scanner.nextInt(); // JC
            String s = scanner.next();
            char[] arr = s.toCharArray();
            int l = -1;
            int r = -1;
            int initial_cost = 0;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] == 'C' && arr[i+1] == 'J') initial_cost += X;
                else if(arr[i] == 'J' && arr[i+1] == 'C') initial_cost += Y;
            }
            int cost = 0;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] == '?'){
                    r = i;
                    while(r < arr.length && arr[r] == '?') {
                        r++;
                    }
                    if(r == arr.length){
                        break;
                    }
                    if(l == -1 || arr[l] == arr[r]){
                        i = r;
                    }
                    else{
                        cost += (arr[l] == 'C' && arr[r] == 'J')? X: Y;
                    }
                }
                else{
                    l=i;
                }
            }
            System.out.println("Case #" + (t+1) + ": " + (initial_cost + cost));
        }
    }

}
