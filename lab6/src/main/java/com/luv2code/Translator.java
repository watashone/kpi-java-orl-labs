package com.luv2code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Translator {
    private Map<String, String> dictionary;

    public Translator() {
        dictionary = new HashMap<>();
    }

    public void addWord(String english, String ukrainian) {
        dictionary.put(english.toLowerCase(), ukrainian.toLowerCase());
    }

    public String translate(String phrase) {
        StringBuilder translated = new StringBuilder();
        String[] words = phrase.toLowerCase().split("\\s+");

        for (String word : words) {
            if (dictionary.containsKey(word)) {
                translated.append(dictionary.get(word)).append(" ");
            } else {
                translated.append("[").append(word).append("]").append(" ");
            }
        }

        return translated.toString().trim();
    }
}
