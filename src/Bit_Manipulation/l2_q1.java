import java.util.Scanner;

public class l2_q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int[] unset = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            unset[i] = nums[i] == 0? 1: 0;
        }
        int[] pre = new int[n+1];
        int[] unset_sum = new int[n+1];
        pre[0] = 0;
        unset_sum[0] = 0;
        for (int i = 1; i < n+1; i++) {
            pre[i] = pre[i-1] ^ nums[i-1];
            unset_sum[i] = unset_sum[i-1] + unset[i-1];
        }

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int xor_val = pre[r] ^ pre[l-1];
            int num_unset = unset_sum[r] - unset_sum[l-1];
            System.out.println(xor_val + " " + num_unset);
        }
    }
}
