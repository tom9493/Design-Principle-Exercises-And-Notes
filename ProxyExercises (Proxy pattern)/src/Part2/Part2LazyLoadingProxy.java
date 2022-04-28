package Part2;

public class Part2LazyLoadingProxy implements Part2Array2D {
    private Part2RealArray2D array;
    private String fileName;
    private boolean loaded;

    public Part2LazyLoadingProxy(String fileName) {
        array = null;
        this.fileName = fileName;
        loaded = false;
    }

    @Override
    public void set(int row, int col, int value) {
        if (!loaded) {
            array = new Part2RealArray2D(fileName);
            loaded = true;
        }
        array.set(row, col, value);
    }

    @Override
    public int get(int row, int col) {
        if (!loaded) {
            array = new Part2RealArray2D(fileName);
            loaded = true;
        }
        return array.get(row, col);
    }
}
