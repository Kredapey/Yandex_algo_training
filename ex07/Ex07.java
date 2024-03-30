package homework.first.ex07;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ally = scanner.nextInt();
        int barracks = scanner.nextInt();
        int enemiesPerRound = scanner.nextInt();
        int enemies = 0;
        int steps = recursiveDecision(0, ally, barracks, enemies, enemiesPerRound);
        if (steps == 0) steps = -1;
        System.out.println(steps);
    }

    public static int recursiveDecision(int steps, int ally, int barracks, int enemy, int epr) {
        int result = steps;
        int fTmpRes = 0;
        int sTmpRes = 0;
        if (barracks <= 0 && enemy <= 0) {
            return result;
        }
        if (ally <= 0) {
            return -1;
        }
        int availableAllyB = 0;
        if (barracks <= ally) {
            availableAllyB = ally - barracks;
        }
        if (barracks <= ally * 2 || steps == 0) {
            int tmpEnemyB = Math.max(enemy - availableAllyB, 0);
            int tmpBarB = Math.max(barracks - ally, 0);
            int tmpAllEnemyB = tmpBarB > 0 ? tmpEnemyB + epr : tmpEnemyB;
            fTmpRes = recursiveDecision(steps + 1, ally - tmpEnemyB, tmpBarB, tmpAllEnemyB, epr);
        }
        if (barracks > 0 && enemy == ally && steps > 0) {
            return Math.max(fTmpRes, -1);
        }
        int availableAllyE = 0;
        if (enemy <= ally) {
            availableAllyE = ally - enemy;
        }
        int tmpEnemyE = Math.max(enemy - ally, 0);
        int tmpBarE = Math.max(barracks - availableAllyE, 0);
        int tmpAllEnemyE = tmpBarE > 0 ? tmpEnemyE + epr : tmpEnemyE;
        sTmpRes = recursiveDecision(steps + 1, ally - tmpEnemyE, tmpBarE, tmpAllEnemyE, epr);
        if (sTmpRes == -1) return fTmpRes;
        if (fTmpRes == -1) return sTmpRes;
        if (sTmpRes == 0) return fTmpRes;
        if (fTmpRes == 0) return sTmpRes;
        return Math.min(fTmpRes, sTmpRes);
    }
}
