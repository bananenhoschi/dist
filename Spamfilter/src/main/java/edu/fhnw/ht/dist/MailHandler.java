package edu.fhnw.ht.dist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MailHandler {

    private MailHandler() {
    }


    public static Set<String> getWords(File file) {

        Set<String> words = new HashSet<>();

        if (file.isDirectory()) {
            Arrays.stream(file.listFiles()).forEach(f -> {
                tokenizeMailContent(f, words);
            });
        } else {
            tokenizeMailContent(file, words);

        }
        return words;
    }

    private static void tokenizeMailContent(File file, Set<String> words) {
        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Arrays.stream(line.split(" ")).forEach(words::add);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
    }

}
