package edu.fhnw.ht.dist;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class AppStarter {


    private static SpamfilterLib lib;
    private final static Set<File> detectedSpamMails = new HashSet<>();
    private final static Set<File> testedMails = new HashSet<>();

    public static void main(String[] args) {

        lib = new SpamfilterLib();

        System.out.println("--------- Anlernen ---------");
        SpamLearner spamLearner = new SpamLearner(lib);
        System.out.println("Ham Wörter lernen");
        spamLearner.learnHamWords("ham-anlern");
        System.out.println("Spam Wörter lernen");
        spamLearner.learnSpamWords("spam-anlern");
        System.out.println("Gelernt: Spam-Wörter " + lib.countSpamWords() + ", Ham-Wörter " + lib.countHamWords());
        System.out.println("--------- Ende: Anlernen ---------");

        System.out.println("\n");

        System.out.println("--------- Testen ---------");
        File spamTestDir = new File("./data/test/spam-test");
        testMails(spamTestDir);
        System.out.println("\n--------- Zusammenfassung ---------\n");
        double totalMailsTested = testedMails.size();
        double totalSpamMailsDetected = detectedSpamMails.size();
        double totalHamMailsDetected = totalMailsTested - totalSpamMailsDetected;

        System.out.println(String.format(" gefundene Spam-Mails ✗: " + totalSpamMailsDetected + " -> %s", (totalSpamMailsDetected / totalMailsTested) * 100));
        System.out.println(String.format(" gefundene Ham-Mails  ✓: " + totalHamMailsDetected + " -> %s", (totalHamMailsDetected / totalMailsTested) * 100));
        System.out.println();

        testedMails.clear();
        detectedSpamMails.clear();

        File hamTestDir = new File("./data/test/ham-test");
        testMails(hamTestDir);
        System.out.println("\n--------- Zusammenfassung ---------\n");
        totalMailsTested = testedMails.size();
        totalSpamMailsDetected = detectedSpamMails.size();
        totalHamMailsDetected = totalMailsTested - totalSpamMailsDetected;

        System.out.println(String.format(" gefundene Spam-Mails ✗: " + totalSpamMailsDetected + " -> %s", (totalSpamMailsDetected / totalMailsTested) * 100));
        System.out.println(String.format(" gefundene Ham-Mails  ✓: " + totalHamMailsDetected + " -> %s", (totalHamMailsDetected / totalMailsTested) * 100));
        System.out.println();

        System.out.println("--------- Ende: Testen ---------");


    }


    private static void testMails(File dir) {

        System.out.println("Teste: " + dir.getPath());

        File[] files = dir.listFiles();


        SpamDetector detector = new SpamDetector(lib);


        for (File f : files) {

            testedMails.add(f);

            double prob = detector.detect(f);
            if (prob >= 0.5) {
                //System.out.println(String.format("SPAM: " + f.getName() + ": Probability = %s", Double.valueOf(prob).toString()));
                detectedSpamMails.add(f);
            } else {
                //System.out.println(String.format("HAM: " + f.getName() + ": Probability = %s", Double.valueOf(prob).toString()));
            }
        }
    }

}
