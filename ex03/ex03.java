package homework.first.ex03;

import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long result = 0;
        int lineCount = scanner.nextInt();
        for (int i = 0; i < lineCount; ++i) {
            int tmp = scanner.nextInt();
            if (tmp % 4 == 0) {
                result += tmp / 4;
            } else if (tmp % 4 == 1) {
                result += tmp / 4 + 1;
            } else if (tmp % 4 == 2 || tmp % 4 == 3) {
                result += tmp / 4 + 2;
            }
            System.out.println(result);
            scanner.close();
        }
    }
}
