package edu.fhnw.ht.dist;

import java.util.HashMap;

public class SpamfilterLib {


    private HashMap<String, Integer> spamWords = new HashMap<>();
    private HashMap<String, Integer> hamWords = new HashMap<>();


    public void addSpam(String word) {
        if (spamWords.containsKey(word)) {
            spamWords.put(word, spamWords.get(word) + 1);
        } else {
            spamWords.put(word, 1);
        }
    }

    public void addHam(String word) {
        if (hamWords.containsKey(word)) {
            hamWords.put(word, hamWords.get(word) + 1);
        } else {
            hamWords.put(word, 1);
        }
    }

    public int countHamWords() {
        return hamWords.size();
    }

    public int countSpamWords() {
        return spamWords.size();
    }

    public Integer wordInSpamWords(String w) {
        return spamWords.get(w);
    }

    public Integer wordInHamWords(String w) {
        return hamWords.get(w);
    }

    public boolean isHamWord(String word) {
        return hamWords.containsKey(word);
    }

    public boolean isSpamWord(String word) {
        return spamWords.containsKey(word);
    }
}
