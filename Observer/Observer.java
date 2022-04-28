public interface Observer {
    public default void update(){}

    void update(Flight flight);
}

// Print line observer
// Delta flight observer
//