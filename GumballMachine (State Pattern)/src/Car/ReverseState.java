package Car;

public class ReverseState implements State {
    private Car car;
    public ReverseState(Car car) { this.car = car;}

    @Override
    public void putInPark() {
        if (car.speed == 0) { car.setState(new ParkState(car)); }
    }

    @Override
    public void putInDrive() {
        if (car.speed > 0) { car.setState(new DriveState(car)); }
    }

    @Override
    public void putInReverse() {}

    @Override
    public void accelerate() { car.changeSpeed(-1); }

    @Override
    public void decelerate() { car.changeSpeed(1); }
}
