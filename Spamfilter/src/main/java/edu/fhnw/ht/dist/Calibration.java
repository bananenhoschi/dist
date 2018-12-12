package edu.fhnw.ht.dist;

import java.io.File;

public class Calibration {

    public static double count(File directory) {

        if (directory.exists() && directory.isDirectory()) {
            if (directory.getName().matches("(ham|spam).*"))
                return directory.listFiles().length;
            else
                throw new IllegalArgumentException("Ordner ist kein Spam oder Ham Odner.");
        } else {
            throw new IllegalArgumentException("Ordner existiert nicht, oder ist kein Ordner.");
        }
    }

}
