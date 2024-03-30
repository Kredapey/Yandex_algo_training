package homework.second.ex03;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < count; ++i) {
            int len = scanner.nextInt();
            max = Math.max(len, max);
            sum += len;
        }
        if (max - (sum - max) <= 0) {
            System.out.println(sum);
        } else {
            System.out.println(max - (sum - max));
        }
    }
}
