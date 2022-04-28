
public class FlightMonitor {
	
	public static void main(String[] args) {
	
		FlightFeed feed = new FlightFeed();
		StatusObserver SO = new StatusObserver();
		DeltaObserver DO = new DeltaObserver();
		feed.add(SO);
		feed.add(DO);
		feed.start();
	}
	
}