import java.util.Scanner;

public class l2_q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] prefs = new int[N];
            for (int i = 0; i < N; i++) {
                prefs[i] = binToDec(scanner.next());
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < (1 << K); i++) {
                int num_dish = 0;
                boolean allFriendsHappy = true;
                for (int pref : prefs) {
                    if((pref&i) == 0){
                        allFriendsHappy =false;
                    }
                }
                if (allFriendsHappy) {
                    min = Math.min(min, countSetBit(i));
                }
            }
            System.out.println(min);
        }
    }

    private static int binToDec(String binary_number) {
        int num = 0;
        int N = binary_number.length();
        for (int i = 0; i < N; i++) {
            int multiplier = N - i - 1;
            if(binary_number.charAt(i) == '1'){
                num += 1 << multiplier;
            }
        }
        return num;
    }

    private static int countSetBit(int i) {
        int count = 0;
        while(i > 0){
            if((i&1) == 1) count++;
            i = i >> 1;
        }
        return count;
    }

    private static int getBit(int num, int k) {
        return (num >> k) & 1;
    }
}
