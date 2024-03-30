package homework.first.ex02;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        int expectedGoals = 0;
        Scanner scanner = new Scanner(System.in);
        String firstScore = scanner.nextLine();
        String secondScore = scanner.nextLine();
        int location = scanner.nextInt();
        String[] firstMatch = firstScore.split(":");
        String[] secondMatch = secondScore.split(":");
        int ftfmScore = Integer.parseInt(firstMatch[0]);
        int stfmScore = Integer.parseInt(firstMatch[1]);
        int ftsmScore = Integer.parseInt(secondMatch[0]);
        int stsmScore = Integer.parseInt(secondMatch[1]);
        int overallScoreFirst = ftfmScore + ftsmScore;
        int overallScoreSecond = stfmScore + stsmScore;
        int guestGoalsFirst = location == 1 ? ftsmScore : ftfmScore;
        int guestGoalsSecond = location == 1 ? stfmScore : stsmScore;
        if (overallScoreFirst == overallScoreSecond) {
            if (guestGoalsFirst <= guestGoalsSecond) {
                expectedGoals = 1;
            }
        } if (overallScoreFirst < overallScoreSecond) {
            expectedGoals = overallScoreSecond - overallScoreFirst;
            if (location == 1) {
                guestGoalsFirst += expectedGoals;
                if (guestGoalsFirst <= guestGoalsSecond)
                    expectedGoals += 1;
            } else if (location == 2) {
                if (guestGoalsFirst <= guestGoalsSecond)
                    expectedGoals += 1;
            }
        }
        System.out.println(expectedGoals);
        scanner.close();
    }
}
