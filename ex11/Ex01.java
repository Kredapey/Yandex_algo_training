package homework.second.ex01;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int minX = 0, minY = 0, maxX = 0, maxY = 0;
        for (int i = 0; i < count; ++i) {
            int curX = scanner.nextInt();
            int curY = scanner.nextInt();
            if (i == 0) {
                minX = curX;
                maxX = curX;
                minY = curY;
                maxY = curY;
            }
            minX = Math.min(curX, minX);
            maxX = Math.max(curX, maxX);
            minY = Math.min(curY, minY);
            maxY = Math.max(curY, maxY);
        }
        System.out.println(minX + " " + minY + " " + maxX + " " + maxY);
    }
}
