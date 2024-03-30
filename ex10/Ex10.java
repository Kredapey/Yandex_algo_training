package homework.first.ex10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Ex10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line;
        line = reader.readLine();
        String[] arr = line.split(" ");
        int docWidth = Integer.parseInt(arr[0]);
        int lineHeight = Integer.parseInt(arr[1]);
        int charW = Integer.parseInt(arr[2]);
        List<String> paragraphs = new ArrayList<>();
        int countP = 0;
        int lineCount = 0;
        while ((line = reader.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                if (lineCount == 0) {
                    paragraphs.add("");
                }
                paragraphs.set(countP, paragraphs.get(countP) + line);
                lineCount += 1;
            } else {
                countP += 1;
                lineCount = 0;
            }
        }
        int x = 0;
        int y = 0;
        for (String one : paragraphs) {
            String[] split = one.split("[()]");
            int curLineWidth = 0;
            int curHeightFile = 0;
            int curLineHeight = lineHeight;
            for (String s : split) {
                if (s.startsWith("image") && s.contains("layout") && s.contains("width") && s.contains("height")) {

                } else {
                    int lineWidthRemain = docWidth - curLineWidth;
                }
            }
        }

        for (String s : paragraphs) {
            System.out.println("HEre");
            System.out.println(s);
        }
    }
}
