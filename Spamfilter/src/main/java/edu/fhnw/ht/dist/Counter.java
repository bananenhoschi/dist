package edu.fhnw.ht.dist;

public class Counter {

    Counter() {

    }

    public final double ALPHA = 0.0001;

    double spam = ALPHA;
    double ham = ALPHA;

    void incrementSpam() {
        if (this.spam == ALPHA) {
            this.spam = 0;
            this.spam++;
        }
        this.spam++;
    }


    void incrementHam() {
        if (this.ham == ALPHA) {
            this.ham = 0;
            this.ham++;
        }
        this.ham++;
    }


}
