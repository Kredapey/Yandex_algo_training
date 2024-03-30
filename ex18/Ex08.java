package homework.second.ex08;

import java.util.*;

public class Ex08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] matrix = new int[r][c];
        int maxVal = 0;
        int maxValRow = 0;
        int maxValCol = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                int val = scanner.nextInt();
                if (val > maxVal) {
                    maxVal = val;
                    maxValRow = i;
                    maxValCol = j;
                }
                matrix[i][j] = val;
            }
        }
        int row;
        int column;
        int maxWr;
        int colWr;
        TreeMap<Integer, int[]> valWr = getMaxVal(matrix, maxValRow, -7);
        maxWr = valWr.firstEntry().getKey();
        colWr = valWr.get(maxWr)[1];
        valWr = getMaxVal(matrix, maxValRow, colWr);
        maxWr = valWr.firstEntry().getKey();

        int maxWc;
        int rowWc;
        TreeMap<Integer, int[]> valWc = getMaxVal(matrix, -7, maxValCol);
        maxWc = valWc.firstEntry().getKey();
        rowWc = valWc.get(maxWc)[0];
        valWc = getMaxVal(matrix, rowWc, maxValCol);
        maxWc = valWc.firstEntry().getKey();

        if (maxWr < maxWc) {
            row = maxValRow;
            column = colWr;
        } else {
            row = rowWc;
            column = maxValCol;
        }
        System.out.println((row + 1) + " " + (column + 1));
    }

    public static TreeMap<Integer, int[]> getMaxVal(int[][] matrix, int rowDelete, int colDelete) {
        TreeMap<Integer, int[]> result = new TreeMap<>();
        int[] coords = new int[2];
        int maxCoord = 0;
        for (int i = 0; i < matrix.length; ++i) {
            if (i == rowDelete) continue;
            for (int j = 0; j < matrix[i].length; ++j) {
                if (j == colDelete) continue;
                if (matrix[i][j] > maxCoord) {
                    maxCoord = matrix[i][j];
                    coords[0] = i;
                    coords[1] = j;
                }
            }
        }
        result.put(maxCoord, coords);
        return result;
    }
}
