package GumballMachine;

public class NN implements State {
    private GumballMachine gm;

    public NN(GumballMachine gm) {
        this.gm = gm;
    }

    @Override
    public void handleTurn() {
        System.out.println("Handle turned but no gumballs or quarter");
    }

    @Override
    public Class getState() {
        return this.getClass();
    }
}
