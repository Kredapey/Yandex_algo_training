package homework.first.ex06;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        long current, result = 0;
        StringBuilder strRes = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            current = scanner.nextLong();
            if (i == 0) {
                result = current;
            } else {
                if (result % 2 == 0) {
                    result += current;
                    strRes.append('+');
                } else {
                    if (current % 2 == 0) {
                        result += current;
                        strRes.append('+');
                    } else {
                        result *= current;
                        strRes.append('x');
                    }
                }
            }
        }
        System.out.println(strRes);
    }
}
