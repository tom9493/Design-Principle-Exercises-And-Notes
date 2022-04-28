package GumballMachine;

public class NQ implements State {
    private GumballMachine gm;

    public NQ(GumballMachine gm) {
        this.gm = gm;
    }

    @Override
    public void handleTurn() {
        System.out.println("Handle turned and quarter accepted! No gumballs to dispense though :(");
        gm.increaseProfit();
        gm.changeState(new NN(gm));
    }

    @Override
    public Class getState() {
        return this.getClass();
    }
}
