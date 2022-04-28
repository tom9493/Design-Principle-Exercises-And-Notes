package Decorator;

import StringSource.StringSourceInterface;

public class AppendDecorator implements StringSourceInterface {
    private final StringSourceInterface ss;
    private final String append;

    public AppendDecorator(StringSourceInterface ss, String append) {
        this.ss = ss;
        this.append = append;
    }

    @Override
    public String next() {
        return ss.next() + append;
    }
}
