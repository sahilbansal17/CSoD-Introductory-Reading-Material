// https://codeforces.com/problemset/problem/998/B
package week1.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cutting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int b = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i ++) {
            a[i] = scanner.nextInt();
        }

        int[] oddCount = new int[n];
        int[] evenCount = new int[n];
        if (a[0] % 2 == 0) {
            evenCount[0] = 1;
        }
        else {
            oddCount[0] = 1;
        }

        for (int i = 1; i < n; i ++) {
            if (a[i] % 2 == 0) {
                evenCount[i] = evenCount[i - 1] + 1;
                oddCount[i] = oddCount[i - 1];
            }
            else {
                oddCount[i] = oddCount[i - 1] + 1;
                evenCount[i] = evenCount[i - 1];
            }
        }

        ArrayList <Integer> costs = new ArrayList<>();
        for (int i = 0; i < n - 1; i ++) {
            if (evenCount[i] == oddCount[i]) {
                costs.add(Math.abs(a[i] - a[i + 1]));
            }
        }
        Collections.sort(costs);
        int used = 0, maxCuts = 0;
        for (int cost: costs) {
            if (used + cost <= b) {
                used += cost;
                maxCuts ++;
            }
            else {
                break;
            }
        }
        System.out.println(maxCuts);
    }
}
