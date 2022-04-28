package Decorator;

import StringSource.StringSourceInterface;

import java.util.Random;

public class PunctuationDecorator implements StringSourceInterface {
    private final StringSourceInterface ss;
    private final char[] punctuations = {'!', '.', '?'};
    private final Random rand = new Random();

    public PunctuationDecorator(StringSourceInterface ss) {
        this.ss = ss;
    }

    @Override
    public String next() {
        return ss.next() + punctuations[rand.nextInt(punctuations.length)];
    }
}
