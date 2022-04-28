public class Maximizer<T extends Comparable<T>> {
    private T value;

    private void updateValue(T newVal) {
        if (value == null) { value = newVal; }
        if (newVal.compareTo(value) > 0) { value = newVal; }
    }

    private T getValue() { return value; }

    public static void main(String[] args) {
        Maximizer<String> strMaximizer = new Maximizer<>();
        strMaximizer.updateValue("a");
        strMaximizer.updateValue("z");
        strMaximizer.updateValue("m");
        String maxStr = strMaximizer.getValue();
        System.out.println(maxStr);

        Maximizer<Integer> intMaximizer = new Maximizer<>();
        intMaximizer.updateValue(-22);
        intMaximizer.updateValue(10000);
        intMaximizer.updateValue(33);
        Integer maxInt = intMaximizer.getValue();
        System.out.println(maxInt);
    }
}
