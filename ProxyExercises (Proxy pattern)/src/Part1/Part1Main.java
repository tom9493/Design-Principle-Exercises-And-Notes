package Part1;

public class Part1Main {
    private static final Part1ProxyClass proxyClass = new Part1ProxyClass();

    public static void main(String[] args) throws Exception {
        proxyClass.printHello();
        proxyClass.printGoodbye();
    }
}
