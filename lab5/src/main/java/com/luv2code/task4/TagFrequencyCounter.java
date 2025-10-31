package com.luv2code.task4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class TagFrequencyCounter {

    public static Map<String, Integer> countTags(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements allTags = doc.getAllElements();

        Map<String, Integer> freqMap = new HashMap<>();
        for (Element elem : allTags) {
            String tag = elem.tagName();
            freqMap.put(tag, freqMap.getOrDefault(tag, 0) + 1);
        }

        return freqMap;
    }

    public static void printSortedByTag(Map<String, Integer> map) {
        map.keySet().stream()
                .sorted()
                .forEach(tag -> System.out.println(tag + ": " + map.get(tag)));
    }

    public static void printSortedByFrequency(Map<String, Integer> map) {
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}

