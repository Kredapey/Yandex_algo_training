package homework.first.ex01;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vtn = scanner.nextInt();
        int vs = scanner.nextInt();
        int mtn = scanner.nextInt();
        int ms = scanner.nextInt();
        int treeCounter;
        if ((vtn - vs) > (mtn + ms) || (mtn - ms) > (vtn + vs)) {
            treeCounter = (vs + ms + 1) * 2;
        } else {
            treeCounter = (Math.max(vtn + vs, mtn + ms)) - (Math.min(vtn - vs, mtn - ms)) + 1;
        }
        System.out.print(treeCounter);
        scanner.close();
    }
}
