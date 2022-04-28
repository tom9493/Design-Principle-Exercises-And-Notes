package Car;

public class Car implements State {
    private State state;
    public int speed;

    public Car() { this.state = new ParkState(this); }

    @Override
    public void putInPark() { state.putInPark(); }

    @Override
    public void putInDrive() { state.putInDrive(); }

    @Override
    public void putInReverse() { state.putInReverse(); }

    @Override
    public void accelerate() { state.accelerate(); }

    @Override
    public void decelerate() { state.decelerate(); }

    public void changeSpeed(int value) { speed += value; }

    public void setState(State state) { this.state = state; }
}
