package homework.second.ex07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int overallCount = scanner.nextInt();
        for (int j = 0; j < overallCount; ++j) {
            int count = scanner.nextInt();
            int[] arr = new int[count];
            int curCount = 0;
            int maxLen = 0;
//        int curNum = 0;
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < count; ++i) {
                arr[i] = scanner.nextInt();
                if (i == 0) maxLen = arr[i];
                maxLen = Math.min(arr[i], maxLen);

                if (curCount >= maxLen) {
                    result.add(curCount);
                    maxLen = arr[i];
                    curCount = 0;
                }
                curCount += 1;
            }
            result.add(curCount);
            System.out.println(result.size());
            for (Integer i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
