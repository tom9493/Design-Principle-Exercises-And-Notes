package Part2;

public class Part2Main {
    public static void main(String[] args) throws Exception {
        Part2RealArray2D array = new Part2RealArray2D(5, 5);
        String fileName = "C:/Users/Thomas/AppData/Roaming/JetBrains/IdeaIC2021.3/scratches/scratch_4.txt";

        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                array.set(i, j, i+j);
            }
        }

        array.save(fileName);

        Part2LazyLoadingProxy proxy = new Part2LazyLoadingProxy(fileName);

        System.out.println(proxy.get(0,0));
        System.out.println(proxy.get(4,4));

        proxy.set(0, 0, 1000);
        proxy.set(4,4, 1000);

        System.out.println(proxy.get(0,0));
        System.out.println(proxy.get(4,4));
    }
}
