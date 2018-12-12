package edu.fhnw.ht.dist;

import java.io.File;
import java.util.Set;

public class SpamDetector {

    private final SpamfilterLib lib;

    private final double ALPHA = 0.00001;

    public SpamDetector(SpamfilterLib lib) {
        this.lib = lib;
    }

    public double detect(File f) {

        int hams = lib.countHamWords();
        int spams = lib.countSpamWords();

        double result = 1;

        Set<String> words = MailHandler.getWords(f);

        for (String word : words) {


            Integer numOfHamCount = lib.wordInSpamWords(word);
            Integer numOfSpamCount = lib.wordInHamWords(word);

            if (numOfHamCount == null && numOfSpamCount == null) {
                continue;
            }


            double spamProbability = (numOfSpamCount == null ? ALPHA : numOfSpamCount) / spams;
            double hamProbability = (numOfHamCount == null ? ALPHA : numOfHamCount) / hams;

            result *= (hamProbability / spamProbability);


        }
        return result;
    }
}
