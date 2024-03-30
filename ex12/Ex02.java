package homework.second.ex02;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = scanner.nextInt();
        int fresh = scanner.nextInt();
        long profit = 0;
        long[] arr = new long[days];
        for (int i = 0; i < days; ++i) {
            arr[i] = scanner.nextLong();
        }
        for (int i = 0; i < days; ++i) {
            for (int j = 0; j <= fresh; ++j) {
                if (i + j >= days) {
                    break;
                }
                profit = Math.max(profit, arr[i + j] - arr[i]);
            }
        }
        System.out.println(profit);
    }
}
