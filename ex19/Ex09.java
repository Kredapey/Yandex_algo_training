package homework.second.ex09;

import java.util.*;

public class Ex09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] eachColPath = new int[n];
        int rows[] = new int[n];
        for (int i = 0; i < n; ++i) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            rows[i] = row;
            for (int j = 0; j < n; ++j) {
                eachColPath[j] += Math.abs((j + 1) - col);
            }
        }
        long allColPath = eachColPath[0];
        long allRowPath = 0;
        Arrays.sort(rows);
        for (int i = 0; i < n; ++i) {
            allColPath = Math.min(allColPath, eachColPath[i]);
            allRowPath += Math.abs((i + 1) - rows[i]);
        }
        System.out.println((allRowPath + allColPath));
    }
}
