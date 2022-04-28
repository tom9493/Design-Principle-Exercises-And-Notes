package Car;

public class DriveState implements State {
    private Car car;
    public DriveState(Car car) { this.car = car;}

    @Override
    public void putInPark() {
        if (car.speed == 0) { car.setState(new ParkState(car)); }
    }

    @Override
    public void putInDrive() {}

    @Override
    public void putInReverse() {
        if (car.speed == 0) { car.setState( new ReverseState(car)); }
    }

    @Override
    public void accelerate() { car.changeSpeed(1); }

    @Override
    public void decelerate() { car.changeSpeed(-1); }
}
