package homework.first.ex09;

import java.util.*;

public class Ex09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int holidayCount = scanner.nextInt();
        int year = scanner.nextInt();
        int days = dayCount(year);
        String[] holidays = new String[holidayCount];
        for (int i = 0; i < holidayCount; ++i) {
            int num = scanner.nextInt();
            String mon = scanner.nextLine();
            holidays[i] = weekDay(num, mon, year);
        }
        Map<String, Integer> week = fillMap();
        String firstDay = scanner.next();
        determineDays(firstDay, days, week);
        String max = "";
        String min = "";
        int maxDays = 0;
        int minDays = 0;
        for (Map.Entry<String, Integer> entry : week.entrySet()) {
            for (String h : holidays) {
                if (h.equals(entry.getKey())) {
                    week.replace(h, entry.getValue() - 1);
                }
            }
            if (max.isEmpty()) {
                max = entry.getKey();
                min = entry.getKey();
                maxDays = entry.getValue();
                minDays = entry.getValue();
            } else {
                if (maxDays < entry.getValue()) {
                    maxDays = entry.getValue();
                    max = entry.getKey();
                }
                if (minDays > entry.getValue()) {
                    minDays = entry.getValue();
                    min = entry.getKey();
                }
            }
        }
        System.out.println(max + " " + min);
        scanner.close();
    }

    public static int dayCount(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return 366;
        } else {
            return 365;
        }
    }

    public static String weekDay(int day, String month, int year) {
        String result;
        int monCode = monthCode(month);
        int yearVal = yearVal(year);
        int tmpYear = year;
        int lastNums = tmpYear % 10;
        tmpYear /= 10;
        lastNums = lastNums + (tmpYear % 10) * 10;
        int yearCode = (yearVal + lastNums + lastNums / 4) % 7;
        int weekDay = (day + monCode + yearCode) % 7;
        if (dayCount(year) == 366 && (month.equals(" January") || month.equals(" February"))) {
            if (weekDay > 0) {
                weekDay -= 1;
            } else {
                weekDay = 6;
            }
        }
        result = changeNums(weekDay);
        return result;
    }

    public static int monthCode(String month) {
        return switch (month) {
            case " January", " October" -> 1;
            case " February", " March", " November" -> 4;
            case " April", " July" -> 0;
            case " May" -> 2;
            case " June" -> 5;
            case " August" -> 3;
            case " September", " December" -> 6;
            default -> -1;
        };
    }

    public static int yearVal(int year) {
        int code = 0;
        if (year >= 1800 && year < 1900) {
            code = 2;
        } else if (year >= 1900 && year < 2000) {
            code = 0;
        } else if (year >= 2000 && year < 2100) {
            code = 6;
        } else if (year == 2100) {
            code = 4;
        }
        return code;
    }

    public static String changeNums(int num) {
        return switch (num) {
            case 0 -> "Saturday";
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            default -> "";
        };
    }

    public static Map<String, Integer> fillMap() {
        Map<String, Integer> week = new HashMap<>();
        week.put("Monday", 52);
        week.put("Tuesday", 52);
        week.put("Wednesday", 52);
        week.put("Thursday", 52);
        week.put("Friday", 52);
        week.put("Saturday", 52);
        week.put("Sunday", 52);
        return week;
    }

    public static void determineDays(String firstDay, int days, Map<String, Integer> week) {
        if (firstDay.equals("Monday")) {
            week.replace("Monday", 53);
            if (days == 366) {
                week.replace("Tuesday", 53);
            }
        } else if (firstDay.equals("Tuesday")) {
            week.replace("Tuesday", 53);
            if (days == 366) {
                week.replace("Wednesday", 53);
            }
        } else if (firstDay.equals("Wednesday")) {
            week.replace("Wednesday", 53);
            if (days == 366) {
                week.replace("Thursday", 53);
            }
        } else if (firstDay.equals("Thursday")) {
            week.replace("Thursday", 53);
            if (days == 366) {
                week.replace("Friday", 53);
            }
        } else if (firstDay.equals("Friday")) {
            week.replace("Friday", 53);
            if (days == 366) {
                week.replace("Saturday", 53);
            }
        } else if (firstDay.equals("Saturday")) {
            week.replace("Saturday", 53);
            if (days == 366) {
                week.replace("Sunday", 53);
            }
        } else if (firstDay.equals("Sunday")) {
            week.replace("Sunday", 53);
            if (days == 366) {
                week.replace("Monday", 53);
            }
        }
    }
}
