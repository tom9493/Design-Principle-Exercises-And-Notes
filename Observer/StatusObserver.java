public class StatusObserver implements Observer {
    @Override
    public void update(Flight flight) {
        System.out.println(flight.toString());
    }
}
