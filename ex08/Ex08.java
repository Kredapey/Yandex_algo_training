package homework.first.ex08;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long circleLen = scanner.nextInt();
        long startA = scanner.nextInt();
        long speedA = scanner.nextInt();
        long startB = scanner.nextInt();
        long speedB = scanner.nextInt();
        double time;
        if (startA > startB) {
            long tempPoint = startA;
            startA = startB;
            startB = tempPoint;
            long tempSpeed = speedA;
            speedA = speedB;
            speedB = tempSpeed;
        }
        boolean result;
        time = findResPoints(circleLen, speedA, speedB, startA, startB);
        result = time >= 0;
        time = findCrossPoint(circleLen, speedA, speedB, startA, startB, time);
        if (result) {
            System.out.println("yes");
            System.out.println(time);
        } else {
            System.out.println("no");
        }
    }

    public static double findResPoints(long circleLen, long speedA, long speedB, long startA, long startB) {
        double time;
        if ((speedA + speedB != 0) && (startA != startB)) {
            double tmpTimeFirst = 0;
            double tmpTimeSecond = 0;
            int count = 0;
            while (tmpTimeFirst <= 0 && tmpTimeSecond <= 0) {
                double distBtwStarts = (startA + startB) % circleLen;
                tmpTimeFirst = (count * circleLen - distBtwStarts) / (double) (speedA + speedB);
                tmpTimeSecond = (-count * circleLen - distBtwStarts) / (double) (speedA + speedB);
                count += 1;
            }
            if (tmpTimeFirst * tmpTimeSecond > 0) {
                time = Math.min(tmpTimeFirst, tmpTimeSecond);
            } else {
                time = Math.max(tmpTimeFirst, tmpTimeSecond);
            }
        } else {
            if ((startA + startB) % circleLen == 0 || startA == startB) {
                time = 0;
            } else {
                if (speedA == 0 && speedB == 0) {
                    time = -1;
                } else {
                    if (speedA < 0) {
                        time = (circleLen - startB + startA) / (double) (speedB - speedA);
                    } else {
                        time = (startB - startA) / (double) (speedA - speedB);
                    }
                }
            }
        }
        return time;
    }

    public static double findCrossPoint(long circleLen, long speedA, long speedB, long startA, long startB, double prevTime) {
        double time = prevTime;
        if (speedA != speedB && time >= 0) {
            double tmpTimeFirst = 0;
            double tmpTimeSecond = 0;
            int count = 0;
            while (tmpTimeFirst <= 0 && tmpTimeSecond <= 0) {
                tmpTimeFirst = (count * circleLen - (startA - startB)) / (double) (speedA - speedB);
                tmpTimeSecond = (-count * circleLen - (startA - startB)) / (double) (speedA - speedB);
                count += 1;
            }
            double tempT;
            if (tmpTimeFirst * tmpTimeSecond > 0) {
                tempT = Math.min(tmpTimeFirst, tmpTimeSecond);
            } else {
                tempT = Math.max(tmpTimeFirst, tmpTimeSecond);
            }
            time = Math.min(tempT, prevTime);
        }
        return time;
    }
}

