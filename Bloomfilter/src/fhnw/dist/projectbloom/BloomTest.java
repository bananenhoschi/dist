package fhnw.dist.projectbloom;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BloomTest {

    int falsePositives = 0;

    List<String> words = new ArrayList<>();

    @Before
    public void init() throws FileNotFoundException {
        falsePositives = 0;
        File wordFile = new File(Main.class.getResource("data/words.txt").getFile());
        try (Scanner scanner = new Scanner(wordFile)) {
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine());
            }
        }
    }


    private void evaluate(double p, List<String> testStrings) {

        System.out.println(falsePositives);
        System.out.println("expected p=" + p);
        System.out.println("actual   p=" + MessageFormat.format("{0,number,#.#########}", (double) falsePositives / (double) testStrings.size()));

    }

    @Test
    public void test() {

        double p = 0.01;
        int n = words.size();



    }

    public void wenigWoerterGrossesArray() {

    }

    public void wenigWoerterKleinesArray() {

    }

    public void vieleWoerterKleinesArray() {

    }

    public void vieleWoerterGrossesArray() {

    }


    private List<String> generateRandomWords(int num, int max) {

        List<String> words = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            words.add(RandomStringUtils.randomAlphabetic(3, max));

        }
        return words;
    }
}
