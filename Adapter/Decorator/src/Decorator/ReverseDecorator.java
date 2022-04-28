package Decorator;

import StringSource.StringSourceInterface;

public class ReverseDecorator implements StringSourceInterface {
    private final StringSourceInterface ss;

    public ReverseDecorator(StringSourceInterface ss) {
        this.ss = ss;
    }

    @Override
    public String next() {
        StringBuilder sb = new StringBuilder(ss.next());
        sb.reverse();
        return sb.toString();
    }
}
