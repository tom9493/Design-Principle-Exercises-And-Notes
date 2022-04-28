package Car;

public interface State {
    public abstract void putInPark();
    public abstract void putInDrive();
    public abstract void putInReverse();
    public abstract void accelerate();
    public abstract void decelerate();
}
