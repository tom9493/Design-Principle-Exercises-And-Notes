package Part1;

import Part1.Part1ProxyInterface;

public class Part1RealClass implements Part1ProxyInterface {
    @Override
    public void printHello() {
        System.out.println("Hello");
    }

    @Override
    public void printGoodbye() {
        System.out.println("Goodbye");
    }
}
