package edu.fhnw.ht.dist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SpamLearner {

    private final SpamfilterLib lib;


    public SpamLearner(SpamfilterLib lib) {
        this.lib = lib;
    }

    public void learnHamWords(String dirName) {

        final File dir = new File("./data/anlern/" + dirName);

        Set<String> hamWords = MailHandler.getWords(dir);

        for (String w : hamWords) {

            lib.addHam(w);

        }
    }

    public void learnSpamWords(String dirName) {

        final File dir = new File("./data/anlern/" + dirName);

        Set<String> spamWords = MailHandler.getWords(dir);

        for (String w : spamWords) {

            lib.addSpam(w);

        }
    }





    private boolean isSpamDir(File dir) {
        return dir.getName().toLowerCase().contains("spam");
    }


}
