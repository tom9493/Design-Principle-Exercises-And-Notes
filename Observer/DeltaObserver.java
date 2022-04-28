public class DeltaObserver implements Observer {
    Flight prevFlight = null;

    @Override
    public void update(Flight flight) {
        if (prevFlight != null) {
            System.out.println("Difference since last flight: ");
            System.out.println("Longitude: " + (prevFlight.longitude - flight.longitude));
            System.out.println("Latitude: " + (prevFlight.latitude - flight.latitude));
            System.out.println("Longitude: " + (prevFlight.velocity - flight.velocity));
            System.out.println("Longitude: " + (prevFlight.geo_altitude - flight.geo_altitude));
        }
        prevFlight = flight;
    }
}
