//package homework.second.ex05;
//
//import java.io.*;
//import java.util.*;
//
//public class Ex05 {
//    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        int count = scanner.nextInt();
//        int[] up = new int[count];
//        int[] down = new int[count];
//        long maxUp = 0;
//        long maxMin = 0, index = 0;
//        long minDiff = 0;
//        long height = 0;
//        long maxHeight = 0;
//        int maxMinInd = 0;
//        int counter = 0;
//        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
//        PrintStream out = new PrintStream(new File("output.txt"));
//        List<Integer> plus = new ArrayList<>();
//        List<Integer> min = new ArrayList<>();
//        String line;
//        int c = 0;
//        while ((line = reader.readLine()) != null) {
//            String[] nums = line.split(" ");
//            up[c] = Integer.parseInt(nums[0]);
//            down[c] = Integer.parseInt(nums[1]);
//            if (up[c] - down[c] >= 0) {
//                plus.add(c);
//                if (counter == 0) {
//                    minDiff = up[c] - down[c];
//                }
//                if (minDiff - (up[c] - down[c]) > up[maxMinInd] - up[c] || counter == 0) {
//                    minDiff = up[c] - down[c];
//                    maxUp = up[c];
//                    maxMinInd = c;
//                }
//                counter++;
//            } else {
//                min.add(c);
//                if (up[c] > maxMin) {
//                    maxMin = up[c];
//                    index = c;
//                }
//            }
//            c++;
//        }
////        for (int i = 0; i < count; ++i) {
////            up[i] = scanner.nextInt();
////            down[i] = scanner.nextInt();
////        if (up[i] - down[i] >= 0) {
////            plus.add(i);
////            if (counter == 0) {
////                minDiff = up[i] - down[i];
////            }
////            if (minDiff - (up[i] - down[i]) > up[maxMinInd] - up[i] || counter == 0) {
////                minDiff = up[i] - down[i];
////                maxUp = up[i];
////                maxMinInd = i;
////            }
////            counter++;
////        } else {
////            min.add(i);
////            if (up[i] > maxMin) {
////                maxMin = up[i];
////                index = i;
////            }
////            }
////            System.out.println(i + 1 + " " + up[i] + " " + down[i]);
////        }
//        StringBuilder resultOrder = new StringBuilder();
//        for (Integer i : plus) {
//            if (i != maxMinInd) {
//                maxHeight = Math.max(height + up[i], maxHeight);
//                height += (up[i] - down[i]);
//                resultOrder.append(i + 1);
//                resultOrder.append(" ");
//            }
//        }
//        if (plus.isEmpty()) {
//            maxHeight = maxMin;
//        }
//        long compare;
//        if (height + maxUp > height + (maxUp - down[maxMinInd]) + maxMin) {
//            compare = height + maxUp;
//            resultOrder.append(maxMinInd + 1);
//            resultOrder.append(" ");
//            index = -1;
//        } else {
//            compare = height + (maxUp - down[maxMinInd]) + maxMin;
//            if (!plus.isEmpty()) {
//                resultOrder.append(maxMinInd + 1);
//                resultOrder.append(" ");
//            }
//            resultOrder.append(index + 1);
//            resultOrder.append(" ");
//        }
//        for (Integer i : min) {
//            if (i != index) {
//                resultOrder.append(i + 1);
//                resultOrder.append(" ");
//            }
//        }
//        maxHeight = Math.max(maxHeight, compare);
//        out.println(maxHeight);
//        out.println(resultOrder);
//    }
//}

package homework.second.ex05;

import java.util.*;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] up = new int[count];
        int[] down = new int[count];
        long maxUp = 0;
        long maxMin = 0, index = 0;
        long minDiff = 0;
        long height = 0;
        long maxHeight = 0;
        int maxMinInd = 0;
        int counter = 0;
        List<Integer> plus = new ArrayList<>();
        List<Integer> min = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            up[i] = scanner.nextInt();
            down[i] = scanner.nextInt();
            if (up[i] - down[i] >= 0) {
                plus.add(i);
                if (counter == 0) {
                    minDiff = up[i] - down[i];
                }
                if (minDiff - (up[i] - down[i]) > up[maxMinInd] - up[i] || counter == 0) {
                    minDiff = up[i] - down[i];
                    maxUp = up[i];
                    maxMinInd = i;
                }
                counter++;
            } else {
                min.add(i);
                if (up[i] > maxMin) {
                    maxMin = up[i];
                    index = i;
                }
            }
        }
        StringBuilder resultOrder = new StringBuilder();
        for (Integer i : plus) {
            if (i != maxMinInd) {
                maxHeight = Math.max(height + up[i], maxHeight);
                height += (up[i] - down[i]);
                resultOrder.append(i + 1);
                resultOrder.append(" ");
            }
        }
        if (plus.isEmpty()) {
            maxHeight = maxMin;
        }
        long compare;
        if (height + maxUp > height + (maxUp - down[maxMinInd]) + maxMin) {
            compare = height + maxUp;
            resultOrder.append(maxMinInd + 1);
            resultOrder.append(" ");
            index = -1;
        } else {
            compare = height + (maxUp - down[maxMinInd]) + maxMin;
            if (!plus.isEmpty()) {
                resultOrder.append(maxMinInd + 1);
                resultOrder.append(" ");
            }
            resultOrder.append(index + 1);
            resultOrder.append(" ");
        }
        for (Integer i : min) {
            if (i != index) {
                resultOrder.append(i + 1);
                resultOrder.append(" ");
            }
        }
        maxHeight = Math.max(maxHeight, compare);
        System.out.println(maxHeight);
        System.out.println(resultOrder);
    }
}

