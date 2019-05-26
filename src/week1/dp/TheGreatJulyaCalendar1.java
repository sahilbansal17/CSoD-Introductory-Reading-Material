// https://codeforces.com/problemset/problem/331/C1

package week1.dp;

import java.util.Scanner;

import static java.lang.Math.min;

public class TheGreatJulyaCalendar1 {

    private static int[] dp = new int[1000010];

    private static int solve(int n) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int res = Integer.MAX_VALUE;
        int copy = n;
        while (copy > 0) {
            int rem = copy % 10;
            copy /= 10;
            if (rem != 0) {
                res = min(res, 1 + solve(n - rem));
            }
        }
        return dp[n] = res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i <= n; i ++) {
            dp[i] = -1;
        }
        dp[0] = 0;

        System.out.println(solve(n));
    }
}
