package homework.second.ex04;

import java.util.*;

public class Ex04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int sum = 0;
        List<int[]> coords = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            boolean xFlag = true, yFlag = true;
            for (int[] c : coords) {
                if (c[0] == x) {
                    if (c[1] <= y + 1 && c[1] >= y - 1) {
                        xFlag = false;
                    }
                }
                if (c[1] == y) {
                    if (c[0] <= x + 1 && c[0] >= x - 1) {
                        yFlag = false;
                    }
                }
            }
            if (xFlag) {
                sum += 2;
            }
            if (yFlag) {
                sum += 2;
            }
            int[] coord = {x, y};
            coords.add(coord);
        }
        System.out.println(sum);
    }
}
