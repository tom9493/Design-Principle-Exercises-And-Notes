package StringSource;

public class StringSource2 implements StringSourceInterface {
    private final DummyData dummyData = new DummyData();

    @Override
    public String next() {
        return "Ever so " + getAdjective() + ", the " + getNoun() + " " + getVerb() + " the " + getNoun();
    }

    String getNoun() { return dummyData.getRandomNoun(); }
    String getVerb() { return dummyData.getRandomVerb(); }
    String getAdjective() { return dummyData.getRandomAdjective(); }
}
