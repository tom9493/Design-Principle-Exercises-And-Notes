public class Algorithms<K extends Comparable<K>> {

    public static <K extends Comparable<K>> Stats calcStats(K[] array) {
        Stats stats = new Stats();
        for (K val: array) {
            if (stats.max == null) { stats.max = val; }
            if (stats.min == null) { stats.min = val; }
            if (stats.max.compareTo(val) < 0) { stats.max = val; }
            else if (stats.min.compareTo(val) > 0) { stats.min = val; }
        }
        return stats;
    }

    public static void main(String[] args) {
        String[] strArr = new String[]{"z", "a", "m"};
        Stats strStats = Algorithms.calcStats(strArr);
        System.out.println(String.format("min: %s, max: %s",
                strStats.min, strStats.max));

        Integer[] intArr = new Integer[]{10000, 33, -22};
        Stats<Integer> intStats = Algorithms.calcStats(intArr);
        System.out.println(String.format("min: %d, max: %d", intStats.min, intStats.max));
    }

    public static class Stats<K extends Comparable<K>> {
        public K max;
        public K min;

        Stats() {
            this.max = null;
            this.min = null;
        }
    }
}
