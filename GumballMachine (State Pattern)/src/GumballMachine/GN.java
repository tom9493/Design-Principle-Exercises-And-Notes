package GumballMachine;

public class GN implements State {
    private GumballMachine gm;

    public GN(GumballMachine gm) {
        this.gm = gm;
    }

    @Override
    public void handleTurn() {
        System.out.println("Handle turned but no quarter inserted :(");
    }

    @Override
    public Class getState() {
        return this.getClass();
    }
}
