package homework.first.ex04;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countStars = 0;
        char[][] matrix = new char[8][8];
        for (int i = 0; i < 8; ++i) {
            String str = scanner.nextLine();
            for (int j = 0; j < 8; ++j) {
                matrix[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (matrix[i][j] == 'B') {
                    changeBishop(i, j, matrix);
                } else if (matrix[i][j] == 'R') {
                    changeRook(i, j, matrix);
                }
            }
        }
        for (char[] charArr : matrix) {
            for (char ch : charArr) {
                if (ch == '*') ++countStars;
            }
        }
        System.out.println(countStars);
    }

    public static void changeRook(int row, int col, char[][] matrix) {
        for (int i = row, j = col + 1; j < 8; ++j) {
            if (matrix[i][j] != 'R' && matrix[i][j] != 'B') {
                matrix[i][j] = '0';
            } else {
                break;
            }
        }
        for (int i = row - 1, j = col; i >= 0; --i) {
            if (matrix[i][j] != 'R' && matrix[i][j] != 'B') {
                matrix[i][j] = '0';
            } else {
                break;
            }
        }
        for (int i = row, j = col - 1; j >= 0; --j) {
            if (matrix[i][j] != 'R' && matrix[i][j] != 'B') {
                matrix[i][j] = '0';
            } else {
                break;
            }
        }
        for (int i = row + 1, j = col; i < 8; ++i) {
            if (matrix[i][j] != 'R' && matrix[i][j] != 'B') {
                matrix[i][j] = '0';
            } else {
                break;
            }
        }
    }

    public static void changeBishop(int row, int col, char[][] matrix) {
        for (int i = row + 1, j = col + 1; i < 8 && j < 8; ++i, ++j) {
            if (matrix[i][j] != 'R' && matrix[i][j] != 'B') {
                matrix[i][j] = '0';
            } else {
                break;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (matrix[i][j] != 'R' && matrix[i][j] != 'B') {
                matrix[i][j] = '0';
            } else {
                break;
            }
        }
        for (int i = row + 1, j = col - 1; i < 8 && j >= 0; ++i, --j) {
            if (matrix[i][j] != 'R' && matrix[i][j] != 'B') {
                matrix[i][j] = '0';
            } else {
                break;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < 8; --i, ++j) {
            if (matrix[i][j] != 'R' && matrix[i][j] != 'B') {
                matrix[i][j] = '0';
            } else {
                break;
            }
        }
    }
}
