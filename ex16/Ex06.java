package homework.second.ex06;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countSectors = scanner.nextInt();
        int[] sectors = new int[countSectors];
        for (int i = 0; i < countSectors; ++i) {
            sectors[i] = scanner.nextInt();
        }
        int startSpeed = scanner.nextInt();
        int finalSpeed = scanner.nextInt();
        int slow = scanner.nextInt();
        int maxPrice = -1;
        int min = startSpeed / slow;
        if (startSpeed % slow == 0) {
            min -= 1;
        }
        int max = finalSpeed / slow;
        if (finalSpeed % slow == 0) {
            max -= 1;
        }
        if (max - min >= countSectors - 1) max = min + countSectors - 1;
        for (int i = min; i <= max; ++i)  {
            maxPrice = Math.max(maxPrice, sectors[i % countSectors]);
            if (i % countSectors != 0) {
                maxPrice = Math.max(maxPrice, sectors[countSectors - (i % countSectors)]);
            }
        }
        System.out.println(maxPrice);
    }
}
