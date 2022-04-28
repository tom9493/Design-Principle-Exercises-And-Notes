package Car;

public class ParkState implements State {
    private Car car;
    public ParkState(Car car) { this.car = car;}

    @Override
    public void putInPark() {}

    @Override
    public void putInDrive() { car.setState(new DriveState(car)); }

    @Override
    public void putInReverse() { car.setState(new ReverseState(car)); }

    @Override
    public void accelerate() {}

    @Override
    public void decelerate() {}
}
