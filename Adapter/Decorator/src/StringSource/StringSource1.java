package StringSource;

public class StringSource1 implements StringSourceInterface {
    private final DummyData dummyData = new DummyData();

    @Override
    public String next() {
        return "The " + getNoun() + " " + getVerb() + " the " + getNoun() + " " + getAdjective();
    }

    String getNoun() { return dummyData.getRandomNoun(); }
    String getVerb() { return dummyData.getRandomVerb(); }
    String getAdjective() { return dummyData.getRandomAdjective(); }
}
