package homework.first.ex05;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long profit = scanner.nextLong();
        long people = scanner.nextLong();
        long days = scanner.nextLong();
        int match = 0;
        for (int i = 0; i < days; ++i) {
            if (i == 0) {
                for (int j = 0; j < 10; ++j) {
                    if (j == 0) {
                        profit *= 10;
                    } else {
                        profit += 1;
                    }
                    if (profit % people == 0) {
                        match = 1;
                        System.out.print(profit);
                        break;
                    }
                }
            } else {
                if (match == 0) {
                    System.out.print(-1);
                    break;
                } else {
                    System.out.print('0');
                }
            }
        }
        scanner.close();
    }
}
