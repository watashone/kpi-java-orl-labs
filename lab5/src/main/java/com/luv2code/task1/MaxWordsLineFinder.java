package com.luv2code.task1;

import java.io.IOException;
import java.util.List;

public class MaxWordsLineFinder {

    public static String findLineWithMaxWords(List<String> lines) {
        String resultLine = "";
        int maxWords = 0;

        for (String line : lines) {
            int wordCount = line.trim().split("\\s+").length;
            if (wordCount > maxWords) {
                maxWords = wordCount;
                resultLine = line;
            }
        }
        return resultLine;
    }
}


